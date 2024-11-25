package apiConfig;

public class EnvConstants {

	static final String restLogProperties ="src/test/resources/log4j2.properties";
	public static final String qaEnvironmentbaseURI = "https://lms-hackthon-oct24-3efc7e0df381.herokuapp.com/lms/";
	public static final String file_Path_CreateProgramJsonSchema="src/test/resources/TestData/CreateUserJsonSchema.json";
	public static final String file_Path_expectedResponseMsg="src/test/resources/TestData/ResponseMessage.json";
	public static final String file_Path_RequestRespLogs = "./Team2LmsApiPhase2RestAssuredLogs.txt";
	public static final String file_Path_currentString = "./currentString.txt";
	public static final String endPoint_Login = "login";
	public static final String endPoint_CreateProgram="saveprogram";
	public static final String endPoint_UpdateProgramByProgName="program/";
	public static final String endPoint_UpdateProgramByProgId="putprogram/";
	public static final String endPoint_DeleteProgramById="deletebyprogid/";
	public static final String endPoint_DeleteProgramByName="deletebyprogname/";
	public static final String endPoint_GetAllPrograms="allPrograms";
	public static final String endPoint_GetProgramWithAdmins="allProgramsWithUsers";
	public static final String endPoint_GetProgramByID="programs/";
	public static final String userLoginId = "sdet@gmail.com";
	public static final String password = "LmsHackathonApi@2024";
	public static final String jsonContentType = "application/json";
	public static final int programID_negativeTesting=16339;
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
	public static final String endPoint_UpdateclassRecording="updateClassrecording/"+EnvVariables.csId;
	public static final String endPoint_GetClassRecordingsBatchID="batchRecordings/"+EnvVariables.batchID;
	public static final String endPoint_GetClassRecordingsClassID2="download/"+EnvVariables.csId;
	public static final String endPoint_GetUpcomingclasses="upcomingClasses/"+EnvVariables.studentId;
	public static final String endPoint_GetClassRecordingsClassID = "classRecordings/"+EnvVariables.csId;
	public static final String TestDatajsonPath ="src/test/resources/testData/testdatajson.json";
	
	
}
