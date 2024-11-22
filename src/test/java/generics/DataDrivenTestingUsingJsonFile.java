package generics;

import org.json.JSONArray;
import org.json.JSONObject;

import apiConfig.EnvVariables;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class DataDrivenTestingUsingJsonFile {
	
	private static String ReqBody;
	
	public static JSONArray getTestData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
           
            //Add variable for API data chaining 
            String batchId = EnvVariables.batchID;  
            content = content.replace("{{batchId}}", batchId);
            
            
            
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject.getJSONArray("data");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	
	
	public static String run_all_test_scenarios_from_json_data(String reqBodyFieldName) {
        JSONArray testDataArray = getTestData("src/test/resources/testdatajson.json");
        JSONObject reqBody = null ;
        for (int i = 0; i < testDataArray.length(); i++) {
            JSONObject testData = testDataArray.getJSONObject(i);

            if (testData.has(reqBodyFieldName)) {
                reqBody = testData.getJSONObject(reqBodyFieldName);
            } else {
                System.out.println("Field " + reqBodyFieldName + " not found in the scenario.");
                continue; 
            }
            
    
        }
		 return ReqBody =  reqBody.toString();
    }
	 }









