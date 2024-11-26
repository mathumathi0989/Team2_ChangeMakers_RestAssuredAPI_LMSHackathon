
package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import generics.LoggerLoad;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;

public class BatchActions {

	/*
	 * Set batchID value in environment variable to be used by batchController
	 * requests
	 */

	public void setBatchIDOld(Response response) {
		String batchID = (ApiUtils.extractFromResponse(response, "batchId"));
		LoggerLoad.info("batchID is " + batchID);
		LoggerLoad.info("Setting batchID in Env Variables");
	}

	/*
	 * Set batchName value in environment variable to be used by batchController
	 * requests
	 */

	public void setBatchNameOld(Response response) {
		String batchName = ApiUtils.extractFromResponse(response, "batchName");
		LoggerLoad.info("batchName is " + batchName);
		LoggerLoad.info("Setting batchName in Env Variables");
		EnvVariables.batchName = batchName;
	}

	/* Get BatchName from envvariables */

	public String getBatchNameOlsd() {
		String btchName = EnvVariables.batchName;
		LoggerLoad.info("Reading btchName from env variables : " + btchName);
		return btchName;
	}

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post", EnvConstants.userLoginId, EnvConstants.password,
				EnvConstants.qaEnvironmentbaseURI);
		login = RequestFactory.createRequest(login, EnvConstants.jsonContentType, EnvConstants.loginRequestBody,
				EnvConstants.endPoint_Login, 0);
		return login;
	}

	public static BaseRequest setDetailsToReadBatch(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllBatches, 0);

	}

	public static BaseRequest setDetailsToReadBatchIDWithoutAuth(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", "", EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetBatchByBatchID(), 0);

	}

	public static BaseRequest setDetailsToReadBatchIDInvalidBatchID(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "", "batches/batchId/10000002", 0);

	}

	public static BaseRequest setDetailsToReadBatchIDInvalidEndpoint(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "", "invalid/batchId/8142", 0);

	}

	public static BaseRequest setDetailsToReadBatchWithoutAuth(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", "", EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllBatches, 0);

	}

	public static BaseRequest setDetailsToReadAllBatchInvalid(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "", "invalid", 0);

	}

	public static BaseRequest setDetailsToReadBatchID(BaseRequest getBatch) {
		getBatch = RequestFactory.setAuthentication(getBatch, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetBatchByBatchID(), 0);

	}

	public static BaseRequest setDetailsToCreateBatch(BaseRequest postBatch, String programType) {
		postBatch = RequestFactory.setAuthentication(postBatch, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(postBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_CreateBatch, 0);
	}

	public static BaseRequest setDetailsToUpdateBatch(BaseRequest putBatch) {
		putBatch = RequestFactory.setAuthentication(putBatch, "put", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(putBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_UpdateBatchByBatchID, 0);
	}

	public static BaseRequest setDetailsToDeleteBatch(BaseRequest deleteBatch) {
		deleteBatch = RequestFactory.setAuthentication(deleteBatch, "delete", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(deleteBatch, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_DeleteBatchByBatchID, 0);

	}

	public static BaseRequest setDetailsToAddBatch(BaseRequest addBatch) {
		addBatch = RequestFactory.setAuthentication(addBatch, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("createBatchDetailsValid");
		return RequestFactory.createRequest(addBatch, EnvConstants.jsonContentType, classDetails,
				EnvConstants.endPoint_CreateBatch, 0);
	}

	public static void setBatchID(Response response) {
		String batchIdValue = ApiUtils.extractFromResponse(response, "batchId");
		if (batchIdValue != null) {
			int batcID = Integer.parseInt(batchIdValue);
			LoggerLoad.info("Setting batchID in Env Variables: " + batcID);
			EnvVariables.batchID = batcID;
		} else {
			LoggerLoad.info("batchId is null in response!");
		}
	}

	public static void setBatchName(Response response) {
		String batchNameValue = ApiUtils.extractFromResponse(response, "batchName");
		if (batchNameValue != null) {
			LoggerLoad.info("Setting batchName in Env Variables: " + batchNameValue);
			EnvVariables.batchName = batchNameValue;
		} else {
			LoggerLoad.info("batchName is null in response!");
		}
	}

	public static int getBatchIDOne() {
		int batcID = EnvVariables.batchID;
		LoggerLoad.info("Reading classIDOne from env variables : " + batcID);
		return batcID;
	}

	public static String getBatchNameOne() {
		String batchNam = EnvVariables.batchName;
		LoggerLoad.info("Reading classIDOne from env variables : " + batchNam);
		return batchNam;
	}

}
