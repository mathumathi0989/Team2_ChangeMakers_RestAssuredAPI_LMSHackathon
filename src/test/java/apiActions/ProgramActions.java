package apiActions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import generics.DataBuilder;
import generics.LoggerLoad;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramActions {

	private static String loginServiceUrl = EnvConstants.endPoint_Login;
	private static String userLoginId = EnvConstants.userLoginId;
	private static String password = EnvConstants.password;
	private static String baseURI = EnvConstants.qaEnvironmentbaseURI;
	private static String loginRequestBody = EnvConstants.loginRequestBody;
	private static String jsonContentType = EnvConstants.jsonContentType;
	private static String getProgramByIdServiceUrl = EnvConstants.endPoint_GetProgramByID;
	private static RequestSpecification requestSpecification;

	DataBuilder build = new DataBuilder();

	/*
	 * Set ProgramID value in environment variable to be used by programController
	 * requests
	 */

	public void setProgramID(Response response, String setProgramId) {
		int programID = Integer.parseInt(ApiUtils.extractFromResponse(response, "programId"));
		LoggerLoad.info("Setting programID in Env Variables");
		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			LoggerLoad.info("programIDOne is " + programID);
			EnvVariables.programIDOne = programID;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			LoggerLoad.info("programIDTwo is " + programID);
			EnvVariables.programIDTwo = programID;
		} else if (setProgramId.equalsIgnoreCase("bugProgramIDOne")) {
			LoggerLoad.info("Bug found!! Here's programID for bug : " + programID);
			EnvVariables.bugProgramIDOne = programID;
		} else {
			LoggerLoad.info("programID is not set.");
		}
	}

	/*
	 * Set ProgramName value in environment variable to be used by programController
	 * requests
	 */

	public void setProgramName(Response response, String setProgramId) {

		String programNAME = ApiUtils.extractFromResponse(response, "programName");
		LoggerLoad.info("Setting programName in Env Variables");

		if (setProgramId.equalsIgnoreCase("UniqueProgramIdOne")) {
			LoggerLoad.info("programNameOne is " + programNAME);
			EnvVariables.programNameOne = programNAME;
		} else if (setProgramId.equalsIgnoreCase("UniqueProgramIdTwo")) {
			LoggerLoad.info("programNameTwo is " + programNAME);
			EnvVariables.programNameTwo = programNAME;
		} else if (setProgramId.equalsIgnoreCase("bugProgramIDOne")) {
			LoggerLoad.info("Bug found!! Here's bud's programName :  " + programNAME);
			EnvVariables.bugProgramNameOne = programNAME;
		} else {
			LoggerLoad.info("programName is not set ");
		}
	}

	/* Get ProgramIdOne from envvariables */

	public int getProgramIDOne() {
		int prgmID = EnvVariables.programIDOne;
		LoggerLoad.info("Reading prgmIDOne from env variables : " + prgmID);
		return prgmID;
	}
	/* Get ProgramIdTwo from envvariables */

	public int getProgramIDTwo() {
		int prgmID = EnvVariables.programIDTwo;
		LoggerLoad.info("Reading prgmIDTwo from env variables : " + prgmID);
		return prgmID;
	}

	/* Get ProgramNameOne from envvariables */

	public String getProgramNameOne() {
		String prgmName = EnvVariables.programNameOne;
		LoggerLoad.info("Reading prgmNameOne from env variables : " + prgmName);
		return prgmName;
	}
	/* Get ProgramNameTwo from envvariables */

	public String getProgramNameTwo() {
		String prgmName = EnvVariables.programNameTwo;
		LoggerLoad.info("Reading prgmNameTwo from env variables : " + prgmName);
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
		LoggerLoad.info("Setting details[authentication, baseURI, endpoint ]to read all programs!!");
		
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, "0");
	}

	public BaseRequest setDetailsToReadProgramByPrgmID(BaseRequest getProgram, String auth, String baseURI,
			String endPoint, Integer prgramID) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
		LoggerLoad.info("Setting details[authentication, baseURI, path parameter, endpoint ]to read newly created program by programID!!");
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, prgramID);
	}

	public BaseRequest setDetailsToReadProgramWithAdmins(BaseRequest getProgram, String auth, String baseURI,
			String endPoint) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
		LoggerLoad.info("Setting details[authentication, baseURI, endpoint ]to read all programs with admins!!");
		
		return RequestFactory.createRequest(getProgram, jsonContentType, "", endPoint, "");
	}

	public BaseRequest setDetailsToCreateValidProgram(BaseRequest postProgram, String auth, String baseURI,
			String endPoint, String programType) {
		postProgram = RequestFactory.setAuthentication(postProgram, "post", auth, baseURI);
		generateAndSetValidProgramNameInEnvVariables();
		LoggerLoad.info("New Generated ProgramName is : " + EnvVariables.programNameToCreateProgram);
		LoggerLoad.info("Setting details[authentication, baseURI, requestBody, path parameter, endpoint ]to create new program!!");
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		LoggerLoad.info("RequestBody to create program : "+requestBody);
		
		return RequestFactory.createRequest(postProgram, jsonContentType, requestBody, endPoint, 0);
	}

	public BaseRequest setDetailsToUpdateProgramByID(BaseRequest putProgram, String auth, String baseURI,
			String endPoint, String programType, Object programID) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", auth, baseURI);
		
		LoggerLoad.info("Setting details[authentication, baseURI, requestBody, path parameter, endpoint ]to update program by programID!!");
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		LoggerLoad.info("Request body to send along with update request : "+requestBody);
		
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody, endPoint, programID);

	}

	public BaseRequest setDetailsToUpdateProgramByName(BaseRequest putProgram, String auth, String baseURI,
			String endPoint, String programType, Object programName) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", auth, baseURI);
		LoggerLoad.info("Setting details[authentication, baseURI, requestBody, path parameter, endpoint ]to update program by programName!!");
		String requestBody = jsonUtil.run_all_test_scenarios_from_json_data(programType);
		LoggerLoad.info("Request body to send along with update request : "+requestBody);
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody, endPoint, programName);

	}

	public BaseRequest setDetailsToDeleteProgramByID(BaseRequest deleteProgram, String auth, String baseURI,
			String endPoint, Object programID) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", auth, baseURI);
		LoggerLoad.info("Setting details[authentication, baseURI, path parameter, endpoint ]to delete program by programID!!");
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "", endPoint, programID);

	}

	public BaseRequest setDetailsToDeleteProgramByName(BaseRequest deleteProgram, String auth, String baseURI,
			String endPoint, Object programName) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", auth, baseURI);
		LoggerLoad.info("Setting details[authentication, baseURI, path parameter, endpoint ]to delete program by programName!!");
		return RequestFactory.createRequest(deleteProgram, jsonContentType, "", endPoint, programName);

	}

	public void generateAndSetValidProgramNameInEnvVariables() {
		String prgmName = "";
		prgmName = build.getProgramName();
		EnvVariables.programNameToCreateProgram = prgmName;
	}

	private String updateProgramProperty(Response response, String propertyName, String propertyValue) {
		// Read the response body and update given propertyName with given propertyValue
		JsonObject responseJson = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
		responseJson.addProperty(propertyName, propertyValue);
		LoggerLoad.info("Retreived body from response by programID at runtime!!");
		LoggerLoad.info("Here's retrieved body before updation : "+responseJson.toString());
		LoggerLoad.info("Here's retrieved body before updation : "+responseJson.toString());
		LoggerLoad.info("Updating "+ propertyName+" to "+propertyValue);
		return responseJson.toString();
	}
	
	// Below method retrieve the program by ID then update property in program responseBody and set updated requestBody to put request
	public BaseRequest setDetailsToUpdateProgramByName(BaseRequest getProgram, BaseRequest putProgram, String auth,
			String baseURI, String endPoint, String propertyName, String propertyValue, Object programID,
			Object programName) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", auth, baseURI);
		getProgram = RequestFactory.setAuthentication(getProgram, "get", auth, baseURI);
		getProgram = RequestFactory.createRequest(getProgram, jsonContentType, "", getProgramByIdServiceUrl, programID);
		requestSpecification = getProgram.buildRequest();
		Response response = requestSpecification.get(getProgram.getServiceUrl() + getProgram.getPathparam());
		String requestBody = updateProgramProperty(response, propertyName, propertyValue);
		LoggerLoad.info("Updated requestbody : "+requestBody);
		return RequestFactory.createRequest(putProgram, jsonContentType, requestBody, endPoint, programName);
	}

}
