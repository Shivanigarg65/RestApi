package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import PayLoad.Payload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PutReq extends BaseTest {
	@Test(priority=4)
	public  void put() {

	
			Response res=httpRequest.headers(Payload.headerPa()).header("Cookie", "token="+tokenValue).log().all()
					.body(Payload.payloadd()).when().put("/booking/1");
					//.then().assertThat().statusCode(200).and().extract().response();
		
			res.prettyPeek();
			 JsonPath js=res.jsonPath();
				String name=js.get("booking.lastname");
				System.out.println(name);
				Assert.assertEquals("Brown", name);
}		
			
	
//negative scenario
@Test(priority=5)
public  void negput() {

	
		Response res=httpRequest.headers(Payload.headerPa()).header("Cookie","token="+tokenValue).log().all()
				.body(Payload.negpayloadd()).when().put("/booking/1");
				//.then().assertThat().statusCode(404).and().extract().response();
	
		res.prettyPeek();
		JsonPath js=res.jsonPath();
		String name=js.get("booking.lastname");
		System.out.println(name);
		Assert.assertEquals("Brown", name);
		
}
}

