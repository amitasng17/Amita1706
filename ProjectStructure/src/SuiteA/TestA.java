package SuiteA;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.testBase;

public class TestA extends testBase {
	
@Test(groups= {"smoke"},dataProviderClass=TestDataProvider.class, dataProvider="dataSuiteA")		
public void testA(String browser,String username,String password ) throws InterruptedException {
log("Stating A");	
log(username+"-----"+password);
if(!"Title1".equals("title")) {
	softAssert("titles do not match");
	};
	
	log("Logging in Application");
	log("starting Application");
	if(!"text1".equals("text")) {
		softAssert("text do not match");
		};	
softassert.assertEquals("title", "title1");
if(!"a".equals("b" )) {
	FailAndStopTest("A Doesnt match B");
}
//Assert.fail("Some error message");
Thread.sleep(2000);
log("Ending A");
softassert.assertAll();

}

}
