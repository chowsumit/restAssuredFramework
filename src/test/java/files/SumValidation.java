package files;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class SumValidation {
	
	@Test
	public void sumValidation() {
		
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size");
		int sum = 0;
		
		for (int i=0; i<count; i++ ) {
			
			int price = js.getInt("courses["+i+"].price");
			int copies= js.getInt("courses["+i+"].copies");
			sum = sum + price*copies;
			
		}
		
		Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
		
	}
	
}
