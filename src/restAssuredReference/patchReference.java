package restAssuredReference;




		// TODO Auto-generated method stub
		import io.restassured.RestAssured;
		import io.restassured.path.json.JsonPath;

		import static io.restassured.RestAssured.given;

		import java.time.LocalDate;

		import org.testng.Assert;

		public class patchReference {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				//Declare baseURI
				RestAssured.baseURI="https://reqres.in/";
				
				//configure request body and resource
				String patchresponsebody =given().header("Content-Type","application/json").body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}").when().patch("/api/users/2").then().extract().response().asString();
				System.out.println(patchresponsebody);
				//create json path object to extract response body parameters
				JsonPath jsp=new JsonPath(patchresponsebody);
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
	


