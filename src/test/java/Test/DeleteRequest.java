package Test;

import org.testng.annotations.Test;

import BasePage.BaseTest;
import PayLoad.Payload;
import io.restassured.response.Response;

public class DeleteRequest extends BaseTest{

	@Test(priority=8)
	public  void delete() {
	
	Response res=httpRequest.headers(Payload.headerParam()).
			header("Cookie", "token="+tokenValue).log()
			.all().when().delete("/booking/1");
			
	res.prettyPeek();
	
}
}

	
