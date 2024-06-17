package rediff.testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.basetest;
import keywords.ApplicationKeywords;

public class Session extends basetest{
	
@Test
public void doLogin(ITestContext con) throws InterruptedException {
System.out.println("Logging in");
app.log("Logging in");
app.log("Logging in");
app.LaunchBrowser("Chrome");
app.navigateurl("url");
app.type("username_id","er_amita");	
//app.reportFailure("Text is incorrect",false);
app.type("password_xpath","Rediff@12");
app.WaitForPagetoLoad();
app.ValidateElementPresent("login_button_id");
app.click("login_button_id");

}

@Test
public void doLogOut() {
System.out.println("Logging out");	
app.log("Logging out");
}

}
