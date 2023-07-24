package Test;

import org.testng.annotations.BeforeTest;

import PayLoad.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthRequest {
String tokenValue;
	
	@BeforeTest
	public void tokengenerate() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification httpreq= RestAssured.given().headers(Payload.headerParam()).log().all();
		Response res=httpreq.body(Payload.token())
				.when().post("/auth");
				//.then().assertThat().statusCode(200).and().extract().response();	
	res.prettyPeek();
	JsonPath js = res.jsonPath(); 
    tokenValue = js.getString("token");
//	System.out.print(token);
	
	//tokenMap.put("token", tokenValue);

	}
}
