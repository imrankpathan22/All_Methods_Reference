package restAssuredReference;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
public class SoapReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// step1 declare base uri and request body var
		String BaseURI="https://www.dataaccess.com";
		String requestbody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>\r\n"
				+ "";
		//step 2 fetch req params
		XmlPath xmlrequest = new XmlPath(requestbody);
		String req_parm=xmlrequest.getString("ubiNum");
		System.out.println(req_parm);
		// step 3 configure the api and fetch the responsebody
		RestAssured.baseURI = BaseURI;
		String responseBody = given().header("Content-Type","text/xml; charset=utf-8").body(requestbody).when().post("/webservicesserver/NumberConversion.wso")
		.then().extract().response().getBody().asString();
		System.out.println(responseBody);
		// step 4 parse the responsebody and fetch the response parms
		XmlPath xml_res = new XmlPath(responseBody);
		String Result = xml_res.getString("NumberToWordsResult");
		System.out.println(Result);
		// step 5 validate response body parms
		Assert.assertEquals(Result, "one hundred ");
	}

}
