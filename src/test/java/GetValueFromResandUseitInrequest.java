import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.equalTo;
import files.payload;

public class GetValueFromResandUseitInrequest {
	public static void main(String[] args) {
RestAssured.baseURI="https://rahulshettyacademy.com";
String response=given().log().all().queryParam("key", "qaclick123")
.header("Content-Type", "application/json").body(payload.Addplace())
.when().log().all().post("maps/api/place/add/json").then().assertThat()
.statusCode(200).body("scope", equalTo("APP")).log().all()
.header("Server", "Apache/2.4.52 (Ubuntu)"
		+ "").extract().response().asString();
//We get response in string format , so to capture the response use 
//Extract method and save that in a variable

System.out.println(response);
JsonPath js = new JsonPath(response);
String placeid=js.getString("place_id"); //pass the key to get value
System.out.println("place id is: "+placeid);


//JSONpath class is the one which takes string as an input
//and convert that into JSON format
//in js - it will store as key value pair,where both are string value, so we can get key using getString() method


//UPDATE PLAECE

given().queryParams("key", "qaclick123").header("Content-Type", "application/json")
.body("{\r\n"
		+ "\"place_id\":\""+placeid+"\",\r\n"
		+ "\"address\":\"70 Summer walk, USA\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).log().all()
.body("msg", equalTo("Address successfully updated"));


//verify after updating the place id , place name is still same as before
String expected_address="70 Summer walk, USA";
//get the place 

//get place name using get method after updating place id and extract it and verify
//we don't give header usally while doing get method
// in postman you can see for get method there is one more query param called place_id,
//for place id value you can put which you got earlier
//for get method put the get api path inside get method
String getplaceResponse= given().queryParam("key", "qaclick123").queryParam("place_id", placeid).log().all().when().get("maps/api/place/get/json")
.then().log().all().statusCode(200).extract().response().asString(); 	


JsonPath js1 =new JsonPath(getplaceResponse);
String actualAddress=js1.get("address");//address is parameter from get response 
if(actualAddress.equals(expected_address))
{
	System.out.println("address updated");
}
System.out.println(actualAddress);

	}
}
