package PayLoad;

import java.util.HashMap;

public class Payload {
	public static HashMap<String, String> headers = new HashMap();// hash map declare for header
	
	public static HashMap<String, String> headerParam() {

		// header parameters
		headers.put("Content-Type", "application/json");

     return headers;
	}
	
	public static HashMap<String, String> headerPa(){
		headers.put("Content-Type", "application/json");
		headers.put("Accept","application/json");
		
		return headers;
	}
	
	
	public static String token() {
		return ("{\r\n" + 
				"    \"username\": \"admin\",\r\n" + 
				"    \"password\": \"password123\"\r\n" + 
				"}");
	}

	public static String pay() {
		
		return ("{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}");
		
	}
	
	public static String payl() {
		return("{\r\n" + 
						"    \"firstname\" : \"James\",\r\n" + 
						"    \"lastname\" : \"Brown\"\r\n" + 
						"}");
	}
	
	
	
	public static String negpayl() {
		return("{\r\n" + 
						"    \"firstname\" : \"Jameeffs\",\r\n" + 
						"    \"lastname\" : \"Brownnn\"\r\n" + 
						"}");
	}
	
	public static String payloadd() {
		return("{\r\n" + 
							"    \"firstname\" : \"James\",\r\n" + 
							"    \"lastname\" : \"Brown\",\r\n" + 
							"    \"totalprice\" : 111,\r\n" + 
							"    \"depositpaid\" : true,\r\n" + 
							"    \"bookingdates\" : {\r\n" + 
							"        \"checkin\" : \"2018-01-01\",\r\n" + 
							"        \"checkout\" : \"2019-01-01\"\r\n" + 
							"    },\r\n" + 
							"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
							"}");
	}
	
	
	public static String negpayloadd() {
		return("{\r\n" + 
							"    \"firstname\" : \"Jameeees\",\r\n" + 
							"    \"lastname\" : \"Brownnnnn\",\r\n" + 
							"    \"totalprice\" : 111,\r\n" + 
							"    \"depositpaid\" : trueee,\r\n" + 
							"    \"bookingdates\" : {\r\n" + 
							"        \"checkin\" : \"2018-01-01\",\r\n" + 
							"        \"checkout\" : \"2019-01-01\"\r\n" + 
							"    },\r\n" + 
							"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
							"}");
	}
}
