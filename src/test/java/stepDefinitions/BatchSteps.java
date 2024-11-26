package stepDefinitions;

import org.testng.annotations.BeforeMethod;
import apiConfig.EnvConstants;
import generics.ApiUtils;
import apiActions.BatchActions;
import apiActions.class1Actions;
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

public class BatchSteps {

    public static RequestSpecification requestSpecs;
    static Response response;
    private String loginServiceUrl = EnvConstants.endPoint_Login;
    private String getAllBatchesServiceUrl = EnvConstants.endPoint_GetAllBatches;
    private String getBatchByBatchIDServiceUrl = EnvConstants.endPoint_GetBatchByBatchID();
    private String getBatchByBatchNameServiceUrl = EnvConstants.endPoint_GetBatchByBatchName();
    private String getBatchByProgramIDServiceUrl = EnvConstants.endPoint_GetBatchByProgramID();
    private String postBatchServiceUrl = EnvConstants.endPoint_CreateBatch;
    private String putUpdateBatchByiDServiceUrl = EnvConstants.endPoint_UpdateBatchByBatchID;
    private String deleteBatchByBatchIDeleteBatchByBatchIDServiceUrl = EnvConstants.endPoint_DeleteBatchByBatchID;
    private String file_Path_postBatch = EnvConstants.file_Path_CreateBatch;
    private int http_Created = EnvConstants.http_Created;
    private int http_OK = EnvConstants.http_OK;
    private int http_NotFound = EnvConstants.http_NotFound;
    private int http_BadRequest = EnvConstants.http_BadRequest;
    private int http_Unauthorized = EnvConstants.http_UnAuthorized;
    private int http_MethodNotAllowed = EnvConstants.http_MethodNotAllowed;
    private static BaseRequest login;
    private static BaseRequest getBatch;
    private static BaseRequest postBatch;
    private static BaseRequest putBatch;
    private static BaseRequest deleteBatch;
    ApiUtils restUtil = new ApiUtils();
    static String requestBody = "";
    private static boolean isAuthTokenGenerated = false;
    public static String token;
    static String updatedRequestBody = "";

    @BeforeAll
    public static void setup() {
        if (!isAuthTokenGenerated) {

            login = BatchActions.validLogin(login);
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
        LoggerLoad.info(scenario.getSourceTagNames() + " : " + scenario.getName());
        LoggerLoad.info("-----------------------------------------------------------------------------------------------");

    }

    @Given("Admin provides valid UserName and PassWord")
    public void admin_provides_valid_username_and_password() {

        LoggerLoad.info("Executing some precondition step => Check authentication details");
        if (isAuthTokenGenerated == true) {
            LoggerLoad.info("User is authenticated!!!");
        } else {
            LoggerLoad.info("Unauthorized User warning!!!");
        }
    }

//    @GetAllBatches-(Positive1)
    @When("Admin creates and executes GET all batches Request for the LMS API")
    public void admin_creates_and_executes_get_all_batches_request_for_the_lms_api() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status for getALLBatches")
    public void admin_receives_ok_status_for_get_all_batches(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetAllBatches-(Positive2)
    @When("Admin creates and executes GET all batches Request with search string for the LMS API")
    public void admin_creates_and_executes_get_all_batches_request_with_search_string_for_the_lms_api() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status for getALLBatches2")
    public void admin_receives_ok_status_for_get_all_batches2(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchID
    @When("Admin creates and executes GET batch with valid batch ID Request for the LMS API")
    public void admin_creates_and_executes_get_batch_with_valid_batch_id_request_for_the_lms_api() {
        getBatch = BatchActions.setDetailsToReadBatchID(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status for getBatchByBatchID")
    public void admin_receives_ok_status_for_get_batch_by_batch_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchID-(Positive4)
    @When("Admin creates GET Request with valid Batch ID")
    public void admin_creates_get_request_with_valid_batch_id() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status with  batchStatus field {string} in the response body")
    public void admin_receives_ok_status_with_batch_status_field_in_the_response_body(Integer int1, String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);    }

//    @GetBatchByBatchName-(Positive5)
    @When("Admin creates and executes GET batch with valid batch Name Request for the LMS API")
    public void admin_creates_and_executes_get_batch_with_valid_batch_name_request_for_the_lms_api() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status for getBatchByBatchName")
    public void admin_receives_ok_status_for_get_batch_by_batch_name(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchName-(Positive6)
    @When("Admin creates GET Request with batch Name")
    public void admin_creates_get_request_with_batch_name() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives 200 OK Status for Get Batch By Batch Name")
    public void admin_receives_ok_status_for_get_batch_by_batch_name(Integer int1, String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @GetBatchByProgramID-(Positive7)
    @When("Admin creates and executes GET batch with valid program ID")
    public void admin_creates_and_executes_get_batch_with_valid_program_id() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status with response body for GetBatchByProgramId")
    public void admin_receives_ok_status_with_response_body_for_get_batch_by_program_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @PostNewBatch
    @When("Admin creates POST Request with valid data in request body")
    public void admin_creates_post_request_with_valid_data_in_request_body() {
        postBatch = BatchActions.setDetailsToAddBatch(postBatch);
        requestSpecs = postBatch.buildRequest();
        response = requestSpecs.post(postBatch.getServiceUrl());
    }
    @Then("Admin receives Created Status for post new batch with status code {int} and response message {string}")
    public void admin_receives_created_status_for_post_new_batch_with_status_code_and_response_message(Integer statusCode, String statusMessage) {
        restUtil.extractRes(response);
    	BatchActions.setBatchID(response);
    	BatchActions.getBatchIDOne();
    	BatchActions.setBatchName(response);
    	BatchActions.getBatchNameOne();
    	restUtil.validateStatusCode(response, statusCode);
    	restUtil.validateStatusMessage(response, statusMessage);
    }

//      @PostNewBatch-(Positive9)
@When("Admin creates POST Request with missing additional fields")
public void admin_creates_post_request_with_missing_additional_fields() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives Created Status for post2 new batch with status code {int} and response message {string}")
    public void admin_receives_created_status_for_post2_new_batch_with_status_code_and_response_message(Integer int1, String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

    //    @Put(UpdateBatchByBatchID)-(Positive10)
    @When("Admin creates PUT Request with valid BatchId and Data")
    public void admin_creates_put_request_with_valid_batch_id_and_data() {
        putBatch = BatchActions.setDetailsToReadBatch(putBatch);
        requestSpecs = putBatch.buildRequest();
        response = requestSpecs.put(putBatch.getServiceUrl());
    }
    @Then("Admin receives updated Status for put with status code {int} and response message {string}")
    public void admin_receives_updated_status_for_put_with_status_code_and_response_message(Integer int1, String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Positive11)
@When("Admin creates PUT Request with deleted batch Id")
public void admin_creates_put_request_with_deleted_batch_id() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives updated Status for put2 with status code {int} and response message {string}")
    public void admin_receives_updated_status_for_put2_with_status_code_and_response_message(Integer int1, String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @DeleteBatchByBatchID-(Positive12)
    @When("Admin creates DELETE request with valid batch ID")
    public void admin_creates_delete_request_with_valid_batch_id() {
        deleteBatch = BatchActions.setDetailsToReadBatch(deleteBatch);
        requestSpecs = deleteBatch.buildRequest();
        response = requestSpecs.delete(deleteBatch.getServiceUrl());
    }
    @Then("Admin receives {int} OK Status with message for DeleteBatchByBatchID")
    public void admin_receives_ok_status_with_message_for_delete_batch_by_batch_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//@GetAllBatches-(Negative1)
   @When("Admin creates GET Request \\(Negative1)")
   public void admin_creates_get_request_negative1() {
    getBatch = BatchActions.setDetailsToReadAllBatchInvalid(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} status with error message Not Found")
    public void admin_receives_status_with_error_message_not_found(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

// @GetAllBatches-(Negative2)
    @When("Admin creates GET Request \\(Negative2)")
    public void admin_creates_get_request_negative2() {
        getBatch = BatchActions.setDetailsToReadBatchWithoutAuth(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} status with error message Unauthorized")
    public void admin_receives_status_with_error_message_unauthorized(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchID-(Negative3)
    @When("Admin creates GET Request with valid Batch ID \\(Negative3)")
    public void admin_creates_get_request_with_valid_batch_id_negative3() {
    getBatch = BatchActions.setDetailsToReadBatchIDWithoutAuth(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} Status with error message unauthorized for GetAllBatches")
    public void admin_receives_status_with_error_message_unauthorized_for_get_all_batches(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchID-(Negative4)
    @When("Admin creates GET Request with invalid Batch ID \\(Negative4)")
    public void admin_creates_get_request_with_invalid_batch_id_negative4() {
        getBatch = BatchActions.setDetailsToReadBatchIDInvalidBatchID(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} Not Found Status with message and boolean success details")
    public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchID-(Negative5)
    @When("Admin creates GET Request with valid Batch ID \\(Negative5)")
    public void admin_creates_get_request_with_valid_batch_id_negative5() {
        getBatch = BatchActions.setDetailsToReadBatchIDInvalidEndpoint(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} not found Status")
    public void admin_receives_not_found_status(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchName-(Negative6)
    @When("Admin creates GET Request with batch Name\\(Negative6)")
    public void admin_creates_get_request_with_batch_name_negative6() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int}  Status with error message unauthorized for GetBatchByBatchName")
    public void admin_receives_status_with_error_message_unauthorized_for_get_batch_by_batch_name(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchName-(Negative7)
    @When("Admin creates GET Request with invalid Batch Name\\(Negative7)")
    public void admin_creates_get_request_with_invalid_batch_name_negative7() {
        getBatch = BatchActions.setDetailsToReadBatch(getBatch);
        requestSpecs = getBatch.buildRequest();
        response = requestSpecs.get(getBatch.getServiceUrl());
    }
    @Then("Admin receives {int} Not Found Status with message and boolean success details1")
    public void admin_receives_not_found_status_with_message_and_boolean_success_details1(Integer int1) {
            restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByBatchName-(Negative8)
@When("Admin creates GET Request with valid Batch Name\\(Negative8)")
public void admin_creates_get_request_with_valid_batch_name_negative8() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int} Not found")
    public void admin_receives_not_found(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByProgramID-(Negative9)
@When("Admin creates GET Request with program id\\(Negative9)")
public void admin_creates_get_request_with_program_id_negative9() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int}  Status with error message unauthorized for GetBatchByProgramId")
    public void admin_receives_status_with_error_message_unauthorized_for_get_batch_by_program_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByProgramID-(Negative10)
@When("Admin creates GET Request with invalid Program Id")
public void admin_creates_get_request_with_invalid_program_id() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int} Not Found Status with message and boolean success details for GetBatchByProgramId")
    public void admin_receives_not_found_status_with_message_and_boolean_success_details_for_get_batch_by_program_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByProgramID-(Negative10)
@When("Admin creates GET Request with invalid endpoint\\(Negative10)")
public void admin_creates_get_request_with_invalid_endpoint_negative10() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int}  Status with  error message Not Found for GetBatchByProgramId")
    public void admin_receives_status_with_error_message_not_found_for_get_batch_by_program_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @GetBatchByProgramID-(Negative11)
@When("Admin creates GET Request with program id\\(Negative11)")
public void admin_creates_get_request_with_program_id_negative11() {
    getBatch = BatchActions.setDetailsToReadBatch(getBatch);
    requestSpecs = getBatch.buildRequest();
    response = requestSpecs.get(getBatch.getServiceUrl());
}
    @Then("Admin receives {int} Not Found Status with message and boolean success details for batch")
    public void admin_receives_not_found_status_with_message_and_boolean_success_details_for_batch(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @PostNewBatch-(Negative12)
@When("Admin creates POST Request  with valid data in request body\\(Negative12)")
public void admin_creates_post_request_with_valid_data_in_request_body_negative12() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} Unauthorized for post new batch")
    public void admin_receives_unauthorized_for_post_new_batch(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @PostNewBatch-(Negative13)
@When("Admin creates POST Request  with existing value in request body\\(Negative13)")
public void admin_creates_post_request_with_existing_value_in_request_body_negative13() {

    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @PostNewBatch-(Negative14)
@When("Admin creates POST Request with invalid data in request body\\(Negative14)")
public void admin_creates_post_request_with_invalid_data_in_request_body_negative14() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details\\(Negative14)")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_negative14(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @PostNewBatch-(Negative15)
@When("Admin creates POST Request body\\(Negative15)")
public void admin_creates_post_request_body_negative15() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} not found  Status\\(Negative15)")
    public void admin_receives_not_found_status_negative15(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @PostNewBatch-(Negative16)
@When("Admin creates POST Request with invalid data in request body\\(Negative16)")
public void admin_creates_post_request_with_invalid_data_in_request_body_negative16() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details\\(Negative16)")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_negative16(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @PostNewBatch-(Negative17)
@When("Admin creates POST Request with inactive program id\\(Negative17)")
public void admin_creates_post_request_with_inactive_program_id_negative17() {
    postBatch = BatchActions.setDetailsToReadBatch(postBatch);
    requestSpecs = postBatch.buildRequest();
    response = requestSpecs.post(postBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details\\(Negative17)")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_negative17(Integer int1,String string) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, string);
    }

//    @Put(UpdateBatchByBatchID)-(Negative18)
@When("Admin creates PUT Request with valid BatchId and Data\\(Negative18)")
public void admin_creates_put_request_with_valid_batch_id_and_data_negative18() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} unauthorized status for UpdateBatchByBatchID")
    public void admin_receives_unauthorized_status_for_update_batch_by_batch_id(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Negative19)
@When("Admin creates PUT Request with invalid BatchId and valid Data\\(Negative19)")
public void admin_creates_put_request_with_invalid_batch_id_and_valid_data_negative19() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} Not Found Status with message and boolean success details for UpdateBatchByBatchID")
    public void admin_receives_not_found_status_with_message_and_boolean_success_details_for_update_batch_by_batch_id(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Negative20)
@When("Admin creates PUT Request with valid batch Id and missing mandatory fields\\(Negative20)")
public void admin_creates_put_request_with_valid_batch_id_and_missing_mandatory_fields_negative20() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details for UpdateBatchByBatchID")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_for_update_batch_by_batch_id(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Negative21)
@When("Admin creates PUT Request with invalid data\\(Negative21)")
public void admin_creates_put_request_with_invalid_data_negative21() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details for UpdateBatchByBatchID1")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_for_update_batch_by_batch_id1(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Negative22)
@When("Admin creates PUT Request with Valid batch Id\\(Negative22)")
public void admin_creates_put_request_with_valid_batch_id_negative22() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} not found for UpdateBatchByBatchID")
    public void admin_receives_not_found_for_update_batch_by_batch_id(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @Put(UpdateBatchByBatchID)-(Negative23)
@When("Admin creates PUT Request with Valid batch Id\\(Negative23)")
public void admin_creates_put_request_with_valid_batch_id_negative23() {
    putBatch = BatchActions.setDetailsToReadBatch(putBatch);
    requestSpecs = putBatch.buildRequest();
    response = requestSpecs.put(putBatch.getServiceUrl());
}
    @Then("Admin receives {int} Bad Request Status with message and boolean success details for UpdateBatchByBatchID2")
    public void admin_receives_bad_request_status_with_message_and_boolean_success_details_for_update_batch_by_batch_id2(Integer int1) {
        restUtil.extractRes(response);
        restUtil.validateStatusCode(response, int1);
        restUtil.validateStatusMessage(response, "OK");
    }

//    @DeleteBatchByBatchID-(Negative24)
    @When("Admin creates DELETE Request with valid BatchId\\(Negative24)")
    public void admin_creates_delete_request_with_valid_batch_id_negative24() {
        deleteBatch = BatchActions.setDetailsToReadBatch(deleteBatch);
        requestSpecs = deleteBatch.buildRequest();
        response = requestSpecs.delete(deleteBatch.getServiceUrl());
    }
    @Then("Admin receives {int} not found for DeleteBatchByBatchID")
    public void admin_receives_not_found_for_delete_batch_by_batch_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

//    @DeleteBatchByBatchID-(Negative26)
@When("Admin creates DELETE Request with valid BatchId\\(Negative26)")
public void admin_creates_delete_request_with_valid_batch_id_negative26() {
    deleteBatch = BatchActions.setDetailsToReadBatch(deleteBatch);
    requestSpecs = deleteBatch.buildRequest();
    response = requestSpecs.delete(deleteBatch.getServiceUrl());
}
    @Then("Admin receives {int} Unauthorized Status for DeleteBatchByBatchID")
    public void admin_receives_unauthorized_status_for_delete_batch_by_batch_id(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }
}