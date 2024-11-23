package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import generics.DataBuilder;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;

public class ProgramActions {

	private static String loginServiceUrl = EnvConstants.endPoint_Login;
	private static String userLoginId = EnvConstants.userLoginId;
	private static String password = EnvConstants.password;
	private static String baseURI = EnvConstants.qaEnvironmentbaseURI;
	private static String loginRequestBody = EnvConstants.loginRequestBody;
	private static String jsonContentType = EnvConstants.jsonContentType;
	private static String getAllProgramsServiceUrl = EnvConstants.endPoint_GetAllPrograms;
	private static String getProgramByIdServiceUrl = EnvConstants.endPoint_GetProgramByID;
	private static String getProgramWithUsersServiceUrl = EnvConstants.endPoint_GetProgramWithAdmins;
	private static String postProgramServiceUrl = EnvConstants.endPoint_CreateProgram;
	private static String updateProgramByNameServiceUrl = EnvConstants.endPoint_UpdateProgramByProgName;
	private static String updateProgramByIdServiceUrl = EnvConstants.endPoint_UpdateProgramByProgId;
	private static String deleteByProgramIdServiceUrl = EnvConstants.endPoint_DeleteProgramById;
	private static String deleteByProgramNameServiceUrl = EnvConstants.endPoint_DeleteProgramByName;
	
	//String validProgramDescription = "Java-API-Selenium-RestAssured";
	DataBuilder build = new DataBuilder();

/*==== Set ProgramID value in environment variable to be used by programController requests ====*/

	public void setProgramID(Response response, String setProgramId) {
		int programID = Integer.parseInt(ApiUtils.extractFromResponse(response, "programId"));
		System.out.println("Setting programID in Env Variables");
		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			System.out.println("programIDOne is " + programID);
			EnvVariables.programIDOne = programID;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			System.out.println("programIDTwo is " + programID);
			EnvVariables.programIDTwo = programID;
		} else {
			System.out.println("programID is not set.");
		}
	}

/*==== Set ProgramName value in environment variable to be used by programController requests ====*/

	public void setProgramName(Response response, String setProgramId) {

		String programNAME = ApiUtils.extractFromResponse(response, "programName");
		System.out.println("Setting programName in Env Variables");

		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			System.out.println("programNameOne is " + programNAME);
			EnvVariables.programNameOne = programNAME;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			System.out.println("programNameTwo is " + programNAME);
			EnvVariables.programNameTwo = programNAME;
		} else {
			System.out.println("programName is not set ");
		}
	}

	/* Get ProgramIdOne from envvariables */

	public int getProgramIDOne() {
		int prgmID = EnvVariables.programIDOne;
		System.out.println("Reading prgmIDOne from env variables : " + prgmID);
		return prgmID;
	}
	/* Get ProgramIdTwo from envvariables */

	public int getProgramIDTwo() {
		int prgmID = EnvVariables.programIDTwo;
		System.out.println("Reading prgmIDTwo from env variables : " + prgmID);
		return prgmID;
	}

	/* Get ProgramNameOne from envvariables */

	public String getProgramNameOne() {
		String prgmName = EnvVariables.programNameOne;
		System.out.println("Reading prgmNameOne from env variables : " + prgmName);
		return prgmName;
	}
	/* Get ProgramNameTwo from envvariables */

	public String getProgramNameTwo() {
		String prgmName = EnvVariables.programNameTwo;
		System.out.println("Reading prgmNameTwo from env variables : " + prgmName);
		return prgmName;
	}

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post", userLoginId, password,baseURI);
		login = RequestFactory.createRequest(login, jsonContentType,loginRequestBody ,
				loginServiceUrl, 0);
		return login;
	}

	public BaseRequest setDetailsToReadProgram(BaseRequest getProgram) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", EnvVariables.token, baseURI);
		return RequestFactory.createRequest(getProgram, jsonContentType,"",getAllProgramsServiceUrl,"0");
	}

	public BaseRequest setDetailsToReadProgramByPrgmID(BaseRequest getProgram, Integer prgramID) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", EnvVariables.token,
				baseURI);
		return RequestFactory.createRequest(getProgram, jsonContentType, "",
				getProgramByIdServiceUrl, prgramID);
	}

	public BaseRequest setDetailsToReadProgramWithAdmins(BaseRequest getProgram) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", EnvVariables.token,
				baseURI);
		return RequestFactory.createRequest(getProgram, jsonContentType, "",
				getProgramWithUsersServiceUrl, "");
	}

	public BaseRequest setDetailsToCreateValidProgram(BaseRequest postProgram, String programType) {
		postProgram = RequestFactory.setAuthentication(postProgram, "post", EnvVariables.token,
				baseURI);
		generateAndSetValidProgramNameInEnvVariables();
		System.out.println("New Generated ProgramName is : " + EnvVariables.programNameToCreateProgram);
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		return RequestFactory.createRequest(postProgram, jsonContentType, requestBody,
				postProgramServiceUrl, 0);
	}

	public BaseRequest setDetailsToUpdateProgramByID(BaseRequest putProgram, String programType) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", EnvVariables.token,
				baseURI);
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody,
				updateProgramByIdServiceUrl, EnvVariables.programIDOne);
	}

	public BaseRequest setDetailsToDeleteProgramByID(BaseRequest deleteProgram) {
		int programIdToDelete = EnvVariables.programIDTwo;
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", EnvVariables.token,
				baseURI);
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "",
				deleteByProgramIdServiceUrl, programIdToDelete);

	}
	
	public BaseRequest setDetailsToDeleteProgramByName(BaseRequest deleteProgram) {
		String programNameToDelete = EnvVariables.programNameOne;
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", EnvVariables.token,
				baseURI);
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "",
				deleteByProgramNameServiceUrl,programNameToDelete);

	}
	public void generateAndSetValidProgramNameInEnvVariables() {
		String prgmName = "";
		prgmName = build.getProgramName();
		EnvVariables.programNameToCreateProgram = prgmName;
	}

}
