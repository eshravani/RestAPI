package gorestapis;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Test
    public void deleteUser(ITestContext context)
    {
        //  int id = (int) context.getAttribute("userid");
        int id = (int) context.getSuite().getAttribute("userid");
        String bearerToken ="5668d6f9a303f5663fe6d27f5735b3d70736d1cd3dabe1f3d77dbae6d16e65c3";
        given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("id1",id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id1}")
                .then()
                .statusCode(204);

    }
}
