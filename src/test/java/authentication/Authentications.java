package authentication;

import org.json.JSONArray;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authentications {

    @Test(priority=1)
    public void basicAuthentication()
    {
        given()
                .auth().basic("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).log().all().body("authenticated",equalTo(true));
    }

    @Test(priority=2)
    public void digestAuthentication()
    {
        given()
                .auth().digest("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).log().all().body("authenticated",equalTo(true));
    }
    @Test(priority=3)
    public void preemptiveAuthentication()
    {
        given()
                .auth().preemptive().basic("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).log().all().body("authenticated",equalTo(true));
    }
    @Test(priority=4)
    public void bearerTokenAuthentication()
    {
        String token="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";
        given()
                .headers("Authorization","Bearer "+ token)
                .when().get("https://api.github.com/user/repos")
                .then().statusCode(200).log().all();
    }

    @Test(priority=5)
    public void oAuthAuthentication()
    {//Oauth1.0 authentication
               given()
                .auth().oauth("ConsusmerKey","consumerSecret","access_token","tokenSecret")
                .when().get("url")
                .then().statusCode(200).log().all();
    }

    @Test(priority=6)
    public void oAuthTwpAuthentication()
    {//Oauth1.0 authentication
        given()
                .auth().oauth2("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")
                .when().get("https://api.github.com/user/repos")
                .then().statusCode(200).log().all();
    }

    @Test(priority=6)
    public void apiKeyAuthentication()
    {//Oauth1.0 authentication
        given()
                .queryParam("appid","11ASS4YNY0kxIMqGswj7lB_but8VZdTL8cbBlW2gxf8OuZlcZQhpIv14lBRAkUoqibS2X5HZQ7f6MWXb22")
                .when().get("https://abcd.api.com/user/repos")
                .then().statusCode(200).log().all();

    }
}

