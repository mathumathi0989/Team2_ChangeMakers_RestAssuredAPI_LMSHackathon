package stepDefinitions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import apiActions.ProgramActions;
import generics.LoggerLoad;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
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

	// @Program_S1_GetAllPrograms
	@When("Admin creates and executes GET all program Request for the LMS API")
	public void admin_creates_and_executes_get_all_program_request_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgram(getProgram);
		requestSpecs = getProgram.buildRequest();
		response = requestSpecs.get(getProgram.getServiceUrl());

	}

	@Then("Admin receives {int} OK Status with program response body")
	public void admin_receives_ok_status_with_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);

	}

	//@Program_S2_GetAllProgramsWithAdmins
	@Given("Admin creates GET Request to retrieve all programs with Admins for the LMS API")
	public void admin_creates_get_request_to_retrieve_all_programs_with_admins_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgramWithAdmins(getProgram);
		requestSpecs = getProgram.buildRequest();
	}

	@When("Admin executes HTTPS GET program request with valid endpoint")
	public void admin_executes_https_get_program_request_with_valid_endpoint() {
		response = requestSpecs.get(getProgram.getServiceUrl());
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);
	}

	//@Program_S3_PostNewProgram
	@When("Admin creates and executes POST program Request for the LMS with {string}")
	public void admin_creates_and_executes_post_program_request_for_the_lms_with_ValidRequestBody(String programType) {
		postProgram = program.setDetailsToCreateValidProgram(postProgram, programType);
		requestSpecs = postProgram.buildRequest();
		response = requestSpecs.post(postProgram.getServiceUrl());
		//program.setProgramID(response);
	} 
	@Then("Admin receives {int} Created Status with program response body containing {string}")
	public void admin_receives_created_status_with_program_response_body_containing_uniqueprogramids(Integer expectedStatusCode, String setProgramProperty) {
		restUtil.validateStatusCode(response, expectedStatusCode);
		program.setProgramID(response,setProgramProperty);
		program.setProgramName(response,setProgramProperty);
		
	}

	// @Program_S4_GetProgramByID
	@When("Admin creates and executes GET rogram with valid program ID Request for the LMS API")
	public void admin_creates_and_executes_get_rogram_with_valid_program_id_request_for_the_lms_api() {
		getProgram = program.setDetailsToReadProgramByPrgmID(getProgram, program.getProgramIDOne());
		requestSpecs = getProgram.buildRequest();
		response = requestSpecs.get(getProgram.getServiceUrl() + getProgram.getPathparam());
	}
	@Then("Admin receives {int} OK Status with required program response body")
	public void admin_receives_ok_status_with_required_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);
	}
	
	//@Program_S5_PutByProgramID
	@Given("Admin creates PUT Request for the LMS Program API endpoint to {string}")
	public void admin_creates_put_request_for_the_lms_program_api_endpoint_to_(String programType) {
		putProgram = program.setDetailsToUpdateProgramByID(putProgram, programType);
		requestSpecs = putProgram.buildRequest();
	}
	@When("Admin sends HTTPS PUT Request with valid endpoint to update program")
	public void admin_sends_https_put_request_with_valid_endpoint_to_update_program() {
		response = requestSpecs.put(putProgram.getServiceUrl() + putProgram.getPathparam());
	}
	@Then("Admin receives {int} OK Status with updated value in program response body")
	public void admin_receives_ok_status_with_updated_value_in_program_response_body(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);
		program.setProgramName(response, "UniqueProgramIdOne");//Setting updated programName in EnvVariables
		System.out.println("Updated program Name is : "+EnvVariables.programNameOne);
	}

	// @Program_S6_DeleteProgramByID
	@Given("Admin creates DELETE Request for the LMS Program API endpoint and valid program ID")
	public void admin_creates_delete_request_for_the_lms_program_api_endpoint_and_valid_program_id() {
		deleteProgram = program.setDetailsToDeleteProgramByID(deleteProgram);
		requestSpecs = deleteProgram.buildRequest();

	}

	@When("Admin sends HTTPS DELETE program by programId Request with valid endpoint")
	public void admin_sends_https_delete_program_by_program_id_request_with_valid_endpoint() {
		//response = requestSpecs.delete(deleteProgram.getServiceUrl() + program.getProgramIDOne());
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}

	@Then("Admin receives {int} Ok status with successful program deletion message")
	public void admin_receives_ok_status_with_successful_program_deletion_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);	
	}
	
	//Program_S7_DeleteProgramByName
	@Given("Admin creates DELETE Request for the LMS API endpoint and valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		deleteProgram = program.setDetailsToDeleteProgramByName(deleteProgram);
		requestSpecs = deleteProgram.buildRequest();
	}
	@When("Admin sends HTTPS DELETE program by programName Request with endpoint")
	public void admin_sends_https_delete_program_by_program_name_request_with_endpoint() {
		response = requestSpecs.delete(deleteProgram.getServiceUrl() + deleteProgram.getPathparam());
	}
	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer expectedStatusCode) {
		restUtil.validateStatusCode(response, expectedStatusCode);
	}
}
