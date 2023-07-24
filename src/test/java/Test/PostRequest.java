package Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import PayLoad.Payload;

public class PostRequest extends BaseTest {
 
	
	@Test(priority=3)
	public static void create() {

		
		Response res=httpRequest.headers(Payload.headerParam())
				.body(Payload.pay()).when().post("/booking");
				//.then().assertThat().statusCode(200).and().extract().response();
		res.prettyPeek();
		
		JsonPath js=res.jsonPath();
		String name=js.get("booking.firstname");
		System.out.println(name);
		
		int id=js.getInt("bookingid");
		System.out.println(id);
		
	Assert.assertEquals("Jim", name);
	
	}
	
}


