package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserloginAction {
	
	private String loginServiceUrl = EnvConstants.endPoint_Login;
	private String getAllProgramsServiceUrl=EnvConstants.endPoint_GetAllPrograms;
	private String getProgramByIdServiceUrl = EnvConstants.endPoint_GetProgramByID;
	private String getProgramWithUsersServiceUrl = EnvConstants.endPoint_GetProgramWithUsers;
	private String postProgramServiceUrl=EnvConstants.endPoint_CreateProgram;
	private String updateProgramByNameServiceUrl = EnvConstants.endPoint_UpdateProgramByProgName;
	private String updateProgramByIdServiceUrl = EnvConstants.endPoint_UpdateProgramByProgId;
	private String deleteByIdServiceUrl=EnvConstants.endPoint_DeleteProgramById;
	private String file_Path_createProgram=EnvConstants.file_Path_CreateProgram;
	
	
	
	private String userlogin=EnvConstants.TestDatajsonPath;
	
	
	
	

/* Set ProgramID value in environment variable to be used by programController requests  */
	
	public void setProgramID(Response response)  {
		int programID = Integer.parseInt(ApiUtils.extractFromResponse(response, "programId"));
		System.out.println("programID is "+programID);
		System.out.println("Setting programID in Env Variables");
		EnvVariables.programID = programID;
	}
	
	/* Set ProgramName value in environment variable to be used by programController requests  */
	
	public void setProgramName(Response response){
		String programNAME = ApiUtils.extractFromResponse(response, "programName");
		System.out.println("programName is "+programNAME);
		System.out.println("Setting programName in Env Variables");
		EnvVariables.programName = programNAME;
	}
	
	/*Get ProgramId from envvariables */
	
	public int getProgramID() {
		int prgmID = EnvVariables.programID;
		System.out.println("Reading prgmID from env variables : "+prgmID);
		return prgmID;
	}
	
	/*Get ProgramName from envvariables */
	
	public String getProgramName() {
		String prgmName = EnvVariables.programName;
		System.out.println("Reading prgmName from env variables : "+prgmName);
		return prgmName;
	}
	
	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post",EnvConstants.userLoginId,EnvConstants.password, EnvConstants.qaEnvironmentbaseURI);
    	login = RequestFactory.createRequest(login,EnvConstants.jsonContentType,EnvConstants.loginRequestBody,EnvConstants.endPoint_Login,0);
		return login;
	}
	
	
	
	public static BaseRequest invalidLogin (BaseRequest invalidlogin) {
		invalidlogin =RequestFactory.setAuthentication(invalidlogin, "post", EnvConstants.userLoginwrongId,EnvConstants.Wrongpassword, EnvConstants.qaEnvironmentbaseURI);
		invalidlogin = RequestFactory.createRequest(invalidlogin,EnvConstants.jsonContentType,EnvConstants.loginRequestBodyWrong,EnvConstants.endPoint_invalidLogin,0);
		return invalidlogin;
		
	}
	
	public static BaseRequest setDetailsToReadProgram(BaseRequest getProgram) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get",EnvVariables.token,EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getProgram,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllPrograms,0);
		
	}
	
	public static BaseRequest setDetailsToCreateProgram(BaseRequest postProgram, String programType) {
		postProgram = RequestFactory.setAuthentication(postProgram, "post",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
    	return RequestFactory.createRequest(postProgram,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllPrograms,0);	
	}
	
	public static BaseRequest setDetailsToUpdateProgram(BaseRequest putProgram) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(putProgram,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllPrograms,0);		
	}
	
	public static BaseRequest setDetailsToDeleteProgram(BaseRequest deleteProgram) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete",EnvVariables.token, EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(deleteProgram,EnvConstants.jsonContentType,"",EnvConstants.endPoint_GetAllPrograms,0);		
		
	}
	
}
