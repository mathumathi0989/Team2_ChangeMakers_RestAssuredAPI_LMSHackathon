package stepDefinitions;
import org.testng.annotations.BeforeMethod;

import apiActions.ProgramActions;
import apiActions.UserLoginActions;
import apiActions.class2Actions;
import apiConfig.EnvConstants;
import generics.ApiUtils;
import generics.LoggerLoad;
import httpRequest.BaseRequest;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginSteps {

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
	private static BaseRequest getlogin;
	private static BaseRequest getClass2;
	private static BaseRequest updateClass2;
	

	ApiUtils restUtil = new ApiUtils();
	static String requestBody="";
	private static boolean isAuthTokenGenerated = false;
	public static String token;
	static String updatedRequestBody="";
	
	
	   @BeforeAll
	    public static void setup() {
	        if (!isAuthTokenGenerated) {
	        	
	        	login= class2Actions.validLogin(login);
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
	    
	    
	    @Given("Admin sets Authorization for class module login")
	    public void admin_sets_authorization_for_class_module_login() {
	    	
	    	LoggerLoad.info("Executing some precondition step => Check authentication details");
	    			if(isAuthTokenGenerated == true) {	
	    				LoggerLoad.info("User is authenticated!!!");
	    			} else {
	    				LoggerLoad.info("Unauthorized User warning!!!");
	    			}	
	    			
	    }
	    	
	//for valid credentials
	    		    
	@When("Admin calls Post Https method  with valid endpoint login")
	public void admin_calls_post_https_method_with_valid_endpoint_login() {
		getlogin =UserLoginActions.validLogin(getlogin);
		requestSpecs=getlogin.buildRequest();
		 response = requestSpecs.post(getlogin.getServiceUrl());
		
	}
	
	@Then("Admin receives {int} OK Status with login response body")
	public void admin_receives_ok_status_with_login_response_body(Integer int1) {
		restUtil.validateStatusCode(response, int1);
	}
	

	//for invalid endpoint

	
	@When("Admin calls Post Https method with invalid endpoint login")
	public void admin_calls_post_https_method_with_invalid_endpoint_login() {
		getlogin= UserLoginActions.invalidLogin(getlogin);
		requestSpecs=getlogin.buildRequest();
		response =requestSpecs.post(getlogin.getServiceUrl());
	}
	   
	
	
	@Then("Admin receives {int} unauthorized status login")
	public void admin_receives_unauthorized_status_login(Integer int1) {
		restUtil.validateStatusCode(response, int1);
	}


//for invalid credentials

 @When("Admin calls Post Https method with valid endpoint login1")
  public void admin_calls_post_https_method_with_valid_endpoint_login1() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

  @Then("Admin receives {int} Bad request login")
public void admin_receives_bad_request_login(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
	
}
