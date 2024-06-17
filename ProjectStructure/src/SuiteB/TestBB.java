package SuiteB;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestBB extends testBase{
	@Test(groups= {"sanity"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteB")		
public void testBB(String browser,String username, String password) throws InterruptedException {
		log("Stating BB");
		log(username+"-----"+password);
	Thread.sleep(2000);
	log("Ending BB");
	}

}
