package apiConfig;

public class EnvConstants {

	static final String restLogProperties = "src/test/resources/log4j2.properties";
	public static final String qaEnvironmentbaseURI = "https://lms-hackthon-oct24-3efc7e0df381.herokuapp.com/lms/";
	public static final String file_Path_CreateProgramJsonSchema = "src/test/resources/TestData/CreateUserJsonSchema.json";
	public static final String file_Path_expectedResponseMsg = "src/test/resources/TestData/ResponseMessage.json";
	public static final String file_Path_RequestRespLogs = "./Team2LmsApiPhase2RestAssuredLogs.txt";
	public static final String file_Path_currentString = "./currentString.txt";
	public static final String endPoint_Login = "login";
	public static final String endPoint_CreateProgram = "saveprogram";
	public static final String endPoint_UpdateProgramByProgName = "program/";
	public static final String endPoint_UpdateProgramByProgId = "putprogram/";
	public static final String endPoint_DeleteProgramById = "deletebyprogid/";
	public static final String endPoint_DeleteProgramByName = "deletebyprogname/";
	public static final String endPoint_GetAllPrograms = "allPrograms";
	public static final String endPoint_GetProgramWithAdmins = "allProgramsWithUsers";
	public static final String endPoint_GetProgramByID = "programs/";
	public static final String userLoginId = "sdet@gmail.com";
	public static final String password = "LmsHackathonApi@2024";
	public static final String jsonContentType = "application/json";
	public static final int programID_negativeTesting = 16339;
	public static final String programActiveStatus = "Active";
	public static final String programInactiveStatus = "Inactive";
	public static final String programDescription = "HackathonNov2024_updatedprogramDescriptionTT";
	public static final String invalidProgramDescription = "----------";
	public static final String loginRequestBody = "{ \"userLoginEmailId\" : \"sdet@gmail.com\",\n"
			+ "  \"password\" : \"LmsHackathonApi@2024\"}";
	public static final int http_OK = 200;
	public static final int http_Created = 201;
	public static final int http_BadRequest = 400;
	public static final int http_UnAuthorized = 401;
	public static final int http_NotFound = 404;
	public static final int http_MethodNotAllowed = 405;

	// Adding class constants - Mathumathi
	public static final String endPoint_GetAllRecordings = "classrecordings";
	public static final String endPoint_GetUpcomingclasses = "upcomingClasses/" + EnvVariables.studentId;
	public static final String TestDatajsonPath = "src/test/resources/testData/testdatajson.json";
	public static final String endPoint_GetClassDetailsStaffID = "classesByStaff/" + EnvVariables.staffId;

	public static String endPoint_GetClassRecordingsBatchID() {
		return "batchRecordings/" + EnvVariables.batchID;
	}

	public static String endPoint_GetClassDetailsBatchID() {
		return "classesbyBatch/" + EnvVariables.batchID;
	}

	public static String endPoint_GetClassRecordingsClassID() {
		return "classRecordings/" + EnvVariables.csId;
	}

	public static String endPoint_Updateclass() {
		return "updateClass/" + EnvVariables.csId;
	}

	public static String endPoint_UpdateclassRecording() {
		return "updateClassrecording/" + EnvVariables.csId;
	}

	public static String endPoint_GetClassRecordingsClassID2() {
		return "download/" + EnvVariables.csId;
	}

	// Adding class constants-SUpriya

	public static final String endPoint_GetAllclasses = "allClasses";

	public static final String endPoint_addClass = "CreateClassSchedule";

	public static String endPoint_GetClassDetailsClassTopic() {
		return "classes/" + EnvVariables.classTopic;
	}

	public static String endPoint_GetClassDetailsClassId() {
		return "class/" + EnvVariables.csId;
	}

	public static String endPoint_DeleteClassDetailsByClassId() {
		return "deleteByClass/" + EnvVariables.csId;
	}

	// LoginConstants

	public static final String userLoginwrongId = "sdetwrong@gmail.com";
	public static final String loginRequestBodyWrong = "{ \"userLoginEmailId\" : \"sdetwrong@gmail.com\",\n"
			+ "  \"password\" : \"LmsHackathonApi@2023\"}";
	public static final String Wrongpassword = "LmsHackathonApi@2023";
	public static final String endPoint_invalidLogin = "invalidlogin";
	
	//<=====================================BATCH MODULE=================================================================================>

		public static final String file_Path_CreateBatch = "/Users/prasad/Team2_ChangeMakers_RestAssuredAPI_LMSHackathon/src/test/resources/TestData/TestDataBatch.json";
		public static final String file_Path_UpdateBatch = "/Users/prasad/Team2_ChangeMakers_RestAssuredAPI_LMSHackathon/src/test/resources/TestData/TestDataBatch.json";
		public static final String file_Path_DeleteBatch = "/Users/prasad/Team2_ChangeMakers_RestAssuredAPI_LMSHackathon/src/test/resources/TestData/TestDataBatch.json";
		public static final String file_Path_CreateBatchJsonSchema = "/Users/prasad/Team2_ChangeMakers_RestAssuredAPI_LMSHackathon/src/test/resources/TestData/TestDataBatch.json";
		public static final String endPoint_CreateBatch = "batches";
		public static final String endPoint_UpdateBatchByBatchID = " batches/{batchId}";
		public static final String endPoint_DeleteBatchByBatchID = " /batches/{id}";
		public static final String endPoint_GetAllBatches = "/batches";

		public static String endPoint_GetBatchByBatchID() {
			return "batches/batchId/" + EnvVariables.batchID;
		}
		public static String endPoint_GetBatchByBatchName() {
			return "batches/batchName/" + EnvVariables.batchName;
		}
		public static String endPoint_GetBatchByProgramID() {
			return "/batches/program/" + EnvVariables.programIDOne;
		}
		
}
