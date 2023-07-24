package BasePage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PayLoad.Payload;
import Utilites.ExtentManager;
import Utilites.PropReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest  {
	 protected static PropReader readingPropertiesFile = new PropReader();
	    protected static RequestSpecification httpRequest;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    public static Logger logger = null;
	    protected String tokenValue;
	
	    
	  
	    
	    @BeforeSuite
	    public static void init() throws MalformedURLException{
	       extent = ExtentManager.getInstance("Reports//ExtentReport.html");
	    }
	    
	    @BeforeClass
		public void tokengenerate() {
			RestAssured.baseURI="https://restful-booker.herokuapp.com";
			RequestSpecification httpreq= RestAssured.given().headers(Payload.headerParam()).log().all();
			Response res=httpreq.body(Payload.token())
					.when().post("/auth").then().assertThat().statusCode(200).and().extract().response();	
		res.prettyPeek();
		JsonPath js = res.jsonPath(); 
	    tokenValue = js.getString("token");
//		System.out.print(token);
		
		//tokenMap.put("token", tokenValue);

		}

		@BeforeMethod
		public void basic_Details() {

			RestAssured.baseURI = PropReader.getProperty("baseurl");

			httpRequest = RestAssured.given();

		}

		
		

	    @BeforeMethod
	    public void startTest(Method method) {
	        String log4jPath = System.getProperty("user.dir")+ "\\log4j.properties";
	        
	        httpRequest = RestAssured.given();
	        test = extent.startTest(method.getName());
	    }


	    @AfterMethod
	    public void afterMethod(ITestResult result) throws IOException {

	        System.out.println(result.getMethod().getMethodName());

	            if(result.getStatus()==ITestResult.SUCCESS)
	                test.log(LogStatus.PASS, "Test case passed");
	            else if(result.getStatus()==ITestResult.FAILURE) {
	                test.log(LogStatus.FAIL, result.getThrowable());
	            }

	            else if(result.getStatus()==ITestResult.SKIP)
	                test.log(LogStatus.SKIP, result.getThrowable());

	            extent.flush();

	        }
	
}

