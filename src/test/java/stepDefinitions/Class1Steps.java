package stepDefinitions;

import org.testng.annotations.BeforeMethod;

import apiActions.Class1Actions;
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
		
		
		
	}

	@Then("Admin receives {int} status with error message Not Found for class")
	public void admin_receives_status_with_error_message_not_found_for_class(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	
	@When("Admin creates GET Request and Admin sends HTTPS Request with invalid method endpoint for class")
	public void admin_creates_get_request_and_admin_sends_https_request_with_invalid_method_endpoint_for_class() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Admin receives {int} Method not allowed status visible for class")
	public void admin_receives_method_not_allowed_status_visible_for_class(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	
	
	
	
	

}
