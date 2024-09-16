package parsingJsonResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingJsonResponse {

    @Test
    public void getCourseName()
    {
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/students");
        JSONArray ja = new JSONArray(res.asString());
       String course0= ja.getJSONObject(0).getJSONArray("courses").get(0).toString();
       System.out.println(course0);

    }
}
