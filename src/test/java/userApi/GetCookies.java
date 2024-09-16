package userApi;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetCookies {

    @Test
    public void validateCookie()///cookies are dynamic we can't validate, we will just check whether generted or not
    {
      given()
                .when().when().get("https://www.google.com/")
                      .then().cookie("AEC","").log().all();
       // System.out.println( res.getCookie("AEC"));

    }

    @Test
    public void getCookieInfo()
    {
        Response res = given()
                .when().when().get("https://www.google.com/");
       System.out.println( res.getCookie("AEC"));


    }    @Test
    public void getCookies()
    {
        Response res = given()
                .when()
                .get("https://www.google.com/");
        res.getCookies();
       Map<String,String> hmap = res.getCookies();
       for(String cookies:hmap.keySet())
       {
           System.out.println(cookies+ "--------------------> "+hmap.get(cookies));

       }

    }
}
