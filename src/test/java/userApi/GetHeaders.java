package userApi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetHeaders {


    @Test
    public void validateHeader(){
    given()
    .when()
    .get("https://google.com")
    .then()
    .header("Content-Type","text/html; charset=ISO-8859-1")
           // .and()
    .header("Content-Encoding","gzip")
    .header("Server","gws");
}
@Test
    public void getHeader()
{
    Response res =given()
            .when().get("https://google.com");
   String headerValue= res.getHeader("Content-Type");
   System.out.println(headerValue);
}

@Test
public void getHeaders()
{
    Response res =given()
            .when().get("https://google.com");
    Headers headers= res.getHeaders();
    for(Header hd:headers)
    {
       System.out.println(hd.getName()+"--->"+ hd.getValue());
    }
}

@Test
    public void getAllHeaderInfo()

{
    given()
            .when().get("https://www.google.com")
            .then()
            .log().headers();
    //.log().cookies()
    //        .log().body();
}
}
