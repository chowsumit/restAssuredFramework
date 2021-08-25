package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getData {
	
		
	@Test(priority=0)
	public void testResponse() {
	//public static void main(String[] args) {
		
	
		//String url =  "https://www.google.com";
		String url = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		
		Response resp = RestAssured.get(url);
		
		int code =resp.getStatusCode();
		
		System.out.println(resp.getBody().asString());
		System.out.println(code);
		
		//System.out.println("Hello");
		
	}	

}
