package stepDefinitions;

import org.testng.annotations.BeforeMethod;
import apiConfig.EnvConstants;
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

	public static RequestSpecification requestSpecs ;
	static Response response;
	private String loginServiceUrl = EnvConstants.endPoint_Login;
	private String getAllProgramsServiceUrl=EnvConstants.endPoint_GetAllPrograms;
	private String getProgramByIdServiceUrl = EnvConstants.endPoint_GetProgramByID;
	private String getProgramWithUsersServiceUrl = EnvConstants.endPoint_GetProgramWithUsers;
	private String postProgramServiceUrl=EnvConstants.endPoint_CreateProgram;
	private String putProgramByNameServiceUrl = EnvConstants.endPoint_UpdateProgramByProgName;
	private String putProgramByIdServiceUrl = EnvConstants.endPoint_UpdateProgramByProgName;
	private String deleteByIdServiceUrl=EnvConstants.endPoint_DeleteProgramById;
	private String file_Path_postProgram=EnvConstants.file_Path_CreateProgram;
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
	
	ApiUtils restUtil = new ApiUtils();
	static String requestBody="";
	private static boolean isAuthTokenGenerated = false;
	public static String token;
	static String updatedRequestBody="";
	
    @BeforeAll
    public static void setup() {
        if (!isAuthTokenGenerated) {
        	
        	login= ProgramActions.validLogin(login);
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
	
    @Given("Admin provides valid authentication details")
    public void admin_provides_valid_authentication_details() {
    	
    	LoggerLoad.info("Executing some precondition step => Check authentication details");
    			if(isAuthTokenGenerated == true) {	
    				LoggerLoad.info("User is authenticated!!!");
    			} else {
    				LoggerLoad.info("Unauthorized User warning!!!");
    			}	
    }
    
    @When("Admin creates and executes get all program request for the lms api")
    public void admin_creates_and_executes_get_all_program_request_for_the_lms_api() {
		getProgram = ProgramActions.setDetailsToReadProgram(getProgram);
    	requestSpecs = getProgram.buildRequest();
	    response = requestSpecs.get(getProgram.getServiceUrl());
		
    }
    @Then("Admin receives {int} ok status with program response body")
    public void admin_receives_ok_status_with_program_response_body(Integer int1) {
    	restUtil.validateStatusCode(response, int1);
		
    }
	
	
	
}
