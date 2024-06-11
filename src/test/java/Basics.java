import io.restassured.RestAssured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Basics {

	public static void main(String[] args) {
		
		
		//validate add api is working fine  
		

		// TODO Auto-generated method stub
//validate Add place api is working fine 
		//it follow given - all input details
		// when -submit the api
		//Then- validate the responseprinciple

		//for us base uri  is the initial uri ex: upto https://rahulshetty.com
RestAssured.baseURI= "https://rahulshettyacademy.com";
//given() -package can not import automatically because 
//it is static, so we need to add package manually  i.e static io.restassured.RestAssured.*
//same as restassured package but we need to add static keyword before it and .* in ending
//body should be in sting so put body inside double quote 
//validation we will write with then() method
given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json")
.body("{\r\n"
		+ "  \"location\": {\r\n"
		+ "    \"lat\": -38.383494,\r\n"
		+ "    \"lng\": 33.427362\r\n"
		+ "  },\r\n"
		+ "  \"accuracy\": 50,\r\n"
		+ "  \"name\": \"sids bangalore house\",\r\n"
		+ "  \"phone_number\": \"(+91) 983 093 3937\",\r\n"
		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
		+ "  \"types\": [\r\n"
		+ "    \"shoe park\",\r\n"
		+ "    \"shop\"\r\n"
		+ "  ],\r\n"
		+ "  \"website\": \"http://google.com\",\r\n"
		+ "  \"language\": \"French-IN\"\r\n"
		+ "}\r\n"
		+ " \r\n"
		+ "").when().log().all().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);

// now add default content type which we are sending in heading 

// velidate 

	}

}

