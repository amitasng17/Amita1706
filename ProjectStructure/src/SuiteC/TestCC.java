package SuiteC;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestCC extends testBase{
	@Test(groups= {"smoke"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteC")		
public void testCC(String browser,String username, String password) throws InterruptedException {
		log("Stating CC");	
		log(username+"-----"+password);
		log("Executing the test on"+ browser);
	Thread.sleep(2000);
	log("Ending CC");
	}
}
