package stepDefinitions;

import org.testng.annotations.BeforeMethod;

import apiActions.Class1Actions;
import apiActions.class2Actions;
//import apiActions.ProgramActions;
import apiConfig.EnvConstants;
import generics.ApiUtils;
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

public class Class1Steps {
	public static RequestSpecification requestSpecs ;
	static Response response;
	private String loginServiceUrl = EnvConstants.endPoint_Login;
	private int http_Created = EnvConstants.http_Created;
	private int http_OK = EnvConstants.http_OK;
	private int http_NotFound = EnvConstants.http_NotFound;
	private int http_BadRequest = EnvConstants.http_BadRequest;
	private int http_Unauthorized = EnvConstants.http_UnAuthorized;
	private int http_MethodNotAllowed = EnvConstants.http_MethodNotAllowed;
	private static BaseRequest login;
	private static BaseRequest getClass1;
	private static BaseRequest getProgram;
	private static BaseRequest getClass1AllClass;
	ApiUtils restUtil = new ApiUtils();
	static String requestBody="";
	private static boolean isAuthTokenGenerated = false;
	public static String token;
	static String updatedRequestBody="";

	@BeforeAll
	public static void setup() {
		if (!isAuthTokenGenerated) {

			login= Class1Actions.validLogin(login);
			requestSpecs = login.buildRequest();
			response = requestSpecs.post(login.getServiceUrl());
			ApiUtils.setAuth(response);
			LoggerLoad.info("Executing setup code...");

			// Set the flag to true after execution
			isAuthTokenGenerated = true;
		}
	}

	@BeforeMethod
	public void scenario(Scenario scenario) {
		LoggerLoad.info("===============================================================================================");
		LoggerLoad.info(scenario.getSourceTagNames() +" : "+scenario.getName());
		LoggerLoad.info("-----------------------------------------------------------------------------------------------");

	}
	@Given("Admin sets Authorization for class1 module")
	public void admin_sets_authorization_for_class_module() {

		LoggerLoad.info("Executing some precondition step => Check authentication details");
		if(isAuthTokenGenerated == true) {	
			LoggerLoad.info("User is authenticated!!!");
		} else {
			LoggerLoad.info("Unauthorized User warning!!!");
		}
	}


	@When("Admin creates GET Request and Admin sends HTTPS Request with endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_endpoint_for_class() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		//restUtil.validateStatusCode(response, int1);
		getClass1AllClass = Class1Actions.setDetailsToReadClass1(getClass1AllClass);
		requestSpecs = getClass1AllClass.buildRequest();
		response = requestSpecs.get(getClass1AllClass.getServiceUrl());

	}


	@Then("Admin receives {int} {string} Status with response body for class")
	public void admin_receives_status_with_response_body_for_class(Integer statusCode, String statusMessage) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();

		//restUtil.validateStatusCode(response, statusCode);
		//restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);
	}

	@When("Admin creates GET Request and Admin sends HTTPS Request with invalid endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_endpoint_for_class() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		getClass1 = Class1Actions.setDetailsToReadClass1GetAllclasswithInvalidEndpoint(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());


	}

	@Then("Admin receives {int} status with error message Not Found for class")
	public void admin_receives_status_with_error_message_not_found_for_class(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);
	}


	@When("Admin creates GET Request and Admin sends HTTPS Request with invalid method endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_method_endpoint_for_class() {
		getClass1 = Class1Actions.setDetailsToReadClass1forGetwithInvalidEndpoint(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.post(getClass1.getServiceUrl());
	}

	@Then("Admin receives {int} Method not allowed status visible for class")
	public void admin_receives_method_not_allowed_status_visible_for_class(Integer statusCode) {
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
	}

	@When("Admin creates GET Request and admin sends HTTPS Request  without Authorization for class")
	public void admin_creates_get_request_and_admin_sends_https_request_without_authorization_for_class() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		getClass1 = Class1Actions.setDetailsToReadClass1GetAllClassInvalidAuth(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());	 
	}

	@Then("Admin receives {int} status with error message Unauthorized for class")
	public void admin_receives_status_with_error_message_unauthorized_for_class(Integer statusCode) {
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);
	}
	@When("Admin creates GET Request and Admin sends HTTPS Request with endpoint for a class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_endpoint_for_a_class() {
		getClass1 = Class1Actions.setDetailsToReadClass1classDetailsByvalidClassTopic(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());

	}
	@Then("Admin receives {int} OK Status with response body for class")
	public void admin_receives_ok_status_with_response_body_for_class(Integer statusCode) {
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);

	}

	@When("Admin creates GET Request and Admin sends HTTPS Request with invalid classtopic endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_classtopic_endpoint_for_class() {
		getClass1 = Class1Actions.setDetailsToReadClass1AllClassesByInvalidClasstopic(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());
	}

	@Then("Admin receives {int} Not Found Status with message visible for class")
	public void admin_receives_not_found_status_with_message_visible_for_class(Integer statusCode) {
		restUtil.extractRes(response);
		//restUtil.validateStatusCode(response, statusCode);
	}

	@When("Admin creates GET Request and Admin sends HTTPS Request with invalid endpoint")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_endpoint() {
		getClass1 = Class1Actions.setDetailsToReadClass1GetAllClassesWithInvalidEndpoint(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());
	}
	@Then("Admin receives {int} {string} Status with message visible")
	public void admin_receives_status_with_message_visible(Integer statusCode, String statusMessage) {
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		restUtil.validateStatusMessage(response, statusMessage);
	}

	@When("Admin creates GET Request and Admin sends HTTPS Request with not valid  method endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_not_valid_method_endpoint_for_class() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		getClass1 = Class1Actions.setDetailsToReadClass1GetAllClassesWithInvalidMethodEndpoint(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());
	}
	@Then("Admin receives {int} and {string} status visible for class")
	public void admin_receives_and_status_visible_for_class(Integer statusCode,String statusMessage) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		restUtil.validateStatusMessage(response, statusMessage);
	}

	@When("Admin creates GET Request and Admin sends HTTPS Request with endpoint Unauthorized for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_endpoint_Unauthorized_for_class() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		getClass1 = Class1Actions.setDetailsToReadClass1GetAllClasswithInvalidAuth(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());	
	}


	@Then("Admin receives 401 status with error message of Unauthorized for class")
	public void admin_receives_status_with_error_message_of_unauthorized_for_calss(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);
	}


	@When("Admin creates GET Request and Admin sends HTTPS Request with valid classId endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_valid_class_id_endpoint_for_class() {
		
	}
	@Then("Admin receives {int} {string} Status with response body with valid classId for class")
	public void admin_receives_status_with_response_body_with_valid_class_id_for_class(Integer int1, String string) {
		
	}

}
