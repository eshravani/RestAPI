package schemaValidator;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.*;
import org.testng.annotations.Test;


public class XmlSchemaValidator {

    @Test
    public void test1()
    {
        given()
                .when()
                .get("https://mocktarget.apigee.net/xml")
                .then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xml"));
    }
}
