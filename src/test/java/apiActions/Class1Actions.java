package apiActions;

import apiConfig.EnvConstants;


import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class Class1Actions {
	private String loginServiceUrl = EnvConstants.endPoint_Login;
	private String getclassRecordingBatchIDServiceUrl=EnvConstants.endPoint_GetClassRecordingsBatchID;
	//private String getclassRecordingsClassid2ServiceUrl = EnvConstants.endPoint_GetClassRecordingsClassID1;
	private String getProgramWithUsersServiceUrl = EnvConstants.endPoint_GetProgramWithUsers;
//	private String getUpcomingClassServiceUrl=EnvConstants.endPoint_GetUpcomingclasses;
	//private String getClassRecordingsClassidServiceUrl = EnvConstants.endPoint_GetClassRecordingsClassID;
	private String getAllRecordingsServiceUrl = EnvConstants.endPoint_GetAllRecordings;
	private String updateClassRecordingServiceUrl=EnvConstants.endPoint_UpdateclassRecording;
	private String updateClass=EnvConstants.endPoint_Updateclass;
	
	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post",EnvConstants.userLoginId,EnvConstants.password, EnvConstants.qaEnvironmentbaseURI);
    	login = RequestFactory.createRequest(login,EnvConstants.jsonContentType,EnvConstants.loginRequestBody,EnvConstants.endPoint_Login,0);
		return login;
		
	}
		
		public static BaseRequest setDetailsToReadClass1(BaseRequest getClass1AllClass) {
			getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllPrograms,0);
		
		
	}

		public static BaseRequest setDetailsToReadClass1GetAllclasswithInvalidEndpoint(BaseRequest getClass1AllClass) {
			getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"","invalid",0);
		}

}
