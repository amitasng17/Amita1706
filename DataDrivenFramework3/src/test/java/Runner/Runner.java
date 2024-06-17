package Runner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		MyTestNGRunner TestNG=new MyTestNGRunner(1);
		TestNG.CreateSuite("StockManagement",false);
		//TestNG.addListener("Listener.MyTestNGListener");
		TestNG.AddTest("Add New Stock Test");
		TestNG.addParameter("action", "addstock");
		List<String> includedMethods=new ArrayList<String>();
		includedMethods.add("doLogin");
		TestNG.AddTestClass("rediff.testcases.Session", includedMethods);
		includedMethods=new ArrayList<String>();
		includedMethods.add("selectPortFolio");
		TestNG.AddTestClass("rediff.testcases.PortfolioManagement", includedMethods);
		includedMethods=new ArrayList<String>();
		includedMethods.add("addStock");
		includedMethods.add("VerifyStockPresent");
		includedMethods.add("VerifyStockQuantity");
		includedMethods.add("verifyTransactionHistory");
		TestNG.AddTestClass("rediff.testcases.StockManagement", includedMethods);
		TestNG.run();

	}

}

