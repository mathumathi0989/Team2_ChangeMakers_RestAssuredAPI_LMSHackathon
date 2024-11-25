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


		public static BaseRequest setDetailsToReadClass1forGetwithInvalidEndpoint(BaseRequest getClass1AllClass) {
			getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
	    	return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);	
		}

		public static BaseRequest setDetailsToReadClass1GetAllClassInvalidAuth(BaseRequest getClass1AllClass) {
			getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get","",EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);
		
		}

		public static BaseRequest setDetailsToReadClass1classDetailsByvalidClassTopic(BaseRequest getClass1AllClasseswithclasstopic) {
			getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClasseswithclasstopic,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID,0);

		}

		public static BaseRequest setDetailsToReadClass1AllClassesByInvalidClasstopic(BaseRequest getClass1AllClasseswithclasstopic) {
			getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
	    	return RequestFactory.createRequest(getClass1AllClasseswithclasstopic,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);	
			
				
		}

		public static BaseRequest setDetailsToReadClass1GetAllClassesWithInvalidEndpoint(BaseRequest getClass1AllClaseseWithInalidEndpoint) {
			// TODO Auto-generated method stub
			//return null;
			getClass1AllClaseseWithInalidEndpoint = RequestFactory.setAuthentication(getClass1AllClaseseWithInalidEndpoint, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClaseseWithInalidEndpoint,EnvConstants.jsonContentType,"","invalid",0);
		}

		public static BaseRequest setDetailsToReadClass1GetAllClassesWithInvalidMethodEndpoint(BaseRequest getClass1AllClaseseWithInalidMethodEndpoint) {
			// TODO Auto-generated method stub
			//return null;
			getClass1AllClaseseWithInalidMethodEndpoint = RequestFactory.setAuthentication(getClass1AllClaseseWithInalidMethodEndpoint, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClaseseWithInalidMethodEndpoint,EnvConstants.jsonContentType,"","invalid",0);
	
		}

		public static BaseRequest setDetailsToReadClass1GetAllClasswithInvalidAuth(BaseRequest getClass1AllClassUnauthorized) {
			getClass1AllClassUnauthorized = RequestFactory.setAuthentication(getClass1AllClassUnauthorized, "get","",EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass1AllClassUnauthorized,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);
		
		}

	
		


}
