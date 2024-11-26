package generics;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

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
		System.out.println("Token is " + token);
		System.out.println("Setting token in Env Variables");
		EnvVariables.token = token;
	}

	/*==============================Code for validations============================================ */
	
	// Verify status code,statusLine and responseTime altogether
	public void validateStatusCode_statusLine_responseTime(Response response, int expectedStatusCode) {
		response.then().assertThat().statusCode(expectedStatusCode).and()
				.statusLine(getHttpStatusText(expectedStatusCode)).and().time(lessThan(700L), TimeUnit.MILLISECONDS);

	}
	// Verify status code
	public void validateStatusCode(Response response, int status_Code) {
		Assert.assertEquals(response.getStatusCode(), status_Code);

	}

	public void extractRes(Response response) {
		String res = response.getBody().asString();
		System.out.println(res);
	}

	// Verify status message
	public void validateStatusMessage(Response response, String status_Message) {
		int statusCode = response.getStatusCode();
		String statusText = getHttpStatusText(statusCode);
		System.out.println("Status Code: " + statusCode);
		System.out.println("Mapped Status Text: " + statusText);
		Assert.assertEquals(statusText, status_Message);

	}

	private String getHttpStatusText(int statusCode) {
		switch (statusCode) {
		case 200:return "OK";
		case 201:return "Created";
		case 204:return "No Content";
		case 400:return "Bad Request";
		case 401:return "Unauthorized";
		case 403:return "Forbidden";
		case 404:return "Not Found";
		case 405:return "Method Not Allowed";
		case 500:return "Internal Server Error";
		default:return "Unknown Status";
		}
	}

}
