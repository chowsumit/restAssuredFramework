package getrequestqueryparameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterRequest {

	@Test
	public void queryParameter() {
		
		String url = "https://samples.openweathermap.org/data/2.5/";
		RestAssured.baseURI=url;
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.queryParam("q", "London,UK").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").get("/weather");
		
		String responseBody = response.asString();
		
		
		
		
		System.out.println("The respose body is : \n"+responseBody);
		
		System.out.println("The status code is : \n"+response.getStatusCode());
		System.out.println("The status line is : \n"+response.getStatusLine());
		
		
	}

}
