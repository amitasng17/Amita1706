package Runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRunner {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Map<String, String> ClassMethods = new DataUtil().loadClassMethods();
		String path = System.getProperty("user.dir") + "//src//test//resources//jsons//testconfig.json";
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(new FileReader(new File(path)));
		String parallelsuites = (String) json.get("parallelsuites");
		MyTestNGRunner testng = new MyTestNGRunner(Integer.parseInt(parallelsuites));
		JSONArray testSuites = (JSONArray) json.get("testsuites");
		for (int sId = 0; sId < testSuites.size(); sId++) {
			JSONObject testSuite = (JSONObject) testSuites.get(sId);
			String runmode = (String) testSuite.get("runmode");
			if (runmode.equals("Y")) {
				String suitename = (String)testSuite.get("name");
				String testdatajsonfile = (String) testSuite.get("testdatajsonfile");
				String testsuitefilename = (String) testSuite.get("suitefilename");
				String parallelTests = (String) testSuite.get("paralleltests");
				Boolean pTests = false;
				if (parallelTests.equals("Y"))
					pTests = true;
				testng.CreateSuite(suitename, pTests);
				String SuiteJSONpath = System.getProperty("user.dir") + "//src//test//resources//jsons//"
						+ testsuitefilename;
				JSONParser SuiteParser = new JSONParser();
				JSONObject SuiteJSON = (JSONObject) SuiteParser.parse(new FileReader(new File(SuiteJSONpath)));
				// System.out.println("**************");
				// System.out.println(SuiteJSON);
				JSONArray suiteTestCases = (JSONArray) SuiteJSON.get("testcases");
				for (int sTId = 0; sTId < suiteTestCases.size(); sTId++) {
					JSONObject suiteTestCase = (JSONObject) suiteTestCases.get(sTId);
					String name = (String) suiteTestCase.get("name");
					JSONArray parameterNames = (JSONArray) suiteTestCase.get("parameternames");
					JSONArray executions = (JSONArray) suiteTestCase.get("executions");
					for (int eId = 0; eId < executions.size(); eId++) {
						JSONObject execution = (JSONObject) executions.get(eId);
						String testRunmode=(String)execution.get("runmode");
						if(testRunmode != null && testRunmode.equals("Y")) {
						String testcaseName = (String) execution.get("executionname");
						JSONArray parameterValues = (JSONArray) execution.get("parametervalues");
						JSONArray methods = (JSONArray) execution.get("methods");
						System.out.println(name + "--" + testcaseName);
						System.out.println(parameterNames + "---" + parameterValues);
						System.out.println(methods);
						System.out.println("----------------");
						testng.AddTest(name + "--" + testcaseName);
						for (int pId = 0; pId < parameterNames.size(); pId++) {
							testng.addParameter((String) parameterNames.get(pId), (String) parameterValues.get(pId));
						}
						List<String> includedMethods = new ArrayList<String>();
						for (int mId = 0; mId < methods.size(); mId++) {
							String method = (String) methods.get(mId);
							System.out.println(method);
							String methodClass = ClassMethods.get(method);
							if (mId == methods.size() - 1
									|| ClassMethods.get((String) methods.get(mId + 1)).equals(methodClass)) {
								includedMethods.add(method);
								testng.AddTestClass(methodClass, includedMethods);
								includedMethods = new ArrayList<String>();
							} else
								includedMethods.add(method);
                            
						}
                          
					}
				}
				}
					}
			testng.run();
		}
		
	}
}