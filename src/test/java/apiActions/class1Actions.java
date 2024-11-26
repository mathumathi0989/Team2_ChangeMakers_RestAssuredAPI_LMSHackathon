package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;

public class class1Actions {

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post", EnvConstants.userLoginId, EnvConstants.password,
				EnvConstants.qaEnvironmentbaseURI);
		login = RequestFactory.createRequest(login, EnvConstants.jsonContentType, EnvConstants.loginRequestBody,
				EnvConstants.endPoint_Login, 0);
		return login;
	}

	public static BaseRequest setDetailsToReadClass1(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllclasses, 0);
	}

	public static BaseRequest setDetailsToReadClass1GetAllclasswithInvalidEndpoint(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass, EnvConstants.jsonContentType, "", "invalid", 0);
	}

	public static BaseRequest setDetailsToReadClass1forGetwithInvalidMethod(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllclasses, 0);
	}

	public static BaseRequest setDetailsToReadClass1GetAllClassInvalidAuth(BaseRequest getClass1AllClass) {
		getClass1AllClass = RequestFactory.setAuthentication(getClass1AllClass, "get", "",
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClass, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllclasses, 0);

	}

	public static BaseRequest setDetailsToReadClass1classDetailsByvalidClassTopic(
			BaseRequest getClass1AllClasseswithclasstopic) {
		getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",
				EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClasseswithclasstopic, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetClassDetailsClassTopic(), 0);

	}

	public static BaseRequest setDetailsToReadClass1AllClassesByInvalidClasstopic(
			BaseRequest getClass1AllClasseswithclasstopic) {
		getClass1AllClasseswithclasstopic = RequestFactory.setAuthentication(getClass1AllClasseswithclasstopic, "get",
				EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClasseswithclasstopic, EnvConstants.jsonContentType, "",
				"classes/abcdef", 0);

	}

	public static BaseRequest setDetailsToReadClass1GetAllClassesWithInvalidEndpoint(
			BaseRequest getClass1AllClaseseWithInalidEndpoint) {

		getClass1AllClaseseWithInalidEndpoint = RequestFactory.setAuthentication(getClass1AllClaseseWithInalidEndpoint,
				"get", EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClaseseWithInalidEndpoint, EnvConstants.jsonContentType, "",
				"class/sql", 0);
	}

	public static BaseRequest setDetailsToReadClass1GetClassByClassWithInvalidMethod(
			BaseRequest getClass1AllClaseseWithInalidMethodEndpoint) {
		// TODO Auto-generated method stub
		// return null;
		getClass1AllClaseseWithInalidMethodEndpoint = RequestFactory.setAuthentication(
				getClass1AllClaseseWithInalidMethodEndpoint, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClaseseWithInalidMethodEndpoint, EnvConstants.jsonContentType,
				"", EnvConstants.endPoint_GetClassDetailsClassTopic(), 0);

	}

	public static BaseRequest setDetailsToReadClass1GetAllClasswithInvalidAuth(
			BaseRequest getClass1AllClassUnauthorized) {
		getClass1AllClassUnauthorized = RequestFactory.setAuthentication(getClass1AllClassUnauthorized, "get", "",
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllClassUnauthorized, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetClassDetailsClassTopic(), 0);

	}

//get class details by class id
	public static BaseRequest setDetailsToReadClass1RecordingsByValidClassID(
			BaseRequest getClass1ClassdetailsWithValidClassID) {

		getClass1ClassdetailsWithValidClassID = RequestFactory.setAuthentication(getClass1ClassdetailsWithValidClassID,
				"get", EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClassdetailsWithValidClassID, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetClassDetailsClassId(), 0);

	}

	public static BaseRequest setDetailsToReadClass1allclassesByInvalidClassID(
			BaseRequest getClass1AllclassByInvalidClassid) {
		// TODO Auto-generated method stub
		// return null;
		getClass1AllclassByInvalidClassid = RequestFactory.setAuthentication(getClass1AllclassByInvalidClassid, "get",
				EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllclassByInvalidClassid, EnvConstants.jsonContentType, "",
				"class/100001", 0);
	}

	public static BaseRequest setDetailsToReadClass1ByClassIDforInvalidEndpoint(
			BaseRequest getClass1ClassDetailsByInvalidClassID) {
		// TODO Auto-generated method stub
		// return null;
		getClass1ClassDetailsByInvalidClassID = RequestFactory.setAuthentication(getClass1ClassDetailsByInvalidClassID,
				"get", EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClassDetailsByInvalidClassID, EnvConstants.jsonContentType, "",
				"class21/100001", 0);
	}

	public static BaseRequest setDetailsToCreateClass1ClassdetailsByInvalidMethod(
			BaseRequest getClass1AllDetailsByInvalidMethod) {

		getClass1AllDetailsByInvalidMethod = RequestFactory.setAuthentication(getClass1AllDetailsByInvalidMethod, "get",
				EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1AllDetailsByInvalidMethod, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetClassDetailsClassId(), 0);

	}

	public static BaseRequest setDetailsToReadClass1ForInvalidAuth(BaseRequest getClass1ClasDetailswithoutAuth) {

		getClass1ClasDetailswithoutAuth = RequestFactory.setAuthentication(getClass1ClasDetailswithoutAuth, "get", "",
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1ClasDetailswithoutAuth, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetClassDetailsClassTopic(), 0);

	}

	public static BaseRequest setDetailstoDeleteclass(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		// return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_DeleteClassDetailsByClassId(), 0);

	}

	public static BaseRequest setDetailstoDeleteclasswithinvalidendpoint(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		// return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass, EnvConstants.jsonContentType, "", "class41/10001", 0);

	}

	public static BaseRequest setDetailstoDeleteclasswithinvalidclassid(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		// return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass, EnvConstants.jsonContentType, "", "class41/10001", 0);

	}

	public static BaseRequest setDetailstoDeleteclasswithvalidclassidwithoutauth(BaseRequest getClass1DeleteClass) {
		// TODO Auto-generated method stub
		// return null;
		getClass1DeleteClass = RequestFactory.setAuthentication(getClass1DeleteClass, "delete", "",
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass1DeleteClass, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_DeleteClassDetailsByClassId(), 0);

	}

	public static BaseRequest setDetailsToAddClass(BaseRequest addClass) {
		addClass = RequestFactory.setAuthentication(addClass, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("addClassAllDetails");
		return RequestFactory.createRequest(addClass, EnvConstants.jsonContentType, classDetails,
				EnvConstants.endPoint_addClass, 0);
	}

	public static BaseRequest setDetailsToAddClassMandatory(BaseRequest addClass) {
		addClass = RequestFactory.setAuthentication(addClass, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("addClassAllDetailsMandatory");
		return RequestFactory.createRequest(addClass, EnvConstants.jsonContentType, classDetails,
				EnvConstants.endPoint_addClass, 0);
	}

	public static BaseRequest setDetailsToAddClassOnlyAdditional(BaseRequest addClass) {
		addClass = RequestFactory.setAuthentication(addClass, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("addClassAllDetailsAdditional");
		return RequestFactory.createRequest(addClass, EnvConstants.jsonContentType, classDetails,
				EnvConstants.endPoint_addClass, 0);
	}

	public static void setClassID(Response response) {
		String csIdValue = ApiUtils.extractFromResponse(response, "csId");
		if (csIdValue != null) {
			int classID = Integer.parseInt(csIdValue);
			System.out.println("Setting classID in Env Variables: " + classID);
			EnvVariables.csId = classID;
		} else {
			System.out.println("csId is null in response!");
		}
	}

	public static void setClassTopic(Response response) {
		String csTopicValue = ApiUtils.extractFromResponse(response, "classTopic");
		if (csTopicValue != null) {
			System.out.println("Setting ClassTopic in Env Variables: " + csTopicValue);
			EnvVariables.classTopic = csTopicValue;
		} else {
			System.out.println("csTopic is null in response!");
		}
	}

	public static int getClassIDOne() {
		int clsID = EnvVariables.csId;
		System.out.println("Reading classIDOne from env variables : " + clsID);
		return clsID;
	}

	public static String getClassTopicOne() {
		String clsTopic = EnvVariables.classTopic;
		System.out.println("Reading classIDOne from env variables : " + clsTopic);
		return clsTopic;
	}

}