package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;

public class UserLoginActions {

	public static BaseRequest validLogin(BaseRequest login) {
		login = RequestFactory.setAuthentication(login, "post", EnvConstants.userLoginId, EnvConstants.password,
				EnvConstants.qaEnvironmentbaseURI);
		login = RequestFactory.createRequest(login, EnvConstants.jsonContentType, EnvConstants.loginRequestBody,
				EnvConstants.endPoint_Login, 0);
		return login;
	}

	public static BaseRequest invalidLogin(BaseRequest invalidlogin) {
		invalidlogin = RequestFactory.setAuthentication(invalidlogin, "post", EnvConstants.userLoginwrongId,
				EnvConstants.Wrongpassword, EnvConstants.qaEnvironmentbaseURI);
		invalidlogin = RequestFactory.createRequest(invalidlogin, EnvConstants.jsonContentType,
				EnvConstants.loginRequestBodyWrong, EnvConstants.endPoint_invalidLogin, 0);
		return invalidlogin;

	}

	public static BaseRequest setDetailsToReadProgram(BaseRequest getProgram) {
		getProgram = RequestFactory.setAuthentication(getProgram, "get", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(getProgram, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllPrograms, 0);

	}

	public static BaseRequest setDetailsToCreateProgram(BaseRequest postProgram, String programType) {
		postProgram = RequestFactory.setAuthentication(postProgram, "post", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(postProgram, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllPrograms, 0);
	}

	public static BaseRequest setDetailsToUpdateProgram(BaseRequest putProgram) {
		putProgram = RequestFactory.setAuthentication(putProgram, "put", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(putProgram, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllPrograms, 0);
	}

	public static BaseRequest setDetailsToDeleteProgram(BaseRequest deleteProgram) {
		deleteProgram = RequestFactory.setAuthentication(deleteProgram, "delete", EnvVariables.token,
				EnvConstants.qaEnvironmentbaseURI);
		return RequestFactory.createRequest(deleteProgram, EnvConstants.jsonContentType, "",
				EnvConstants.endPoint_GetAllPrograms, 0);

	}

}
