package testbase;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class testBase {
	
	public ExtentReports rep;
	public ExtentTest test;
	public SoftAssert softassert;
	public String browser;
	
	@BeforeMethod(alwaysRun=true)
	public void init(ITestResult result, ITestContext con) {
		rep= ExtentManager.getReports();
		test=rep.createTest(result.getMethod().getMethodName().toUpperCase());
		result.setAttribute("reporter",test);
		softassert=new SoftAssert();
		browser=con.getCurrentXmlTest().getParameter("browser");
		System.out.println(browser);
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void quit() {
		rep.flush();
	}
	
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO,msg);
	}
	
	public void logFailure(String msg) {//only fails in Extent Reports
		System.out.println(msg);
		test.log(Status.FAIL, msg);
	}
	
	public void softAssert(String msg) {//will fail in both testng and extent reports but will continue
	logFailure(msg);
	softassert.fail(msg);
	}
	
	public void FailAndStopTest(String msg) {//will fail in both testng and extent reports but will continue
		logFailure(msg);//fail in Extent report
		softassert.fail(msg);//fail in test ng
		softassert.assertAll();//stop and fail the test
		}

}
