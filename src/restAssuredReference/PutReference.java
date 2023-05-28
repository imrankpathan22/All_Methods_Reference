package restAssuredReference;
import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;

	import static io.restassured.RestAssured.given;

	import java.time.LocalDate;

	import org.testng.Assert;
    import io.restassured.RestAssured;
		import io.restassured.path.json.JsonPath;
        import static io.restassured.RestAssured.given;
        import java.time.LocalDate;
        import org.testng.Assert;
        public class PutReference {
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				//Declare base URI
				RestAssured.baseURI="https://reqres.in/";
				
				//configure the request body and resource.
				String putresponsebody =given().header("Content-Type","application/json").body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}").when().put("/api/users/2").then().extract().response().asString();
				System.out.println(putresponsebody);
				//create json path object to extract response body parameters
						JsonPath jsp=new JsonPath(putresponsebody);
						
						//extract response body parameters
						String res_name =jsp.getString("name");
					    String res_job  =jsp.getString("job");
					    String res_date=jsp.getString("updatedAt");
					    String Date=new String(res_date);
					    String result=new String(Date);
					    
						System.out.println(res_name);
						System.out.println(res_job);
						System.out.println(res_date);
						System.out.println(Date.substring(0,10));
						System.out.println(result.substring(0,10));
						//validate response body parameters
						
						Assert.assertEquals(res_name,"morpheus");
						Assert.assertEquals(res_job,"zion resident");
						Assert.assertEquals(Date,result);
						

			}

		}