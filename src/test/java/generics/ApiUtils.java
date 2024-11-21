package generics;

import org.testng.Assert;
import apiConfig.EnvVariables;
import io.restassured.response.Response;

public class ApiUtils {

	/* Reusable code for extracting particular given string value from response */

	public static String extractFromResponse(Response response, String req) {
		String reqString = response.jsonPath().getString(req).trim();
		return reqString;
	}
	
	public static void setAuth(Response response) {
		String token = extractFromResponse(response, "token");
		System.out.println("Token is "+token);
		System.out.println("Setting token in Env Variables");
		EnvVariables.token = token;
	}

/*==============================Code for validations============================================*/
	
	// Verify status code
	public void validateStatusCode(Response response, int status_Code) {
		Assert.assertEquals(response.getStatusCode(), status_Code);

	}

}
