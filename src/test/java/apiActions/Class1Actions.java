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
		return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllclasses,0);
	}

	public static BaseRequest setDetailsToReadClass1GetAllclasswithInvalidEndpoint(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"","invalid",0);
	}


	public static BaseRequest setDetailsToReadClass1forGetwithInvalidMethod(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllclasses,0);	
	}

	public static BaseRequest setDetailsToReadClass1GetAllClassInvalidAuth(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllclasses,0);

	}

	public static BaseRequest setDetailsToReadClass1classDetailsByvalidClassTopic(BaseRequest getClass1AllClasseswithclasstopic) {
		getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClasseswithclasstopic,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassTopic,0);

	}

	public static BaseRequest setDetailsToReadClass1AllClassesByInvalidClasstopic(BaseRequest getClass1AllClasseswithclasstopic) {
		getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClasseswithclasstopic,EnvConstants.jsonContentType,"","classes/abcdef",0);	


	}

	public static BaseRequest setDetailsToReadClass1GetAllClassesWithInvalidEndpoint(BaseRequest getClass1AllClaseseWithInalidEndpoint) {
		
		getClass1AllClaseseWithInalidEndpoint = RequestFactory.setAuthentication(getClass1AllClaseseWithInalidEndpoint, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClaseseWithInalidEndpoint,EnvConstants.jsonContentType,"","class/sql",0);
	}

	public static BaseRequest setDetailsToReadClass1GetClassByClassWithInvalidMethod(BaseRequest getClass1AllClaseseWithInalidMethodEndpoint) {
		// TODO Auto-generated method stub
		//return null;
		getClass1AllClaseseWithInalidMethodEndpoint = RequestFactory.setAuthentication(getClass1AllClaseseWithInalidMethodEndpoint, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClaseseWithInalidMethodEndpoint,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassTopic,0);

	}

	public static BaseRequest setDetailsToReadClass1GetAllClasswithInvalidAuth(BaseRequest getClass1AllClassUnauthorized) {
		getClass1AllClassUnauthorized = RequestFactory.setAuthentication(getClass1AllClassUnauthorized, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClassUnauthorized,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassTopic,0);

	}
//get class details by class id
	public static BaseRequest setDetailsToReadClass1RecordingsByValidClassID(BaseRequest getClass1ClassdetailsWithValidClassID) {
		
		getClass1ClassdetailsWithValidClassID = RequestFactory.setAuthentication(getClass1ClassdetailsWithValidClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClassdetailsWithValidClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassId,0);

	}

	public static BaseRequest setDetailsToReadClass1allclassesByInvalidClassID(BaseRequest getClass1AllclassByInvalidClassid) {
		// TODO Auto-generated method stub
		//return null;
		getClass1AllclassByInvalidClassid = RequestFactory.setAuthentication(getClass1AllclassByInvalidClassid, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllclassByInvalidClassid,EnvConstants.jsonContentType,"","class/100001",0);
	}

	public static BaseRequest setDetailsToReadClass1ByClassIDforInvalidEndpoint(BaseRequest getClass1ClassDetailsByInvalidClassID) {
		// TODO Auto-generated method stub
		//return null;
		getClass1ClassDetailsByInvalidClassID = RequestFactory.setAuthentication(getClass1ClassDetailsByInvalidClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClassDetailsByInvalidClassID,EnvConstants.jsonContentType,"","class21/100001",0);
	}

	public static BaseRequest setDetailsToCreateClass1ClassdetailsByInvalidMethod(BaseRequest getClass1AllDetailsByInvalidMethod) {

		getClass1AllDetailsByInvalidMethod = RequestFactory.setAuthentication(getClass1AllDetailsByInvalidMethod, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllDetailsByInvalidMethod,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassId,0);	

	}

	public static BaseRequest setDetailsToReadClass1ForInvalidAuth(BaseRequest getClass1ClasDetailswithoutAuth) {

		getClass1ClasDetailswithoutAuth = RequestFactory.setAuthentication(getClass1ClasDetailswithoutAuth, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClasDetailswithoutAuth,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassDetailsClassTopic,0);

	}

	public static BaseRequest setDetailstoDeleteclass(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		//return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_DeleteClassDetailsByClassId,0);
	
		
		
	}

	public static BaseRequest setDetailstoDeleteclasswithinvalidendpoint(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		//return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass,EnvConstants.jsonContentType,"","class41/10001",0);
		
		
	}

	public static BaseRequest setDetailstoDeleteclasswithinvalidclassid(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		//return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass,EnvConstants.jsonContentType,"","class41/10001",0);
		
	}

	public static BaseRequest setDetailstoDeleteclasswithvalidclassidwithoutauth(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		//return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass,EnvConstants.jsonContentType,"",EnvConstants.endPoint_DeleteClassDetailsByClassId,0);
		
	}







}
