package postRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void getWeatherDetails() {
		
		String url = "http://restapi.demoqa.com/customer";
		
		RestAssured.baseURI=url;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		
		requestParams.put("First Name", "Sumit");
		requestParams.put("Last Name", "Chowdhury");
		requestParams.put("UserName", "chowsumit");
		requestParams.put("Password", "Password-1");
		requestParams.put("E-mail", "test@abc.com");
		
		httpRequest.body(requestParams.toJSONString());
		
		System.out.println("The Request body is : \n"+requestParams.toJSONString());
		
		//Response resp = httpRequest.post("/register");
		Response resp = httpRequest.post();
		
		String responseBody = resp.getBody().asString();
		System.out.println("The response body is : \n"+responseBody);
		
		System.out.println("The response code is : "+resp.getStatusCode());
		System.out.println("The response line is : "+resp.getStatusLine());
		
		
	}
	
	
}
