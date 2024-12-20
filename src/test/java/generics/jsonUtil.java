package generics;

import org.json.JSONArray;
import org.json.JSONObject;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class jsonUtil {
	
	private static String ReqBody;
	
	public static JSONArray getTestData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
           
            //Add variable for API data chaining 
            int batchId = EnvVariables.batchID;  
            
            if (content.contains("{{batchId}}")) {
                content = content.replace("{{batchId}}", String.valueOf(batchId));
            }
            
            String programName_ToCreateProgram = EnvVariables.programNameToCreateProgram;  
            if (programName_ToCreateProgram  != null && content.contains("{{programName}}")) {
                content = content.replace("{{programName}}", programName_ToCreateProgram);
            }
            
            int programId = EnvVariables.programIDOne;
            if (content.contains("{{programID}}")) {
                content = content.replace("{{programID}}", String.valueOf(programId));
            }
            
            String programNames = EnvVariables.programNameOne;
            if (content.contains("{{programName}}")) {
                content = content.replace("{{programName}}", programNames);
            }
            
            
            String programName_ToUpdateProgram = EnvVariables.programNameOne+"-Updated";
            if (content.contains("{{programNameToUpdate}}")) {
                content = content.replace("{{programNameToUpdate}}", programName_ToUpdateProgram);
            }
            
            
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject.getJSONArray("data");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	
	
	public static String run_all_test_scenarios_from_json_data(String reqBodyFieldName) {
        JSONArray testDataArray = getTestData(EnvConstants.TestDatajsonPath);
        JSONObject reqBody = null ;
        for (int i = 0; i < testDataArray.length(); i++) {
            JSONObject testData = testDataArray.getJSONObject(i);

            if (testData.has(reqBodyFieldName)) {
                reqBody = testData.getJSONObject(reqBodyFieldName);
            } else {
                continue; 
            }
            
    
        }
		 return ReqBody =  reqBody.toString();
    }
	 }









