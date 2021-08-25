package udemyRestAssured;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJasonParse {
	
	public static void main(String args[]) {
		
		JsonPath js = new JsonPath(Payload.coursePrice());
		
		int courseCount = js.getInt("courses.size");
		
		System.out.println("The number of courses is : "+courseCount);
		
		
		System.out.println("The purchase amount is : "+js.getInt("dashboard.purchaseAmount"));
		//System.out.println(js.get("dashboard.website"));
		System.out.println("The title of the first course is : "+js.get("courses[0].title"));
		int firstCoursePrice = js.getInt("courses[0].price");
		int firstCourseCopy = js.getInt("courses[0].copies");
		//System.out.println(js.get("courses[1].title"));
		int secondCoursePrice =js.getInt("courses[1].price");
		int secondCourseCopy =js.getInt("courses[1].copies");
		//System.out.println(js.get("courses[2].title"));
		int thirdCoursePrice = js.getInt("courses[2].price");
		int thirdCourseCopy = js.getInt("courses[2].copies");
		
		int sumAllCoursePrice = firstCoursePrice*firstCourseCopy+secondCoursePrice*secondCourseCopy+thirdCoursePrice*thirdCourseCopy;
		
		System.out.println("Total of all course prices : "+sumAllCoursePrice);
		
		if (sumAllCoursePrice==js.getInt("dashboard.purchaseAmount")) {
			
			System.out.println("The course amount is successfully validated.");
			
		}else {
			
			System.out.println("The course amount is not validated.");
			
		}
		
		for (int i=0; i<courseCount; i++) {
			
			System.out.println("The price for the course "+js.get("courses["+i+"].title")+" is "+js.get("courses["+i+"].price")+" and sold "+js.get("courses["+i+"].copies")+ " copies.");
			
			if (js.get("courses["+i+"].title").toString().equalsIgnoreCase("RPA")) {
				System.out.println();
				System.out.println("The number of copies are "+js.get("courses["+i+"].copies")+".");
				break;
			}
			
		}
	}
	
	
}
