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
	// String validProgramDescription = "Java-API-Selenium-RestAssured";
	DataBuilder build = new DataBuilder();

	/*
	 * Set ProgramID value in environment variable to be used by programController
	 * requests
	 */

	public void setProgramID(Response response, String setProgramId) {
		int programID = Integer.parseInt(ApiUtils.extractFromResponse(response, "programId"));
		System.out.println("Setting programID in Env Variables");
		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			System.out.println("programIDOne is " + programID);
			EnvVariables.programIDOne = programID;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			System.out.println("programIDTwo is " + programID);
			EnvVariables.programIDTwo = programID;
		} else if (setProgramId.equalsIgnoreCase("bugProgramIDOne")) {
			System.out.println("Bug found!! Here's programID for bug : " + programID);
			EnvVariables.bugProgramIDOne = programID;
		} else {
			System.out.println("programID is not set.");
		}
	}

	/*
	 * Set ProgramName value in environment variable to be used by programController
	 * requests
	 */

	public void setProgramName(Response response, String setProgramId) {

		String programNAME = ApiUtils.extractFromResponse(response, "programName");
		System.out.println("Setting programName in Env Variables");

		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			System.out.println("programNameOne is " + programNAME);
			EnvVariables.programNameOne = programNAME;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			System.out.println("programNameTwo is " + programNAME);
			EnvVariables.programNameTwo = programNAME;
		} else if (setProgramId.equalsIgnoreCase("bugProgramIDOne")) {
			System.out.println("Bug found!! Here's bud's programName :  " + programNAME);
			EnvVariables.bugProgramNameOne = programNAME;
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

	public String getAuthToken() {
		return EnvVariables.token;
	}

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post", userLoginId, password, baseURI);
		login = RequestFactory.createRequest(login, jsonContentType, loginRequestBody, loginServiceUrl, 0);
		return login;
	}

	public BaseRequest setDetailsToReadProgram(BaseRequest getProgram, String auth, String baseURI, String endPoint) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
		// return RequestFactory.createRequest(getProgram,
		// jsonContentType,"",getAllProgramsServiceUrl,"0");
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, "0");
	}

	public BaseRequest setDetailsToReadProgramByPrgmID(BaseRequest getProgram, String auth, String baseURI,
			String endPoint, Integer prgramID) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
//		return RequestFactory.createRequest(getProgram, jsonContentType, "",
//				getProgramByIdServiceUrl, prgramID);
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, prgramID);
	}

	public BaseRequest setDetailsToReadProgramWithAdmins(BaseRequest getProgram, String auth, String baseURI,
			String endPoint) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
		// return RequestFactory.createRequest(getProgram, jsonContentType, "",
		// getProgramWithUsersServiceUrl, "");
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, "");
	}

	public BaseRequest setDetailsToCreateValidProgram(BaseRequest postProgram, String auth, String baseURI,
			String endPoint, String programType) {
		postProgram = RequestFactory.setAuthentication(postProgram, "post", auth, baseURI);
		generateAndSetValidProgramNameInEnvVariables();
		System.out.println("New Generated ProgramName is : " + EnvVariables.programNameToCreateProgram);
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		// return RequestFactory.createRequest(postProgram, jsonContentType,
		// requestBody,postProgramServiceUrl, 0);
		return RequestFactory.createRequest(postProgram, jsonContentType, requestBody, endPoint, 0);
	}

	public BaseRequest setDetailsToUpdateProgramByID(BaseRequest putProgram, String auth, String baseURI,
			String endPoint, String programType, Object programID) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", auth, baseURI);
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		// return RequestFactory.createRequest(putProgram, jsonContentType,
		// requestBody,updateProgramByIdServiceUrl, EnvVariables.programIDOne);
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody, endPoint, programID);

	}

	public BaseRequest setDetailsToUpdateProgramByName(BaseRequest putProgram, String auth, String baseURI,
			String endPoint, String programType, Object programName) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", auth, baseURI);
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		// return RequestFactory.createRequest(putProgram, jsonContentType,
		// requestBody,updateProgramByIdServiceUrl, programNamePathParam);
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody, endPoint, programName);

	}

	public BaseRequest setDetailsToDeleteProgramByID(BaseRequest deleteProgram, String auth, String baseURI,
			String endPoint, Object programID) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", auth, baseURI);
		// return RequestFactory.createRequest(deleteProgram, jsonContentType, "",
		// deleteByProgramIdServiceUrl, programIdToDelete);
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "", endPoint, programID);

	}

	public BaseRequest setDetailsToDeleteProgramByName(BaseRequest deleteProgram, String auth, String baseURI,
			String endPoint, Object programName) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", auth, baseURI);
		// return RequestFactory.createRequest(deleteProgram, jsonContentType,
		// "",deleteByProgramNameServiceUrl,programNamePathParam);
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "", endPoint, programName);

	}

	public void generateAndSetValidProgramNameInEnvVariables() {
		String prgmName = "";
		prgmName = build.getProgramName();
		EnvVariables.programNameToCreateProgram = prgmName;
	}

}
