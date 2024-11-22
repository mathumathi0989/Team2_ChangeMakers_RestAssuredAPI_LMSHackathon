package apiConfig;

public class EnvConstants {

	static final String restLogProperties ="Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/log4j2.properties";
	//public static final String restApiConfigProperties="Users/bhagyashri/eclipse-workspace/com.automation.userApi/src/test/resources/Config/ApiConfig.properties";
	public static final String qaEnvironmentbaseURI = "https://lms-hackthon-oct24-3efc7e0df381.herokuapp.com/lms/";
	public static final String file_Path_CreateProgram="/Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/TestData/CreateUserInputData.json";
	public static final String file_Path_UpdateProgram="/Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/TestData/UpdateUserInputData.json";
	public static final String file_Path_DeleteProgram="/Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/TestData/DeleteUserInputData.json";
	public static final String file_Path_CreateProgramJsonSchema="/Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/TestData/CreateUserJsonSchema.json";
	public static final String file_Path_expectedResponseMsg="/Users/bhagyashri/eclipse-workspace/com.lmsapi/src/test/resources/TestData/ResponseMessage.json";
	public static final String file_Path_RequestRespLogs = "/Users/bhagyashri/eclipse-workspace/com.lmsapi/Team2LmsApiPhase2RestAssuredLogs.txt";
	public static final String endPoint_Login = "login";
	public static final String endPoint_CreateProgram="saveprogram";
	public static final String endPoint_UpdateProgramByProgName="program/";
	public static final String endPoint_UpdateProgramByProgId="putprogram/";
	public static final String endPoint_DeleteProgramById="/deleteuser/";
	public static final String endPoint_DeleteProgramByName="/deleteuser/username";
	public static final String endPoint_GetAllPrograms="allPrograms";
	public static final String endPoint_GetProgramWithUsers="allProgramsWithUsers";
	public static final String endPoint_GetProgramByID="programs/";
	public static final String userLoginId = "sdet@gmail.com";
	public static final String password = "LmsHackathonApi@2024";
	public static final String jsonContentType = "application/json";
	public static final String loginRequestBody = "{ \"userLoginEmailId\" : \"sdet@gmail.com\",\n"
			+ "  \"password\" : \"LmsHackathonApi@2024\"}";
	public static final int http_OK = 200;
	public static final int http_Created = 201;
	public static final int http_BadRequest = 400;
	public static final int http_UnAuthorized = 401;
	public static final int http_NotFound = 404;
	public static final int http_MethodNotAllowed = 405;
	
	
	//Adding class constants - Mathumathi
	public static final String endPoint_GetAllRecordings="classrecordings";
	public static final String endPoint_Updateclass="updateClass/"+EnvVariables.csId;
	public static final String endPoint_UpdateclassRecording="updateClassrecording/{classId}";
	public static final String endPoint_GetClassRecordingsBatchID="batchRecordings/"+EnvVariables.batchID;
	public static final String endPoint_GetClassRecordingsClassID2="download/"+EnvVariables.csId;
	public static final String endPoint_GetUpcomingclasses="upcomingClasses/"+EnvVariables.studentId;
	public static final String endPoint_GetClassRecordingsClassID = "classRecordings/"+EnvVariables.csId;
	public static final String TestDatajsonPath ="src/test/resources/testData/testdatajson.json";
	
	
}
