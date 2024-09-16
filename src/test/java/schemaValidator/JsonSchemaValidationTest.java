package schemaValidator;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidationTest {

    @Test
    public void test1()
    {
        given()
                .when()
                .get("http://localhost:3000/students/1")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

    }
}
