package restAssuredReference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import static io.restassured.RestAssured.given;

import java.time.LocalDate;
public class postReference {

	public static void main(String[] args) {
		// step 1 Declare base url
		RestAssured.baseURI="https://reqres.in/";
		// step 2 configure req body with log all
		/*String responsebody = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").log().all().when().post("/api/users").then().log().all().extract().asString();*/
		
		// step2.1 without log all
		String responsebody = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").then().extract().response().asString();
				
				
		System.out.println(responsebody);
		// step 3 parse the response body
		JsonPath jp = new JsonPath(responsebody);
		String res_name = jp.getString("name");
		String res_job = jp.getString("job");
		String res_id = jp.getString("id");
		String res_createdAt = jp.getString("createdAt");
		
		//step 4 validate the response body parameter
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotNull(res_id,"assertion error,id parameter is not null");
		
		 
	    //extract data from createdAt parameter
	    String actual_date = res_createdAt.substring(0,10);
	    String current_date = LocalDate.now().toString(); 
	    Assert.assertEquals(actual_date,current_date);

	}}