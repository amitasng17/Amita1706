package dataprovider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
@DataProvider	
public static Object[][] dataSuiteA(Method m,ITestContext con) {
	Object data[][]=null;
	String browsers[]=con.getCurrentXmlTest().getParameter("browsers").split(",");
	if(m.getName().toUpperCase().equals("TESTA")) {
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";
	}else if(m.getName().toUpperCase().equals("TESTAA")) {
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";
	}	

	return data;
}

@DataProvider	
public static Object[][] dataSuiteB(Method m,ITestContext con) {
	String browsers[]=con.getCurrentXmlTest().getParameter("browsers").split(",");

	Object data[][]=null;
	if(m.getName().toUpperCase().equals("TESTB")) {
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";
	}else if(m.getName().toUpperCase().equals("TESTBB")) {
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";}
		

	return data;
}

@DataProvider	
public static Object[][] dataSuiteC(Method m,ITestContext con) {
	String browsers[]=con.getCurrentXmlTest().getParameter("browsers").split(",");
	Object data[][]=null;
	if(m.getName().toUpperCase().equals("TESTC")) {
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";
	}else if(m.getName().toUpperCase().equals("TESTCC")) {
		
		data=new Object[2][3];
		data[0][0]=browsers[0];
		data[0][1]="U1";
		data[0][2]="P1";
		data[1][0]=browsers[1];
		data[1][1]="U2";
		data[1][2]="P2";}
		

	return data;

}
}
