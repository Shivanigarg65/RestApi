package Test;

import org.testng.annotations.Test;

import BasePage.BaseTest;
import io.restassured.response.Response;

public class GetRequest extends BaseTest{

	
	
	@Test(priority=1)
	 public static void getbooking() {

		
		Response res=httpRequest.log().all().when().get("/booking");
				//.then().assertThat().statusCode(200).and().extract().response();
		
		res.prettyPeek();
		
	}
	
	@Test(priority=2)
	 public static void getbookingid() {
	
			Response res=httpRequest.when().get("/booking/1");
					//.then().assertThat().statusCode(200).and().extract().response();			
			res.prettyPeek();
		}

}
