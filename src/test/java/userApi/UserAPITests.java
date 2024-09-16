package userApi;


import org.testng.annotations.Test;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class UserAPITests {
    int id;

    /*
    given() - for pre-requisites
    content type, add header, add authentication, add cookies, add query parameter, path parameter etc
    when()-for request type
    get, put,post,delete,patch
    then()-- for validation
    validate status code,extract response,extract headers, cookies & response body..etc
    */


    @Test(priority = 1)
    public void getUsers() {
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().log().all().statusCode(200).body("page", equalTo(2));

    }

    @Test(priority = 2)
    public void createUser()
    {

        HashMap data = new HashMap();
        data.put("name","Shravani");
        data.put("job","teacher");
        id= given().contentType("application/json").body(data)
        .when().post("https://reqres.in/api/users").jsonPath().getInt("id");
        //.then().statusCode(201).log().all().body("name",equalTo("Shravani"));
        System.out.println(id);

    }

    @Test(priority=3,dependsOnMethods = "createUser")
    public void updateUser()
    {  HashMap data = new HashMap();
        data.put("name","Shravani");
        data.put("job","trainer");
         given().contentType("application/json").body(data)
                .when().put("https://reqres.in/api/users/"+id)
        .then().statusCode(200).log().all().body("job",equalTo("trainer"));
       // System.out.println(id);

    }

    @Test(priority = 4, dependsOnMethods = "createUser")
    public void deleteUser()
    {
        given()

                .when().delete("https://reqres.in/api/users/"+id)
                .then().log().all().statusCode(204);
    }
}
