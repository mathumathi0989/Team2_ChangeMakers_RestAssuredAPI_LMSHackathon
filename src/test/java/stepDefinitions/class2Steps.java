package stepDefinitions;

import org.testng.annotations.BeforeMethod;
import apiActions.ProgramActions;
import apiActions.class2Actions;
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

public class class2Steps {

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
	    
	    
	    @Given("Admin sets Authorization for class module")
	    public void admin_sets_authorization_for_class_module() {
	    	
	    	LoggerLoad.info("Executing some precondition step => Check authentication details");
	    			if(isAuthTokenGenerated == true) {	
	    				LoggerLoad.info("User is authenticated!!!");
	    			} else {
	    				LoggerLoad.info("Unauthorized User warning!!!");
	    			}	
	    			
	    }
	 
	    //GetAllRecordings step definition

	    @When("Admin creates GET Request and sends HTTPS Request with endpoint for getAllRecordings")
	    public void admin_creates_get_request_and_sends_https_request_with_endpoint_for_getallrecordings() {
	    	getClass2 = class2Actions.setDetailsToReadClass2GetAllRecordings(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	
	    @When("Admin creates GET Request and sends HTTPS Request with invalid endpoint for getAllRecordings")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_endpoint_for_getallrecordings() {
	    	getClass2 = class2Actions.setDetailsToReadClass2GetAllRecordingsInvalidEndpoint(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	    
	    
	   @When("Admin creates Other Request and sends HTTPS Request with valid endpoint for getAllRecordings")
	    public void admin_creates_other_request_and_sends_https_request_with_valid_endpoint_for_getallrecordings() {
		   getClass2 = class2Actions.setDetailsToCreateClass2forGet(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.post(getClass2.getServiceUrl());
		 
	    }
	    
	   
	   
	   @When("Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getAllRecordings")
	    public void admin_creates_get_request_and_sends_https_request_with_valid_endpoint_but_without_auth_for_getallrecordings() {
		   getClass2 = class2Actions.setDetailsToReadClass2GetAllRecordingsInvalidAuth(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
		 
	    }
	    
	   
	    @Then("Admin receives {int} {string} Status for getAllRecordings")
	    public void admin_receives_status_for_getallrecordings(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }

	    
	  //GetClassRecordingsbyBatchId step definition
	    
	   @When("Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByBatchID")
	    public void admin_creates_get_request_and_sends_https_request_with_endpoint_for_getClassRecordingsByBatchID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByBatchIDValid(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   
	   @When("Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByBatchID")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_batchID_for_getClassRecordingsByBatchID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByBatchIDInvalidBatchID(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	    
	   @When("Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByBatchID")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_endpoint_for_getClassRecordingsByBatchID() {
	    	getClass2 = class2Actions.setDetailsToReadClass2RecordingsByBatchIDInvalidEndpoint(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   @When("Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByBatchID")
	    public void admin_creates_other_request_and_sends_https_request_with_valid_endpoint_for_getClassRecordingsByBatchID() {
		   getClass2 = class2Actions.setDetailsToCreateClass2RecordingsByBatchIDforGet(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.post(getClass2.getServiceUrl());
		 
	    }
	   
	   @When("Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByBatchID")
	    public void admin_creates_get_request_and_sends_https_request_with_valid_endpoint_but_without_auth_for_getClassRecordingsByBatchID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByBatchIDInvalidAuth(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
		 
	    }
	   
	   @Then("Admin receives {int} {string} Status for getClassRecordingsByBatchID")
	    public void admin_receives_status_for_getClassRecordingsByBatchID(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }

	    
	    
	   //GetClassRecordingsbyClassID step definition
	    
	   @When("Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByClassID")
	    public void admin_creates_get_request_and_sends_https_request_with_endpoint_for_getClassRecordingsByClassID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassIDValid(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   
	   @When("Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByClassID")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_batchID_for_getClassRecordingsByClassID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassIDInvalidBatchID(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	    
	   @When("Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByClassID")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_endpoint_for_getClassRecordingsByClassID() {
	    	getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassIDInvalidEndpoint(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   @When("Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByClassID")
	    public void admin_creates_other_request_and_sends_https_request_with_valid_endpoint_for_getClassRecordingsByClassID() {
		   getClass2 = class2Actions.setDetailsToCreateClass2RecordingsByClassIDforGet(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.post(getClass2.getServiceUrl());
		 
	    }
	   
	   @When("Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByClassID")
	    public void admin_creates_get_request_and_sends_https_request_with_valid_endpoint_but_without_auth_for_getClassRecordingsByClassID() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassIDInvalidAuth(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
		 
	    }
	   
	   @Then("Admin receives {int} {string} Status for getClassRecordingsByClassID")
	    public void admin_receives_status_for_getClassRecordingsByClassID(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }

	   //GetClassRecordingsbyClassID2 step definition
	    
	   @When("Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByClassID2")
	    public void admin_creates_get_request_and_sends_https_request_with_endpoint_for_getClassRecordingsByClassID2() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassID2Valid(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   
	   @When("Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByClassID2")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_batchID_for_getClassRecordingsByClassID2() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassID2InvalidBatchID(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	    
	   @When("Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByClassID2")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_endpoint_for_getClassRecordingsByClassID2() {
	    	getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassID2InvalidEndpoint(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   @When("Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByClassID2")
	    public void admin_creates_other_request_and_sends_https_request_with_valid_endpoint_for_getClassRecordingsByClassID2() {
		   getClass2 = class2Actions.setDetailsToCreateClass2RecordingsByClassID2forGet(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.post(getClass2.getServiceUrl());
		 
	    }
	   
	   @When("Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByClassID2")
	    public void admin_creates_get_request_and_sends_https_request_with_valid_endpoint_but_without_auth_for_getClassRecordingsByClassID2() {
		   getClass2 = class2Actions.setDetailsToReadClass2RecordingsByClassID2InvalidAuth(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
		 
	    }
	   
	   @Then("Admin receives {int} {string} Status for getClassRecordingsByClassID2")
	    public void admin_receives_status_for_getClassRecordingsByClassID2(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }

	    
	   
	 //GetUpcomingClasses step definition
	    
	   @When("Admin creates GET Request and sends HTTPS Request with endpoint for getUpcomingClasses")
	    public void admin_creates_get_request_and_sends_https_request_with_endpoint_for_getUpcomingClasses() {
		   getClass2 = class2Actions.setDetailsToReadClass2UpcomingClassesValid(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   
	   @When("Admin creates GET Request and sends HTTPS Request with invalid studentID for getUpcomingClasses")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_studentID_for_getUpcomingClasses() {
		   getClass2 = class2Actions.setDetailsToReadClass2UpcomingClassesInvalidStudentID(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	    
	   @When("Admin creates GET Request and sends HTTPS Request with invalid endpoint for getUpcomingClasses")
	    public void admin_creates_get_request_and_sends_https_request_with_invalid_endpoint_for_getUpcomingClasses() {
	    	getClass2 = class2Actions.setDetailsToReadClass2UpcomingClassesInvalidEndpoint(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
	    }
	    
	   @When("Admin creates Other Request and sends HTTPS Request with valid endpoint for getUpcomingClasses")
	    public void admin_creates_other_request_and_sends_https_request_with_valid_endpoint_for_getUpcomingClasses() {
		   getClass2 = class2Actions.setDetailsToCreateClass2UpcomingClassesforGet(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.post(getClass2.getServiceUrl());
		 
	    }
	   
	   @When("Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getUpcomingClasses")
	    public void admin_creates_get_request_and_sends_https_request_with_valid_endpoint_but_without_auth_for_getUpcomingClasses() {
		   getClass2 = class2Actions.setDetailsToReadClass2UpcomingClassesInvalidAuth(getClass2);
	    	requestSpecs = getClass2.buildRequest();
	    response = requestSpecs.get(getClass2.getServiceUrl());
		 
	    }
	   
	   @Then("Admin receives {int} {string} Status for getUpcomingClasses")
	    public void admin_receives_status_for_getUpcomingClasses(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }


	   //Update Class step definition
	    
	   
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and all the fields for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_all_the_fields_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClass(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	    
	   
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and all the fields without Auth for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_all_the_fields_without_auth_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassWithoutAuth(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	  
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and mandatory fields for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_mandatory_fields_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassMandatoryValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	   
	   @When("Admin creates PUT Request and sends HTTPS Request with invalid classId and mandatory fields for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_invalid_classid_and_mandatory_fields_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassMandatoryInValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and missing mandatory fields for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_missing_mandatory_fields_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassMissingMandatoryValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	   
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and invalid data for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_invalid_data_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassInvalidDataValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	  
	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and invalid endpoint for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_invalid_endpoint_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassInvalidEndpointValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   

	   @When("Admin creates PUT Request and sends HTTPS Request with valid classId and deleted batchID for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_valid_classid_and_deleted_batchid_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassDeletedBatchIDValidClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	  
	   @When("Admin creates PUT Request and sends HTTPS Request with deleted classId for updateClass")
	    public void admin_creates_put_request_and_sends_https_request_with_deleted_classid_for_updateclass() {
		   updateClass2 = class2Actions.setDetailsToUpdateClassDeletedClassID(updateClass2);
	    	requestSpecs = updateClass2.buildRequest();
	    	response = requestSpecs.put(updateClass2.getServiceUrl());
	    }
	   
	   
	   @Then("Admin receives {int} {string} Status for updateClass")
	    public void admin_receives_status_for_updateClass(Integer statusCode, String statusMessage) {
	    	restUtil.extractRes(response);
	    	restUtil.validateStatusCode(response, statusCode);
	    	restUtil.validateStatusMessage(response, statusMessage);
	    }

	   
	   
}
