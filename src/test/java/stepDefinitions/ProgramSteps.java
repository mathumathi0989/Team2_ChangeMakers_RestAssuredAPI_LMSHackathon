package stepDefinitions;

import apiConfig.EnvConstants;
import generics.ApiUtils;
import apiActions.ProgramActions;
import generics.LoggerLoad;
import httpRequest.BaseRequest;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramSteps {

	public static RequestSpecification requestSpecs;
	static Response response;
	private static String baseURI = EnvConstants.qaEnvironmentbaseURI;
	private String getAllProgramsServiceUrl = EnvConstants.endPoint_GetAllPrograms;
	private static String getProgramByIdServiceUrl = EnvConstants.endPoint_GetProgramByID;
	private static String getProgramWithAdminsServiceUrl = EnvConstants.endPoint_GetProgramWithAdmins;
	private static String postProgramServiceUrl = EnvConstants.endPoint_CreateProgram;
	private static String updateProgramByNameServiceUrl = EnvConstants.endPoint_UpdateProgramByProgName;
	private static String updateProgramByIdServiceUrl = EnvConstants.endPoint_UpdateProgramByProgId;
	private static String deleteByProgramIdServiceUrl = EnvConstants.endPoint_DeleteProgramById;
	private static String deleteByProgramNameServiceUrl = EnvConstants.endPoint_DeleteProgramByName;
	private static int programID_updateNegativeScenarios = EnvConstants.programID_negativeTesting;
	private static String programActiveStatus = EnvConstants.programActiveStatus;
	private static String programInactiveStatus = EnvConstants.programInactiveStatus;
	private static String programDescription = EnvConstants.programDescription;
	private static String invalidProgramDescription = EnvConstants.invalidProgramDescription;

	private int http_Created = EnvConstants.http_Created;
	private int http_OK = EnvConstants.http_OK;
	private int http_NotFound = EnvConstants.http_NotFound;
	private int http_BadRequest = EnvConstants.http_BadRequest;
	private int http_Unauthorized = EnvConstants.http_UnAuthorized;
	private int http_MethodNotAllowed = EnvConstants.http_MethodNotAllowed;
	private static BaseRequest login;
	private static BaseRequest getProgram;
	private static BaseRequest postProgram;
	private static BaseRequest putProgram;
	private static BaseRequest deleteProgram;

	static String requestBody = "";
	private static boolean isAuthTokenGenerated = false;
	public static String token;
	static String updatedRequestBody = "";

	ApiUtils restUtil = new ApiUtils();
	ProgramActions program = new ProgramActions();

	@BeforeAll
	public static void setup() {
		if (!isAuthTokenGenerated) {

			login = ProgramActions.validLogin(login);
			requestSpecs = login.buildRequest();
			response = requestSpecs.post(login.getServiceUrl());
			ApiUtils.setAuth(response);// setting token for auth
			LoggerLoad.info("Executing setup code...");

			// Set the flag to true after execution
			isAuthTokenGenerated = true;
		}
	}

	@Before
	public void scenario(Scenario scenario) {
		LoggerLoad.info(
				"===============================================================================================");
		LoggerLoad.info(scenario.getSourceTagNames() + " : " + scenario.getName());
		LoggerLoad.info(
				"-----------------------------------------------------------------------------------------------");

	}

	@Given("Admin provides valid authentication details")
	public void admin_provides_valid_authentication_details() {

		LoggerLoad.info("Executing some precondition step => Check authentication details");
		if (isAuthTokenGenerated == true) {
			LoggerLoad.info("User is authenticated!!!");
		} else {
			LoggerLoad.info("Unauthorized User warning!!!");

		}
	}

	// @GetAllPrograms
	@When("Admin creates and executes GET all program Request for the LMS API")
	public void admin_creates_and_executes_get_all_program_request_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgram(getProgram, program.getAuthToken(), baseURI,
				getAllProgramsServiceUrl);
		requestSpecs = getProgram.buildRequest();
		response = requestSpecs.get(getProgram.getServiceUrl());

	}

	@Then("Admin receives {int} OK Status with program response body")
	public void admin_receives_ok_status_with_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @GetAllProgramsWithAdmins
	@Given("Admin creates GET Request to retrieve all programs with Admins for the LMS API")
	public void admin_creates_get_request_to_retrieve_all_programs_with_admins_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgramWithAdmins(getProgram, program.getAuthToken(), baseURI,
				getProgramWithAdminsServiceUrl);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin executes HTTPS GET program request with valid endpoint")
	public void admin_executes_https_get_program_request_with_valid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @PostNewProgram
	@When("Admin creates and executes POST program Request for the LMS with {string}")
	public void admin_creates_and_executes_post_program_request_for_the_lms_with_ValidRequestBody(String programType) {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, program.getAuthToken(), baseURI,
				postProgramServiceUrl, programType);
		requestSpecs = postProgram.buildRequest();
		response = requestSpecs.post(postProgram.getServiceUrl());
	}

	@Then("Admin receives {int} Created Status with program response body containing {string}")
	public void admin_receives_created_status_with_program_response_body_containing_uniqueprogramids(
			Integer expectedStatusCode, String setProgramProperty) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
		program.setProgramID(response, setProgramProperty);
		program.setProgramName(response, setProgramProperty);

	}

	// @GetProgramByID
	@When("Admin creates and executes GET rogram with valid program ID Request for the LMS API")
	public void admin_creates_and_executes_get_rogram_with_valid_program_id_request_for_the_lms_api() {
		int program_ID = program.getProgramIDOne();
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, program.getAuthToken(), baseURI,
				getProgramByIdServiceUrl, program_ID);
		requestSpecs = getProgram.buildRequest();
		response = requestSpecs.get(getProgram.getServiceUrl() + getProgram.getPathparam());
	}

	@Then("Admin receives {int} OK Status with required program response body")
	public void admin_receives_ok_status_with_required_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @PutByProgramID
	@Given("Admin creates PUT Request for the LMS Program API endpoint to {string}")
	public void admin_creates_put_request_for_the_lms_program_api_endpoint_to_(String programType) {
		int program_ID = program.getProgramIDOne();
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, program.getAuthToken(), baseURI,
				updateProgramByIdServiceUrl, programType, program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT Request with valid endpoint to update program")
	public void admin_sends_https_put_request_with_valid_endpoint_to_update_program() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} OK Status with updated value in program response body")
	public void admin_receives_ok_status_with_updated_value_in_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
		program.setProgramName(response, "UniqueProgramIdOne");// Setting updated programName in EnvVariables
		System.out.println("Updated program Name is : " + program.getProgramNameOne());
	}

	// @DeleteProgramByProgramID
	@Given("Admin creates DELETE Request for the LMS Program API endpoint and valid program ID")
	public void admin_creates_delete_request_for_the_lms_program_api_endpoint_and_valid_program_id() {
		int program_ID = program.getProgramIDTwo();
		deleteProgram = program.setDetailsToDeleteProgramByID(deleteProgram, program.getAuthToken(), baseURI,
				deleteByProgramIdServiceUrl, program_ID);
		requestSpecs = deleteProgram.buildRequest();

	}

	@When("Admin sends HTTPS DELETE program by programId Request with valid endpoint")
	public void admin_sends_https_delete_program_by_program_id_request_with_valid_endpoint() {
		// response = requestSpecs.delete(deleteProgram.getServiceUrl() +
		// program.getProgramIDOne());
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	@Then("Admin receives {int} Ok status with successful program deletion message")
	public void admin_receives_ok_status_with_successful_program_deletion_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @DeleteProgramByProgramName
	@Given("Admin creates DELETE Request for the LMS API endpoint and valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		String program_Name = program.getProgramNameOne();
		deleteProgram = program.setDetailsToDeleteProgramByName(deleteProgram, program.getAuthToken(), baseURI,
				deleteByProgramNameServiceUrl, program_Name);
		requestSpecs = deleteProgram.buildRequest();
	}

	@When("Admin sends HTTPS DELETE program by programName Request with endpoint")
	public void admin_sends_https_delete_program_by_program_name_request_with_endpoint() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @MethodNotAllowed
	@Given("Admin creates POST Program Request for the LMS with request body")
	public void admin_creates_post_program_request_for_the_lms_with_request_body() {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, program.getAuthToken(), baseURI,
				postProgramServiceUrl, "ValidProgramWithAllValidFieldsPresentInRequestBody");
		requestSpecs = postProgram.buildRequest();

	}

	@When("Admin sends HTTPS GET Program Request and request Body with endpoint")
	public void admin_sends_https_get_program_request_and_request_body_with_endpoint() {
		response = requestSpecs.get(postProgram.getServiceUrl());
	}

	@Then("Admin receives {int} Method Not Allowed")
	public void admin_receives_method_not_allowed(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @MethodNotAllowed
	@Given("Admin creates GET all programs Request for the LMS API")
	public void admin_creates_get_all_programs_request_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgram(getProgram, program.getAuthToken(), baseURI,
				getAllProgramsServiceUrl);
		requestSpecs = getProgram.buildRequest();

	}

	@When("Admin sends HTTPS POST Program Request with endpoint")
	public void admin_sends_https_post_program_request_with_endpoint() {
		response = requestSpecs.post(getProgram.getServiceUrl());
	}

	// @MethodNotAllowed
	@Given("Admin creates GET all programs with admins Request for the LMS with request body")
	public void admin_creates_get_all_programs_with_admins_request_for_the_lms_with_request_body() {
		getProgram = program.setDetailsToReadProgramWithAdmins(getProgram, program.getAuthToken(), baseURI,
				getProgramWithAdminsServiceUrl);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS POST Program Request and request Body with endpoint")
	public void admin_sends_https_post_program_request_and_request_body_with_endpoint() {
		response = requestSpecs.post(getProgram.getServiceUrl());
	}

	// @MethodNotAllowed
	@Given("Admin creates PUT program Request for the LMS API")
	public void admin_creates_put_program_request_for_the_lms_api() {
		int program_ID = program.getProgramIDOne();
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, program.getAuthToken(), baseURI,
				updateProgramByIdServiceUrl, "UpdateProgramWithAllValidFieldsPresentInRequestBody", program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET Program Request with endpoint")
	public void admin_sends_https_get_program_request_with_endpoint() {
		response = requestSpecs.delete(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	// @NoAuth
	@Given("Admin creates POST Request for the LMS with request body and with no auth")
	public void admin_creates_post_request_for_the_lms_with_request_body_and_with_no_auth() {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, "NoAuth", baseURI, postProgramServiceUrl,
				"ValidProgramWithAllValidFieldsPresentInRequestBody");
		requestSpecs = postProgram.buildRequest();

	}

	@When("Admin sends HTTPS POST Program Request with valid request Body and endpoint")
	public void admin_sends_https_post_program_request_with_valid_request_body_and_endpoint() {
		response = requestSpecs.post(postProgram.getServiceUrl());
	}

	@Then("Admin receives {int} Unauthorized")
	public void admin_receives_unauthorized(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @NoAuth
	@Given("Admin creates GET Program Request for the LMS with no auth")
	public void admin_creates_get_program_request_for_the_lms_with_no_auth() {
		getProgram = program.setDetailsToReadProgram(getProgram, "NoAuth", baseURI, getAllProgramsServiceUrl);
		requestSpecs = getProgram.buildRequest();

	}

	@When("Admin sends HTTPS GET Program Request with valid endpoint")
	public void admin_sends_https_get_program_request_with_valid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	// @Program_S14_NoAuth_GetAllProgramsWithAdmins
	@Given("Admin creates GET Program with admins Request for the LMS with no auth")
	public void admin_creates_get_program_with_admins_request_for_the_lms_with_no_auth() {
		getProgram = program.setDetailsToReadProgramWithAdmins(getProgram, "NoAuth", baseURI,
				getProgramWithAdminsServiceUrl);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET Program with admins Request with valid endpoint")
	public void admin_sends_https_get_program_with_admins_request_with_valid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	// @NoAuth
	@Given("Admin creates GET Program by programID Request for the LMS with no auth")
	public void admin_creates_get_program_by_program_id_request_for_the_lms_with_no_auth() {
		int program_ID = program.getProgramIDOne();
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, "NoAuth", baseURI, getProgramByIdServiceUrl,
				program_ID);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET Program by programID Request with valid endpoint")
	public void admin_sends_https_get_program_by_program_id_request_with_valid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	// @NoAuth
	@Given("Admin creates PUT Request with no auth for the LMS API endpoint with request Body with mandatory, additional fields")
	public void admin_creates_put_request_with_no_auth_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
		int program_ID = programID_updateNegativeScenarios;
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, "NoAuth", baseURI, updateProgramByIdServiceUrl,
				"UpdateProgramRequestBodyNoAuth", program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT Program by programID Request with valid endpoint")
	public void admin_sends_https_put_program_by_program_id_request_with_valid_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl());
	}

	// @NoAuth
	@Given("Admin creates PUT Request with programName and no auth for the LMS API endpoint with request Body with mandatory, additional fields")
	public void admin_creates_put_request_with_program_name_and_no_auth_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
		String program_Name = program.getProgramNameOne();
		putProgram = program.setDetailsToUpdateProgramByName(putProgram, "NoAuth", baseURI,
				updateProgramByNameServiceUrl, "UpdateProgramRequestBodyNoAuth", program_Name);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT Program by programName Request with valid endpoint")
	public void admin_sends_https_put_program_by_program_name_request_with_valid_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl());
	}

	// @NoAuth
	@Given("Admin creates DELETE by programID Request with no auth for the LMS API endpoint")
	public void admin_creates_delete_by_program_id_request_with_no_auth_for_the_lms_api_endpoint() {
		int program_ID = program.getProgramIDTwo();
		deleteProgram = program.setDetailsToDeleteProgramByID(deleteProgram, "NoAuth", baseURI,
				deleteByProgramIdServiceUrl, program_ID);
		requestSpecs = deleteProgram.buildRequest();
	}

	@When("Admin creates DELETE Request with no auth for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_with_no_auth_for_the_lms_api_endpoint_and_valid_program_name() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl());
	}

	// @NoAuth
	@Given("Admin creates DELETE by programName Request with no auth for the LMS API endpoint")
	public void admin_creates_delete_by_program_name_request_with_no_auth_for_the_lms_api_endpoint() {
		String program_Name = program.getProgramNameOne();
		deleteProgram = program.setDetailsToDeleteProgramByName(deleteProgram, "NoAuth", baseURI,
				deleteByProgramIdServiceUrl, program_Name);
		requestSpecs = deleteProgram.buildRequest();
	}

	@When("Admin sends HTTPS DELETE Program by programID with noauth Request and valid endpoint")
	public void admin_sends_https_delete_program_by_program_id_with_noauth_request_and_valid_endpoint() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	// @PostNewProgram
	@Given("Admin creates POST Request for the LMS with {string} in request body")
	public void admin_creates_post_request_for_the_lms_with_in_request_body(String invalidRequestBody) {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, program.getAuthToken(), baseURI,
				postProgramServiceUrl, invalidRequestBody);
		requestSpecs = postProgram.buildRequest();
	}

	@When("Admin sends HTTPS POST Request and invalid program request Body with endpoint")
	public void admin_sends_https_post_request_and_invalid_program_request_body_with_endpoint() {
		response = requestSpecs.post(postProgram.getServiceUrl());
	}

	@Then("Admin receives {int} Bad Request Status")
	public void admin_receives_bad_request_status(Integer expectedStatusCode) {
		if (response.getStatusCode() == http_Created) {
			program.setProgramID(response, "bugProgramIDOne");
		}
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @PutByProgramID
	@Given("Admin creates PUT by programID Request for the LMS with {string} in request body")
	public void admin_creates_put_by_program_id_request_for_the_lms_with_in_request_body(
			String invalidDataInRequestBody) {
		int program_ID = programID_updateNegativeScenarios;
		String authToken = program.getAuthToken();
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, authToken, baseURI, updateProgramByIdServiceUrl,
				invalidDataInRequestBody, program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT Request and invalid program request Body with endpoint")
	public void admin_sends_https_put_request_and_invalid_program_request_body_with_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Bad Request Status with message for invalid request body and boolean success details")
	public void admin_receives_bad_request_status_with_message_for_invalid_request_body_and_boolean_success_details(
			Integer expectedStatusCode) {
		if (response.getStatusCode() == http_Created) {
			program.setProgramName(response, "bugProgramIDOne");
		}
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @PutByProgramName
	@Given("Admin creates PUT by programName Request for the LMS with {string} in request body")
	public void admin_creates_put_by_program_name_request_for_the_lms_with_in_request_body(
			String invalidDataInRequestBody) {
		String program_Name = program.getProgramNameTwo();
		String authToken = program.getAuthToken();
		putProgram = program.setDetailsToUpdateProgramByName(putProgram, authToken, baseURI,
				updateProgramByNameServiceUrl, invalidDataInRequestBody, program_Name);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT by programName Request and invalid program request Body with endpoint")
	public void admin_sends_https_put_by_program_name_request_and_invalid_program_request_body_with_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Bad Request Status with error message for invalid request body and boolean success details")
	public void admin_receives_bad_request_status_with_error_message_for_invalid_request_body_and_boolean_success_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @PutByProgramName

	@Given("Admin creates PUT by programName Request for the LMS Program API endpoint to {string}")
	public void admin_creates_put_by_program_name_request_for_the_lms_program_api_endpoint_to(
			String updateProgramValidRequestBody) {
		String program_Name = program.getProgramNameTwo();
		String authToken = program.getAuthToken();
		putProgram = program.setDetailsToUpdateProgramByName(putProgram, authToken, baseURI,
				updateProgramByNameServiceUrl, updateProgramValidRequestBody, program_Name);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT Request with valid programName endpoint to update program")
	public void admin_sends_https_put_request_with_valid_program_name_endpoint_to_update_program() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
		program.setProgramName(response, "UniqueProgramIdTwo");
	}

	// @PutByProgramName-update status
	@Given("Admin creates PUT Request for the LMS API endpoint and Valid program Name and {string}")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and(String propertyName) {
		int program_ID = program.getProgramIDTwo();
		String program_Name = program.getProgramNameTwo();
		String authToken = program.getAuthToken();
		putProgram = program.setDetailsToUpdateProgramByName(getProgram, putProgram, authToken, baseURI,
				updateProgramByNameServiceUrl, propertyName, programActiveStatus, program_ID, program_Name);// get the
																											// program
																											// by ID and
																											// update
																											// status in
																											// responseBody
																											// and set
																											// updated
																											// requestBody
																											// to put
																											// request
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT by programName Request with valid programName endpoint to update program status")
	public void admin_sends_https_put_by_program_name_request_with_valid_program_name_endpoint_to_update_program_status() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} OK Status with updated status in response body")
	public void admin_receives_ok_status_with_updated_status_in_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// PutByProgramName-updateInvalidProgramDescription
	@Given("Admin creates PUT Request for the LMS API endpoint and invalid {string}")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_invalid(String propertyName) {
		int program_ID = program.getProgramIDTwo();
		String program_Name = program.getProgramNameTwo();
		String authToken = program.getAuthToken();
		putProgram = program.setDetailsToUpdateProgramByName(getProgram, putProgram, authToken, baseURI,
				updateProgramByNameServiceUrl, propertyName, invalidProgramDescription, program_ID, program_Name);// get
																													// the
																													// program
																													// by
																													// ID
																													// and
																													// update
																													// status
																													// in
																													// responseBody
																													// and
																													// set
																													// updated
																													// requestBody
																													// to
																													// put
																													// request
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS PUT by programName Request with valid programName endpoint to update program")
	public void admin_sends_https_put_by_program_name_request_with_valid_program_name_endpoint_to_update_program() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Bad Request Status with invalid programName error message and boolean success details")
	public void admin_receives_bad_request_status_with_invalid_program_name_error_message_and_boolean_success_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @invalidEndPoint
	@Given("Admin creates POST Request with invalid endpoint for the LMS with request body")
	public void admin_creates_post_request_with_invalid_endpoint_for_the_lms_with_request_body() {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, program.getAuthToken(), baseURI,
				"invalidEndpoint", "ValidProgramWithAllValidFieldsPresentInRequestBody");
		requestSpecs = postProgram.buildRequest();

	}

	@When("Admin sends HTTPS POST Request with valid request Body and invalid endpoint")
	public void admin_sends_https_post_request_with_valid_request_body_and_invalid_endpoint() {
		response = requestSpecs.post(postProgram.getServiceUrl());
	}

	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);
	}

	// @invalidEndPoint
	@Given("Admin creates GET Request for the LMS with valid baseURI")
	public void admin_creates_get_request_for_the_lms_with_valid_base_uri() {
		getProgram = program.setDetailsToReadProgram(getProgram, program.getAuthToken(), baseURI, "invalidEndpoint");
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends GET Request to the LMS API along with invalid endpoind")
	public void admin_sends_get_request_to_the_lms_api_along_with_invalid_endpoind() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	@Then("Admin receives {int} not found Status with error message")
	public void admin_receives_not_found_status_with_error_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates GET Request to retrieve a program by programID for the LMS API")
	public void admin_creates_get_request_to_retrieve_a_program_by_program_id_for_the_lms_api() {
		int program_ID = program.getProgramIDOne();
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, program.getAuthToken(), baseURI,
				"invalidEndpoint", program_ID);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET Request with invalid endpoint")
	public void admin_sends_https_get_request_with_invalid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl() + getProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status with error message and boolean success details")
	public void admin_receives_not_found_status_with_error_message_and_boolean_success_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates GET request to fetch all programs with admins for the LMS API")
	public void admin_creates_get_request_to_fetch_all_programs_with_admins_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgramWithAdmins(getProgram, program.getAuthToken(), baseURI,
				"invaliEndpoint");
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS Get all programs along with admins Request with invalid endpoint")
	public void admin_sends_https_get_all_programs_along_with_admins_request_with_invalid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	@Then("Admin receives {int} not found Status with correct error message")
	public void admin_receives_not_found_status_with_correct_error_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates PUT Request for the LMS API endpoint along with valid request Body with mandatory, additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_along_with_valid_request_body_with_mandatory_additional_fields() {
		int program_ID = program.getProgramIDOne();
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, program.getAuthToken(), baseURI,
				"invalidEndpoint", "UpdateProgramWithAllValidFieldsPresentInRequestBody", program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS Request with invalid programId endpoint")
	public void admin_sends_https_request_with_invalid_program_id_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success flag details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_flag_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory, additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields() {
		String program_Name = program.getProgramNameOne();
		putProgram = program.setDetailsToUpdateProgramByName(putProgram, program.getAuthToken(), baseURI,
				"invalidEndpoint", "UpdateProgramWithAllValidFieldsPresentInRequestBody", program_Name);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS Request with invalid programName endpoint")
	public void admin_sends_https_request_with_invalid_program_name_endpoint() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status with error message and boolean success flag details")
	public void admin_receives_not_found_status_with_error_message_and_boolean_success_flag_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_name() {
		String program_Name = program.getProgramNameOne();
		deleteProgram = program.setDetailsToDeleteProgramByName(deleteProgram, program.getAuthToken(), baseURI,
				deleteByProgramNameServiceUrl, program_Name);
		requestSpecs = deleteProgram.buildRequest();
	}

	@When("Admin sends HTTPS Delete by invalid programName Request with endpoint")
	public void admin_sends_https_delete_by_invalid_program_name_request_with_endpoint() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status along with error message and boolean success details")
	public void admin_receives_not_found_status_along_with_error_message_and_boolean_success_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidEndPoint
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_id() {
		int program_ID = program.getProgramIDOne();
		deleteProgram = program.setDetailsToDeleteProgramByName(deleteProgram, program.getAuthToken(), baseURI,
				"invalidEndpoint", program_ID);
		requestSpecs = deleteProgram.buildRequest();
	}

	@When("Admin sends HTTPS DELETE by invalid programID Request with endpoint")
	public void admin_sends_https_delete_by_invalid_program_id_request_with_endpoint() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status along with message and boolean success flag details")
	public void admin_receives_not_found_status_along_with_message_and_boolean_success_flag_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidPathParameter
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  {string}")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and(String invalidPathParameter) {
		String pathParam = program.getinvalidpathParameter(invalidPathParameter);
		deleteProgram = program.setDetailsToDeleteProgramByID(deleteProgram, program.getAuthToken(), baseURI,
				deleteByProgramIdServiceUrl, pathParam);
		requestSpecs = deleteProgram.buildRequest();
	}

	@Given("Admin creates GET Request for the LMS API endpoint  and  {string}")
	public void admin_creates_get_request_for_the_lms_api_endpoint_and(String invalidPathParameter) {
		String pathParam = program.getinvalidpathParameter(invalidPathParameter);
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, program.getAuthToken(), baseURI,
				getProgramByIdServiceUrl, pathParam);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET by invalid programID Request with endpoint")
	public void admin_sends_https_get_by_invalid_program_id_request_with_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl() + getProgram.getPathparam());
	}

	// @invalidBaseURI
	@Given("Admin creates GET Request to retrieve a program by programID for the LMS API with invalid baseURI")
	public void admin_creates_get_request_to_retrieve_a_program_by_program_id_for_the_lms_api_with_invalid_base_uri() {
		int program_ID = program.getProgramIDOne();
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, program.getAuthToken(), "invalidBaseURI",
				getProgramByIdServiceUrl, program_ID);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin sends HTTPS GET Request along with valid endpoint and invalid baseURI")
	public void admin_sends_https_get_request_along_with_valid_endpoint_and_invalid_base_uri() {
		response = requestSpecs.get(getProgram.getServiceUrl() + getProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status with resp error message and boolean success details")
	public void admin_receives_not_found_status_with_resp_error_message_and_boolean_success_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

	// @invalidBaseURI
	@Given("Admin creates PUT Request for the LMS API endpoint along with valid request Body with invalid baseURI")
	public void admin_creates_put_request_for_the_lms_api_endpoint_along_with_valid_request_body_with_invalid_baseuri() {
		int program_ID = program.getProgramIDOne();
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, program.getAuthToken(), "invalidBaseURI",
				updateProgramByIdServiceUrl, "UpdateProgramWithAllValidFieldsPresentInRequestBody", program_ID);
		requestSpecs = putProgram.buildRequest();
	}

	@When("Admin sends HTTPS Request with valid programId endpoint and invalid baseURI")
	public void admin_sends_https_request_with_valid_program_id_endpoint_and_invalid_base_uri() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}

	@Then("Admin receives {int} Not Found Status with appropriate error message and boolean success flag details")
	public void admin_receives_not_found_status_with_appropriate_error_message_and_boolean_success_flag_details(
			Integer expectedStatusCode) {
		restUtil.validateStatusCode_responseTime(response, expectedStatusCode);

	}

}
