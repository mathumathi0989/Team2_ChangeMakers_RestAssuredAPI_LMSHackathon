package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class class2Actions {


	private String loginServiceUrl = EnvConstants.endPoint_Login;
	private String getclassRecordingBatchIDServiceUrl=EnvConstants.endPoint_GetClassRecordingsBatchID;
	private String getclassRecordingsClassid2ServiceUrl = EnvConstants.endPoint_GetClassRecordingsClassID2;
	private String getProgramWithUsersServiceUrl = EnvConstants.endPoint_GetProgramWithUsers;
	private String getUpcomingClassServiceUrl=EnvConstants.endPoint_GetUpcomingclasses;
	private String getClassRecordingsClassidServiceUrl = EnvConstants.endPoint_GetClassRecordingsClassID;
	private String getAllRecordingsServiceUrl = EnvConstants.endPoint_GetAllRecordings;
	private String updateClassRecordingServiceUrl=EnvConstants.endPoint_UpdateclassRecording;
	private String updateClass=EnvConstants.endPoint_Updateclass;

	

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post",EnvConstants.userLoginId,EnvConstants.password, EnvConstants.qaEnvironmentbaseURI);
    	login = RequestFactory.createRequest(login,EnvConstants.jsonContentType,EnvConstants.loginRequestBody,EnvConstants.endPoint_Login,0);
		return login;
	}

	   //GetAllRecordings step definition
	
	public static BaseRequest setDetailsToReadClass2GetAllRecordings(BaseRequest getClass2AllRecordings) {
		getClass2AllRecordings = RequestFactory.setAuthentication(getClass2AllRecordings, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2AllRecordings,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);
	}
	
	public static BaseRequest setDetailsToReadClass2GetAllRecordingsInvalidEndpoint(BaseRequest getClass2AllRecordings) {
		getClass2AllRecordings = RequestFactory.setAuthentication(getClass2AllRecordings, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2AllRecordings,EnvConstants.jsonContentType,"","invalid",0);
	}
	
	
	public static BaseRequest setDetailsToCreateClass2forGet(BaseRequest getClass2AllRecordings) {
		getClass2AllRecordings = RequestFactory.setAuthentication(getClass2AllRecordings, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
    	return RequestFactory.createRequest(getClass2AllRecordings,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);	
	}
		
	public static BaseRequest setDetailsToReadClass2GetAllRecordingsInvalidAuth(BaseRequest getClass2AllRecordings) {
		getClass2AllRecordings = RequestFactory.setAuthentication(getClass2AllRecordings, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2AllRecordings,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllRecordings,0);
	}
	
	  //GetClassRecordingsbyBatchId step definition
	
	public static BaseRequest setDetailsToReadClass2RecordingsByBatchIDValid(BaseRequest getClass2RecordingsBatchID) {
		getClass2RecordingsBatchID = RequestFactory.setAuthentication(getClass2RecordingsBatchID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsBatchID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsBatchID,0);
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByBatchIDInvalidBatchID(BaseRequest getClass2RecordingsBatchID) {
		getClass2RecordingsBatchID = RequestFactory.setAuthentication(getClass2RecordingsBatchID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsBatchID,EnvConstants.jsonContentType,"","batchRecordings/100001",0);
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByBatchIDInvalidEndpoint(BaseRequest getClass2RecordingsBatchID) {
		getClass2RecordingsBatchID = RequestFactory.setAuthentication(getClass2RecordingsBatchID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsBatchID,EnvConstants.jsonContentType,"","batchRecordings/invalid",0);
	}
	
	public static BaseRequest setDetailsToCreateClass2RecordingsByBatchIDforGet(BaseRequest getClass2RecordingsBatchID) {
		getClass2RecordingsBatchID = RequestFactory.setAuthentication(getClass2RecordingsBatchID, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
    	return RequestFactory.createRequest(getClass2RecordingsBatchID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsBatchID,0);	
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByBatchIDInvalidAuth(BaseRequest getClass2RecordingsBatchID) {
		getClass2RecordingsBatchID = RequestFactory.setAuthentication(getClass2RecordingsBatchID, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsBatchID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsBatchID,0);
	}
	
	 //GetClassRecordingsbyClassID step definition
	
	public static BaseRequest setDetailsToReadClass2RecordingsByClassIDValid(BaseRequest getClass2RecordingsClassID) {
		getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID,0);
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByClassIDInvalidBatchID(BaseRequest getClass2RecordingsClassID) {
		getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"","classRecordings/100001",0);
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByClassIDInvalidEndpoint(BaseRequest getClass2RecordingsClassID) {
		getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"","classRecordings/invalid",0);
	}
	
	public static BaseRequest setDetailsToCreateClass2RecordingsByClassIDforGet(BaseRequest getClass2RecordingsClassID) {
		getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
    	return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID,0);	
	}
	
	public static BaseRequest setDetailsToReadClass2RecordingsByClassIDInvalidAuth(BaseRequest getClass2RecordingsClassID) {
		getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get","",EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID,0);
	}
	
	 //GetClassRecordingsbyClassID2 step definition
	
		public static BaseRequest setDetailsToReadClass2RecordingsByClassID2Valid(BaseRequest getClass2RecordingsClassID) {
			getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID2,0);
		}
		
		public static BaseRequest setDetailsToReadClass2RecordingsByClassID2InvalidBatchID(BaseRequest getClass2RecordingsClassID) {
			getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"","download/100001",0);
		}
		
		public static BaseRequest setDetailsToReadClass2RecordingsByClassID2InvalidEndpoint(BaseRequest getClass2RecordingsClassID) {
			getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"","download/invalid",0);
		}
		
		public static BaseRequest setDetailsToCreateClass2RecordingsByClassID2forGet(BaseRequest getClass2RecordingsClassID) {
			getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
	    	return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID2,0);	
		}
		
		public static BaseRequest setDetailsToReadClass2RecordingsByClassID2InvalidAuth(BaseRequest getClass2RecordingsClassID) {
			getClass2RecordingsClassID = RequestFactory.setAuthentication(getClass2RecordingsClassID, "get","",EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2RecordingsClassID,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetClassRecordingsClassID2,0);
		}
		
		
		
		 //GetUpcomingClasses step definition
		
		public static BaseRequest setDetailsToReadClass2UpcomingClassesValid(BaseRequest getClass2UpcomingClasses) {
			getClass2UpcomingClasses = RequestFactory.setAuthentication(getClass2UpcomingClasses, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2UpcomingClasses,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetUpcomingclasses,0);
		}
		
		public static BaseRequest setDetailsToReadClass2UpcomingClassesInvalidStudentID(BaseRequest getClass2UpcomingClasses) {
			getClass2UpcomingClasses = RequestFactory.setAuthentication(getClass2UpcomingClasses, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2UpcomingClasses,EnvConstants.jsonContentType,"","upcomingClasses/U1000001",0);
		}
		
		public static BaseRequest setDetailsToReadClass2UpcomingClassesInvalidEndpoint(BaseRequest getClass2UpcomingClasses) {
			getClass2UpcomingClasses = RequestFactory.setAuthentication(getClass2UpcomingClasses, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2UpcomingClasses,EnvConstants.jsonContentType,"","upcomingClass/invalid",0);
		}
		
		public static BaseRequest setDetailsToCreateClass2UpcomingClassesforGet(BaseRequest getClass2UpcomingClasses) {
			getClass2UpcomingClasses = RequestFactory.setAuthentication(getClass2UpcomingClasses, "get",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
	    	return RequestFactory.createRequest(getClass2UpcomingClasses,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetUpcomingclasses,0);	
		}
		
		public static BaseRequest setDetailsToReadClass2UpcomingClassesInvalidAuth(BaseRequest getClass2UpcomingClasses) {
			getClass2UpcomingClasses = RequestFactory.setAuthentication(getClass2UpcomingClasses, "get","",EnvConstants.qaEnvironmentbaseURI);
			return RequestFactory.createRequest(getClass2UpcomingClasses,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetUpcomingclasses,0);
		}
		
		
		
		//Update class StepDefinition
		
		public static BaseRequest setDetailsToUpdateClass(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassDetails");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,EnvConstants.endPoint_Updateclass,0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassWithoutAuth(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put","", EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassDetails");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,EnvConstants.endPoint_Updateclass,0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassMandatoryValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassMandatoryValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,EnvConstants.endPoint_Updateclass,0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassMandatoryInValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassMandatoryValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,"updateClass/100001",0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassMissingMandatoryValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassMissingMandatoryValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,EnvConstants.endPoint_Updateclass,0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassInvalidDataValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassInvalidDataValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,EnvConstants.endPoint_Updateclass,0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassInvalidEndpointValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassMandatoryValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,"updateClasses/invalid",0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassDeletedBatchIDValidClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassDeletedBatchIDValidClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,"updateClass/105",0);	
		}
		
		public static BaseRequest setDetailsToUpdateClassDeletedClassID(BaseRequest putClass) {
			putClass = RequestFactory.setAuthentication(putClass, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("updateClassDeletedClassID");
	    	return RequestFactory.createRequest(putClass,EnvConstants.jsonContentType,classDetails,"updateClass/106",0);	
		}

	

		
		
		

	
	
	
	
}
