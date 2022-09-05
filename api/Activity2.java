	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
 
import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
	
   final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
	
  @Test(priority = 1)
  public void postRequest() throws Exception {
	  FileInputStream file = new FileInputStream("C:\\Users\\0022U6744\\IBM FST Projects\\Module 2\\RestAssured\\Data.json");
	  String reqBody = new String(file.readAllBytes());
	  
	  Response response = given().contentType(ContentType.JSON)
			  .body(reqBody)
			  .when().post(ROOT_URI);
	  file.close();
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("20817"));
  }
  
  @Test(priority = 2)
  public void getRequest() {
	  File file = new File("C:\\Users\\0022U6744\\IBM FST Projects\\Module 2\\RestAssured\\Data1.json");
	  
	  Response response = given().contentType(ContentType.JSON)
			  .pathParam("username", "Ankush")
			  .when().get(ROOT_URI + "/{username}");
	  
	  String resBody = response.getBody().asPrettyString();
	  
	  try {
          file.createNewFile();
          FileWriter writer = new FileWriter(file.getPath());
          writer.write(resBody);
          writer.close();
      } catch (IOException excp) {
          excp.printStackTrace();
      }
	  
	  response.then().body("id", equalTo(20817));
      response.then().body("username", equalTo("Ankush"));
      response.then().body("firstName", equalTo("Ankush"));
      response.then().body("lastName", equalTo("Case"));
      response.then().body("email", equalTo("ankushcase@mail.com"));
      response.then().body("password", equalTo("password123"));
      response.then().body("phone", equalTo("9812763450"));
	  
  }
  
  @Test(priority = 3)
  public void deleteRequest() {
	  
	  Response response = given().contentType(ContentType.JSON)
			  .pathParam("username", "Ankush")
			  .when().delete(ROOT_URI + "/{username}");
	  
	  response.then().body("code", equalTo(200));
      response.then().body("message", equalTo("Ankush"));
  }
}
