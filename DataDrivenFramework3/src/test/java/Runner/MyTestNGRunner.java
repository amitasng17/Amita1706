package Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class MyTestNGRunner {
	
TestNG testng;
XmlSuite Suite;
List<XmlSuite> AllSuites;
XmlTest test;
List<XmlTest> testcases;
Map<String,String> Parameters;
List<XmlClass> AllClasses;

public MyTestNGRunner(int SuiteThreadPoolSize) {
	testng=new TestNG();
	AllSuites=new ArrayList<XmlSuite>();
	testng.setSuiteThreadPoolSize(SuiteThreadPoolSize);
	testng.setXmlSuites(AllSuites);
}


public void CreateSuite(String SuiteName,boolean ParallelTests) {
	Suite=new XmlSuite();
	Suite.setName(SuiteName);
	if(ParallelTests)
		Suite.setParallel(ParallelMode.TESTS);
	AllSuites.add(Suite);
	//System.out.println(AllSuites.toString());
	testcases=new ArrayList<XmlTest>();
}

public void AddTest(String TestName) {
	test=new XmlTest(Suite);
	test.setName(TestName);
	Parameters=new HashMap<String,String>();
	AllClasses=new ArrayList<XmlClass>();
	test.setParameters(Parameters);
	AllClasses=new ArrayList<XmlClass>();
	test.setXmlClasses(AllClasses);
}

public void AddTestClass(String ClassName, List<String> includedMethodNames) {
	XmlClass testClass=new XmlClass(ClassName);
	List<XmlInclude> Methods=new ArrayList<XmlInclude>();
	int priority=1;
	for(String methodName: includedMethodNames) {
		XmlInclude method=new XmlInclude(methodName, priority);
		Methods.add(method);
		priority++;
	}
	     testClass.setIncludedMethods(Methods);
	     AllClasses.add(testClass);
		
}
	


public void addListener(String listenerFile) {
	Suite.addListener("listener.MyTestNGListener");	
}

public void addParameter(String name,String value) {
	Parameters.put(name, value);
}

public void run(){

testng.run();

}

}
