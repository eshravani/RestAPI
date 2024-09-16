package userApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class LoggingDemo {


        @Test(priority = 1)
        public void logBody(){
            given()
                    .when().get("https://reqres.in/api/users?page=2")
                    .then().log().body();

        }
    @Test(priority = 2)
    public void logCookie(){
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().log().cookies();

    }

    @Test(priority = 3)
    public void logHeader(){
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().log().headers();

    }
    }
