package stepDefinitions;

import org.testng.annotations.BeforeMethod;

import apiActions.ProgramActions;
import apiActions.class1Actions;
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

public class class1Steps {
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
	private static BaseRequest getClass1DeleteClass;
	private static BaseRequest addClass1;
	ApiUtils restUtil = new ApiUtils();
	class1Actions class1 = new class1Actions();
	static String requestBody="";
	private static boolean isAuthTokenGenerated = false;
	public static String token;
	static String updatedRequestBody="";

	@BeforeAll
	public static void setup() {
		if (!isAuthTokenGenerated) {

			login= class1Actions.validLogin(login);
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
		getClass1AllClass = class1Actions.setDetailsToReadClass1(getClass1AllClass);
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
		getClass1 = class1Actions.setDetailsToReadClass1GetAllclasswithInvalidEndpoint(getClass1);
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
		getClass1 = class1Actions.setDetailsToReadClass1forGetwithInvalidMethod(getClass1);
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
		getClass1 = class1Actions.setDetailsToReadClass1GetAllClassInvalidAuth(getClass1);
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
		getClass1 = class1Actions.setDetailsToReadClass1classDetailsByvalidClassTopic(getClass1);
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
		getClass1 = class1Actions.setDetailsToReadClass1AllClassesByInvalidClasstopic(getClass1);
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
		getClass1 = class1Actions.setDetailsToReadClass1GetAllClassesWithInvalidEndpoint(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());
	}
	@Then("Admin receives {int} {string} Status with message visible")
	public void admin_receives_status_with_message_visible(Integer statusCode, String statusMessage) {
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		restUtil.validateStatusMessage(response, statusMessage);
	}
	@When("Admin creates GET Request and Admin sends HTTPS Request without Authorization for classtopic")
	public void admin_creates_get_request_and_admin_sends_https_request_without_authorization_for_classtopic() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		getClass1 = class1Actions.setDetailsToReadClass1GetAllClasswithInvalidAuth(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());	
	}
	@When("Admin creates GET Request and Admin sends HTTPS Request with not valid  method endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_not_valid_method_endpoint_for_class() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		getClass1 = class1Actions.setDetailsToReadClass1GetClassByClassWithInvalidMethod(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.post(getClass1.getServiceUrl());
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
		getClass1 = class1Actions.setDetailsToReadClass1GetAllClasswithInvalidAuth(getClass1);
		requestSpecs = getClass1.buildRequest();
		response = requestSpecs.get(getClass1.getServiceUrl());	
	}


	@Then("Admin receives {int} status with error message of {string} for class")
	public void admin_receives_status_with_error_message_of_for_calss(Integer statusCode,String statusMessage ) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
		restUtil.validateStatusCode(response, statusCode);
		restUtil.validateStatusMessage(response, statusMessage);
	}


	@When("Admin creates GET Request and Admin sends HTTPS Request with valid classId endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_valid_class_id_endpoint_for_class() {
		   getClass1 = class1Actions.setDetailsToReadClass1RecordingsByValidClassID(getClass1);
	    	requestSpecs = getClass1.buildRequest();
	    response = requestSpecs.get(getClass1.getServiceUrl());
	}
	@Then("Admin receives {int} {string} Status with response body with valid classId for class")
	public void admin_receives_status_with_response_body_with_valid_class_id_for_class(Integer statusCode, String statusMessage) {
		restUtil.extractRes(response);
    	restUtil.validateStatusCode(response, statusCode);
    	restUtil.validateStatusMessage(response, statusMessage);
	}
	
	@When("Admin creates GET Request  and Admin sends HTTPS Request with invalid classid endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_classid_endpoint_for_class() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 getClass1 = class1Actions.setDetailsToReadClass1allclassesByInvalidClassID(getClass1);
	    	requestSpecs = getClass1.buildRequest();
	    response = requestSpecs.get(getClass1.getServiceUrl());	
	}
	@Then("Admin receives {int} {string} Status with message visible for class")
	public void admin_receives_status_with_message_visible_for_class(Integer statusCode, String statusMessage) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
    	restUtil.validateStatusCode(response, statusCode);
    	restUtil.validateStatusMessage(response, statusMessage);
	}
	
	@When("Admin creates GET Request for invalid endpoint and Admin sends HTTPS Request with invalid endpoint  for class")
	public void admin_creates_get_request_for_invalid_endpoint_and_admin_sends_https_request_with_invalid_endpoint_for_class() {
		getClass1 = class1Actions.setDetailsToReadClass1ByClassIDforInvalidEndpoint(getClass1);
    	requestSpecs = getClass1.buildRequest();
    response = requestSpecs.get(getClass1.getServiceUrl());
   
	}
	@Then("Admin receives {int} {string} Status with message for invalid endpoint  visible for class")
	public void admin_receives_status_with_message_for_invalid_endpoint_visible_for_class(Integer statusCode, String statusMessage) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		restUtil.extractRes(response);
    	restUtil.validateStatusCode(response, statusCode);
    	restUtil.validateStatusMessage(response, statusMessage);
	}
	@When("Admin creates GET Request for invalid method and Admin sends HTTPS Request with endpoint for class")
	public void admin_creates_get_request_for_invalid_method_and_admin_sends_https_request_with_endpoint_for_class() {
		   getClass1 = class1Actions.setDetailsToCreateClass1ClassdetailsByInvalidMethod(getClass1);
	    	requestSpecs = getClass1.buildRequest();
	    response = requestSpecs.post(getClass1.getServiceUrl());
	}
	@Then("Admin receives {int} and {string} status visible of invalid method for class")
	public void admin_receives_and_status_visible_of_invalid_method_for_class(Integer statusCode, String statusMessage) {
		restUtil.extractRes(response);
    	restUtil.validateStatusCode(response, statusCode);
    	restUtil.validateStatusMessage(response, statusMessage);
	}
	@When("Admin creates GET Request and Admin sends HTTPS Request without Authorizationwith endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_without_authorizationwith_endpoint_for_class() {
	     getClass1 = class1Actions.setDetailsToReadClass1ForInvalidAuth(getClass1);
	    	requestSpecs = getClass1.buildRequest();
	    response = requestSpecs.get(getClass1.getServiceUrl());
		}
	
	@When("Admin creates DELETE Request with valid classId and Admin sends HTTPS Request  with endpoint for class")
	public void admin_creates_delete_request_with_valid_class_id_and_admin_sends_https_request_with_endpoint_for_class() {
		getClass1DeleteClass = class1Actions.setDetailstoDeleteclass(getClass1DeleteClass);
		requestSpecs = getClass1DeleteClass.buildRequest();
		response = requestSpecs.delete(getClass1DeleteClass.getServiceUrl());
	}
	@Then("Admin receives {int} Ok status with message for class")
	public void admin_receives_ok_status_with_message_for_class(Integer statusCode) {
		restUtil.validateStatusCode(response, statusCode);
		//restUtil.validateStatusMessage(response, statusMessage);
	}

	
	@When("Admin creates DELETE Request with valid classId and Admin sends HTTPS Request  with invalid endpoint for class")
	public void admin_creates_delete_request_with_valid_class_id_and_admin_sends_https_request_with_invalid_endpoint_for_class() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		getClass1DeleteClass = class1Actions.setDetailstoDeleteclasswithinvalidendpoint(getClass1DeleteClass);
		requestSpecs = getClass1DeleteClass.buildRequest();
		response = requestSpecs.delete(getClass1DeleteClass.getServiceUrl());
	}
	@Then("Admin receives {int} not found for class")
	public void admin_receives_not_found_for_class(Integer statusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		restUtil.validateStatusCode(response, statusCode);
	}
	

@When("Admin creates DELETE Request with invalid classId and Admin sends HTTPS Request  with endpoint for class")
public void admin_creates_delete_request_with_invalid_class_id_and_admin_sends_https_request_with_endpoint_for_class() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	getClass1DeleteClass = class1Actions.setDetailstoDeleteclasswithinvalidclassid(getClass1DeleteClass);
	requestSpecs = getClass1DeleteClass.buildRequest();
	response = requestSpecs.delete(getClass1DeleteClass.getServiceUrl());
}
@Then("Admin receives {int} Not Found Status with message and boolean success details for class")
public void admin_receives_not_found_status_with_message_and_boolean_success_details_for_class(Integer statusCode) {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	restUtil.validateStatusCode(response, statusCode);
}
@When("Admin creates DELETE Request without authorization with valid classId and Admin sends HTTPS Request  with endpoint for class")
public void admin_creates_delete_request_without_authorization_with_valid_class_id_and_admin_sends_https_request_with_endpoint_for_class() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	getClass1DeleteClass = class1Actions.setDetailstoDeleteclasswithvalidclassidwithoutauth(getClass1DeleteClass);
	requestSpecs = getClass1DeleteClass.buildRequest();
	response = requestSpecs.delete(getClass1DeleteClass.getServiceUrl());
}
@Then("Admin receives {int} Unauthorized Status  for class")
public void admin_receives_unauthorized_status_for_class(Integer statusCode) {
	restUtil.validateStatusCode(response, statusCode);
}

	   
@When("Admin creates POST Request with request body for create class")
public void admin_creates_post_request_with_request_body_for_create_class() {
	addClass1 = class1Actions.setDetailsToAddClass(addClass1);
	requestSpecs = addClass1.buildRequest();
	response = requestSpecs.post(addClass1.getServiceUrl());
	
}


@When("Admin creates POST Request with request body for mandatory createClass")
public void admin_creates_post_request_with_request_body_for_mandatory_createclass() {
	addClass1 = class1Actions.setDetailsToAddClassMandatory(addClass1);
	requestSpecs = addClass1.buildRequest();
	response = requestSpecs.post(addClass1.getServiceUrl());
	
}

@When("Admin creates POST Request for only addditional field values createClass")
public void admin_creates_post_request_for_only_additional_field_values_createclass() {
	addClass1 = class1Actions.setDetailsToAddClassOnlyAdditional(addClass1);
	requestSpecs = addClass1.buildRequest();
	response = requestSpecs.post(addClass1.getServiceUrl());
	
}

@Then("Admin receive {int} {string} Status for createClass")
public void admin_receive_status_for_createClass(Integer statusCode, String statusMessage) {
	restUtil.extractRes(response);
	class1Actions.setClassID(response);
	class1Actions.getClassIDOne();
	class1Actions.setClassTopic(response);
	class1Actions.getClassTopicOne();
	restUtil.validateStatusCode(response, statusCode);
	restUtil.validateStatusMessage(response, statusMessage);

}


@Then("Admin receive {int} bad request for createClass")
public void admin_receive_bad_request_for_createclass(Integer statusCode) {
	restUtil.validateStatusCode(response, statusCode);
}
	
	
}