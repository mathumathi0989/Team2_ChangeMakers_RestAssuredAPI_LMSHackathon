
package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;

public class BatchActions {

        private String loginServiceUrl = EnvConstants.endPoint_Login;
        private String getAllBatchesServiceUrl=EnvConstants.endPoint_GetAllBatches;
        private String getBatchByBatchIdServiceUrl = EnvConstants.endPoint_GetBatchByBatchID;
        private String getBatchByBatchNameServiceUrl = EnvConstants.endPoint_GetBatchByBatchName;
        private String getBatchByProgramIDServiceUrl = EnvConstants.endPoint_GetBatchByProgramID;
        private String postBatchServiceUrl=EnvConstants.endPoint_CreateBatch;
        private String updateBatchByBatchIDServiceUrl = EnvConstants.endPoint_UpdateBatchByBatchID;
        private String DeleteBatchByBatchIDServiceUrl=EnvConstants.endPoint_DeleteBatchByBatchID;
        private String file_Path_createBatch=EnvConstants.file_Path_CreateBatch;



        /* Set batchID value in environment variable to be used by batchController requests  */

        public void setBatchID(Response response)  {
            String batchID = (ApiUtils.extractFromResponse(response, "batchId"));
            System.out.println("batchID is "+batchID);
            System.out.println("Setting batchID in Env Variables");
            EnvVariables.batchID = batchID;
        }

        /* Set batchName value in environment variable to be used by batchController requests  */

        public void setBatchName(Response response){
            String batchName = ApiUtils.extractFromResponse(response, "batchName");
            System.out.println("batchName is "+batchName);
            System.out.println("Setting batchName in Env Variables");
            EnvVariables.batchName = batchName;
        }

        /*Get BatchId from envvariables */

        public String  getBatchID() {
           String btchID = EnvVariables.batchID;
            System.out.println("Reading btchID from env variables : "+btchID);
            return btchID;
        }

        /*Get BatchName from envvariables */

        public String getBatchName() {
            String btchName = EnvVariables.batchName;
            System.out.println("Reading btchName from env variables : "+btchName);
            return btchName;
        }

        public static BaseRequest validLogin(BaseRequest login) {
            login = RequestFactory.setAuthentication(login, "post",EnvConstants.userLoginId,EnvConstants.password, EnvConstants.qaEnvironmentbaseURI);
            login = RequestFactory.createRequest(login,EnvConstants.jsonContentType,EnvConstants.loginRequestBody,EnvConstants.endPoint_Login,0);
            return login;
        }

        public static BaseRequest setDetailsToReadBatch(BaseRequest getBatch) {
            getBatch = RequestFactory.setAuthentication(getBatch, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
            return RequestFactory.createRequest(getBatch,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllBatches,0);

        }

        public static BaseRequest setDetailsToCreateBatch(BaseRequest postBatch, String programType) {
            postBatch = RequestFactory.setAuthentication(postBatch, "post",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
            return RequestFactory.createRequest(postBatch,EnvConstants.jsonContentType,"",EnvConstants.endPoint_CreateBatch,0);
        }

        public static BaseRequest setDetailsToUpdateBatch(BaseRequest putBatch) {
            putBatch = RequestFactory.setAuthentication(putBatch, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
            return RequestFactory.createRequest(putBatch,EnvConstants.jsonContentType,"",EnvConstants.endPoint_UpdateBatchByBatchID,0);
        }

        public static BaseRequest setDetailsToDeleteBatch(BaseRequest deleteBatch) {
            deleteBatch = RequestFactory.setAuthentication(deleteBatch, "delete",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
            return RequestFactory.createRequest(deleteBatch,EnvConstants.jsonContentType,"",EnvConstants.endPoint_DeleteBatchByBatchID,0);

        }

    }
