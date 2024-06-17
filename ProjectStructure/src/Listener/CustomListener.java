package Listener;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
	System.out.println("------test passed-----");
	result.getName();
	result.getStatus();
	//result.getThrowable().getMessage();
	ExtentTest test=(ExtentTest) result.getAttribute("reporter");
	test.log(Status.PASS,"Test Passed"+result.getName());
		
	}
	
public void onTestFailure(ITestResult result) {
	System.out.println("-----test failed------");		
	System.out.println(result.getName());
	System.out.println(result.getStatus());
	System.out.println(result.getThrowable().getMessage());	
	ExtentTest test=(ExtentTest) result.getAttribute("reporter");
	test.log(Status.FAIL,result.getThrowable().getMessage());
	}
	

}
