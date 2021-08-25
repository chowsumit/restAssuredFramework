package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequestWeather {

	@Test
	public void getWeatherDetails() {
		
		String url = "http://restapi.demoqa.com/utilities/weather/city";
		String inputCity = "Edmonton";
		
		RestAssured.baseURI=url;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resp = httpRequest.get("/"+inputCity);
		
		String responseBody = resp.getBody().asString();
		
		System.out.println("The response body is : "+responseBody);
		
		int code = resp.getStatusCode();
		
		String statusLine = resp.getStatusLine();
		System.out.println();
		System.out.println("The response status code is : "+code);
		System.out.println();
		System.out.println("The status line is : "+statusLine);
		System.out.println();
		/*
		 First part is Http protocol (HTTP/1.1). 
		 Second is Status Code (200). 
		 Third is the Status message (OK)
		 */
		System.out.println("The response header parameters are : ");
		Headers allHeaders = resp.getHeaders();
		
		for(Header i : allHeaders) {
			
			System.out.println("Key : "+i.getName()+" , Value : "+i.getValue());;
			
			
		} 
		
	}
	
	
}
