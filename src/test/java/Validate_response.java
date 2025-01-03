import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Validate_response {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI ="https://rahulshettyacademy.com";

given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json")
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
		+ "").when().log().all().post("maps/api/place/add/json").then().log().all().assertThat()
.statusCode(200).body("scope", equalTo("APP")).log().all().header("Server", "Apache/2.4.52 (Ubuntu)"
		+ "");
//we are validating the response where scope = app coming or not ,
//and validating one header response let ex: Servername in header
//and equals to is a static method so need to import manually
//isequals to can imported from org.hamcrest.Matchers.*;	

//----------------------------------------------------------------------

//Now get value/id from response and store that in a variable 
//and use that id to add new place


//--->Add place > Update place with new Address > Get Place to validate if new address is present in response


	}

}
