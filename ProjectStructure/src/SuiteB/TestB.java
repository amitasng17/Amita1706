package SuiteB;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestB extends testBase{

	@Test(groups= {"sanity"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteB")		
public void testB(String browser,String username, String password) throws InterruptedException {
		log("Stating B");	
		log(username+"-----"+password);
	Thread.sleep(2000);
	log("Ending B");
	}

}
