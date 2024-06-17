package rediff.testcases;

import java.text.ParseException;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.basetest;

public class StockManagement extends basetest{

@Test
public void addStock(ITestContext context) throws InterruptedException, ParseException {
	  String stockName="Birla Corporation Ltd.";
	  String purchaseDate="02/05/2024";
	  String Quantity="100";
	  String Price="500";
	  app.log("Adding stockQuantity "+ Quantity+"of "+stockName);
	  int quantityBeforeModification=app.findCurrentStockQuantity(stockName);
	  context.setAttribute("quantityBeforeModification", quantityBeforeModification);
	  app.click("addStockBtn_css");
	  app.selectCompany(stockName,"stockName_xpath");
	  app.click("dateSelection_xpath");
	  app.wait(5);
	  app.selectDateFromCalendar(purchaseDate);
	  app.type("stockQty_xpath", Quantity);
	  app.type("stockPrice_xpath",Price);
	  app.click("addStockBtn_xpath");
	  app.WaitForPagetoLoad();
}

@Parameters({"action"})
@Test
public void modifyStock(ITestContext context,String action) throws InterruptedException, ParseException {
	String stockName="Birla Corporation Ltd.";
	  String purchaseDate="02/05/2024";
	  String Quantity="100";
	  String Price="500";
	  app.log("Adding stockQuantity "+ Quantity+"of "+stockName);
	  int quantityBeforeModification=app.findCurrentStockQuantity(stockName);
	  context.setAttribute("quantityBeforeModification", quantityBeforeModification);
	  app.goToBuySell(stockName);
	  //equityaction_id=equityaction
	  if(action.equals("sellstock"))
	      app.selectByVisibleText("equityaction_id", "Sell");
	  else
	      app.selectByVisibleText("equityaction_id", "Buy");
	     //buySellCalendar_id=buySellCalendar		
	     app.click("buySellCalendar_id");
	     app.log("Selecting Date "+ purchaseDate);
	     app.selectDateFromCalendar(purchaseDate);
	     //buysellqty_id=buysellqty
	     app.type("buysellqty_id", Quantity);
	     //buysellprice_id=buysellprice
	     app.type("buysellprice_id", Price);
	     //buySellStockButton_id=buySellStockButton
	     app.click("buySellStockButton_id");
	     app.WaitForPagetoLoad();
	     app.log("Stock Sold ");	
}

@Test
public void VerifyStockPresent() {
	String companyName = "Birla Corporation Ltd";
 int rowNum=app.getRowWithCellData("stockTable_xpath",companyName);
 if(rowNum==-1)
   app.reportFailure("Stock not present" + companyName,true);
 app.log("Stock present in the table "+ companyName);
}

@Parameters({"action"})
@Test
public void VerifyStockQuantity(String action, ITestContext context) {
  String stockName="Birla Corporation Ltd.";
  String purchaseDate="02/05/2024";
  String Quantity="100";
  String Price="500";
  int quantityAfterModification=app.findCurrentStockQuantity(stockName);
  int quantityBeforeModification=(Integer)context.getAttribute("quantityBeforeModification");
  int modifiedQuantity=Integer.parseInt(Quantity);
  int expectedModifiedQuantity=0;
  if(action.equals("sellstock"))
	  expectedModifiedQuantity=quantityBeforeModification-quantityAfterModification;
     
  else 
	  expectedModifiedQuantity=quantityAfterModification-quantityBeforeModification;
  if (expectedModifiedQuantity!=modifiedQuantity)
     app.reportFailure("Quantity did not match", true);
  app.log("Stock quantity changes as expected" + modifiedQuantity);
}

@Parameters({"action"})
@Test
public void verifyTransactionHistory(String action){
  String companyName="Birla Corporation Ltd.";
  String purchaseDate="02/05/2024";
  String stockQuantity="100";
  String stockPrice="500";
  app.log("Verifying transaction history for "+companyName +"for "+action);
  app.goToTransactionHistory(companyName);
  // noofshares_xpath=//div[@id='transcations']/table[@class='dataTable']/tbody/tr/td[3]
  String noOfShares=app.gettext("noofshares_xpath");
  if(action.equals("sellstock"))
      stockQuantity="-"+stockQuantity;
  if(!noOfShares.equals(stockQuantity))
     app.reportFailure("The quantity in the transaction history is not correct", true);
  app.log("Transaction History shows correct value");
}


}
