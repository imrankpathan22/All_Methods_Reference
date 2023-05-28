package restAssuredReference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class delete_reference {

	public static void main(String[] args) {
		//step 1 : Declare Base Url
		RestAssured.baseURI="https://reqres.in/";
		//step 2 : Configure Request body
		int statusCode=given().header("Content-Type","application/json").log().all().when().
				delete("/api/users/2").then().extract().statusCode();

	System.out.println(statusCode);
	}
}