package userApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class AddQueryPath {
    @Test
    public void getUser()
    {
        //https://reqres.in/api/users?page=2
        given().pathParam("param1","users")
                .queryParam("page",2)
                .queryParam("id",2)
                .when().get("//https://reqres.in/api/{param1}")
                .then().statusCode(200).body("id",equalTo(2));
    }
}
