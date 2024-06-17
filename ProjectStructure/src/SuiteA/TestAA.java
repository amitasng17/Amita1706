package SuiteA;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestAA extends testBase{

	@Test(groups= {"smoke"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteA")	
public void testAA(String browser,String username, String password) throws InterruptedException {
		log("Stating AA");
		log(username+"-----"+password);
	Thread.sleep(2000);
	log("Ending AA");
	}

}
