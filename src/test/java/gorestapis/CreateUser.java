package gorestapis;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateUser {

    @Test
    public void createUser(ITestContext context)
    {

        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("email",faker.internet().emailAddress());
        jo.put("gender","female");
        jo.put("status","inactive");

        Name name=faker.name();
        String bearerToken = "5668d6f9a303f5663fe6d27f5735b3d70736d1cd3dabe1f3d77dbae6d16e65c3";
        int id=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(jo.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
      //  context.setAttribute("userid",id);
        context.getSuite().setAttribute("userid",id);
        System.out.println(id);
    }
}
