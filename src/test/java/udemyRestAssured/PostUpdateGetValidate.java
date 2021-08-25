package udemyRestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import files.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostUpdateGetValidate {
	
	//Add place -> Update place with new address -> Get place to validate if new address is present in response
	
	//give - all the input parameters
	//when - submit the api
	//then - validate the response
	
	
	
	@Test
	public void basics(){
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(Payload.addplace()).when().post("/maps/api/place/add/json").then()
	.assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)")
	.extract().response().asString();
	
	System.out.println("\n The response is : \n"+response);
	
	JsonPath js = new JsonPath(response);  // for parsing through json
	
	String placeId = js.getString("place_id");  //parsing through jasonpath
	
	System.out.println("The place id is : "+placeId);
	
	//Update place
	
	String newAddress = "23/C Canal North Road, India";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n" + 
			"\"place_id\":\""+placeId+"\",\r\n" + 
			"\"address\":\""+newAddress+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}\r\n" + 
			"").when().put("/maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	// Get place
	
	String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
	.when().get("/maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js1 = ReusableMethods.rawToJason(getPlaceResponse); 
	
	String getActualAddress = js1.getString("address");
	
	System.out.println("Getting the actual address : "+getActualAddress);
	
	Assert.assertEquals(newAddress, getActualAddress);
	
	
	
	
	}

}
