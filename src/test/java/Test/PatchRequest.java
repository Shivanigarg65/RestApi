package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import PayLoad.Payload;

public class PatchRequest extends BaseTest {

	@Test(priority=6)
	public   void patch() {
          
		
		Response res=httpRequest.headers(Payload.headerPa()).header("Cookie", "token="+tokenValue)
             .body(Payload.payl()).when().patch("/booking");
            // .then().assertThat().statusCode(200).and().extract().response();
				  res.prettyPeek();  
				  /*JsonPath js=res.jsonPath();
					String price=js.get("booking.totalprice");
					//System.out.println(name);
					Assert.assertEquals("111", price);*/
}
	
	
	//negative test
	@Test(priority=7)
	public   void negpatch() {
          
	
		Response res=httpRequest.headers(Payload.headerPa()).header("Cookie", "token="+tokenValue)
             .body(Payload.negpayl()).when().patch("/booking");
             //.then().assertThat().statusCode(200).and().extract().response();
				  res.prettyPeek(); 
				  JsonPath js=res.jsonPath();
					String price=js.get("booking.totalprice");
					//System.out.println(name);
					Assert.assertEquals("111", price);
				 
}
	
}
