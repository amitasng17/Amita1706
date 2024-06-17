package SuiteC;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestC extends testBase{
	@Test(groups= {"sanity"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteC")		
public void testC(String browser,String username, String password) throws InterruptedException {
		log("Stating C");	
		log(username+"-----"+password);
		log("Executing the test on"+ browser);
	Thread.sleep(2000);
	log("Ending C");
	}
}
