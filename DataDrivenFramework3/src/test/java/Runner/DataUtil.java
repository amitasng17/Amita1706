package Runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataUtil {

	public Map<String, String> loadClassMethods() throws FileNotFoundException, IOException, ParseException {
		Map<String, String> ClassMethodMap = new HashMap<String, String>();
		String path = System.getProperty("user.dir") + "//src//test//resources//jsons//classmethods.json";
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(new FileReader(new File(path)));
		JSONArray ClassDetails = (JSONArray) json.get("classdetails");
		for (int cDId = 0; cDId < ClassDetails.size(); cDId++) {
			JSONObject ClassDetail = (JSONObject) ClassDetails.get(cDId);
			String ClassName = (String) ClassDetail.get("class");
			System.out.println(ClassName);
			JSONArray Methods = (JSONArray) ClassDetail.get("methods");
			for (int mId = 0; mId < Methods.size(); mId++) {
				String method = (String) Methods.get(mId);
				// System.out.println(method);
				ClassMethodMap.put(method, ClassName);
			}
			// System.out.println("-----------------");
		}
		System.out.println(ClassMethodMap);
		return ClassMethodMap;

	}

}
