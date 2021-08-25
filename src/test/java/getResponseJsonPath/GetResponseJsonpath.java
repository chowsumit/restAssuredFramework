package getResponseJsonPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResponseJsonpath {

	@Test
	public void getWeatherDetails() {
		
		String url = "http://restapi.demoqa.com/utilities/weather/city";
		String inputCity = "Edmonton";
		
		RestAssured.baseURI=url;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resp = httpRequest.get("/"+inputCity);
		
		String responseBody = resp.getBody().asString();
		
		//System.out.println("The response body is : "+responseBody);
		
		JsonPath jsonPathEvaluator = resp.jsonPath();
		System.out.println();
		System.out.println("The city is : "+jsonPathEvaluator.get("City"));
		System.out.println("The Temperature is : "+jsonPathEvaluator.get("Temperature"));
		System.out.println("The Humidity is : "+jsonPathEvaluator.get("Humidity"));
		System.out.println("The WeatherDescription is : "+jsonPathEvaluator.get("WeatherDescription"));
		System.out.println("The WindSpeed is : "+jsonPathEvaluator.get("WindSpeed"));
		
		
	}
	
	
}
