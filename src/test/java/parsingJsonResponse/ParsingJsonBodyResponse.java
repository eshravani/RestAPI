package parsingJsonResponse;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonBodyResponse {

    /*@Test
    public void TestJsonResponse()
    {
        //Approach-1
        given()
        .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/students")
                .then().statusCode(200).body("courses[0][0]",equalTo("Java"));


    }

    @Test
    public void TestJsonResponseApprch2()
    {
        //Approach-2
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/students");
        Assert.assertEquals(res.statusCode(),200);
        String courses=res.jsonPath().get("courses[0][0]").toString();
        Assert.assertEquals(courses,"Java");

    }
*/
    @Test
    public void TestJsonResponseBookStore() {
        //Approach-2
        given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/books")
                .then().statusCode(200).log().all().body("[3].title", equalTo("The Catcher in the Rye"));
        /*Assert.assertEquals(res.statusCode(),200);
        String booktitle=res.jsonPath().get("books[0].title").toString();
        Assert.assertEquals(booktitle,"The Catcher in the Rye");*/

    }

    @Test
    public void getBooks() {
        Response res = given().contentType(ContentType.JSON)
                .when().get("http://localhost:3000/books");

        System.out.println(res.asString());

        // res.toString()
        JsonPath jp = new JsonPath(res.asString());
        Assert.assertEquals(res.statusCode(), 200);
        String bookname = res.jsonPath().get("[0].title");
        Assert.assertEquals(bookname, "The Great Gatsby");
        //Assert.assertEquals(jp.getString("[0].title"),"The Great Gatsby");
        // JSONObject jo = new JSONObject(res.toString());

        //  jo.getJSONArray

    }

    @Test
    public void getBooksJsonArrayValidation() {
        Response res = given().contentType(ContentType.JSON)
                .when().get("http://localhost:3000/books");

      //  JSONObject jo = new JSONObject(res.asString());//JsonObject accept string type of response to process further
        JSONArray ja = new JSONArray(res.asString());
       // jo.getJSONArray("");
        boolean bookExist = false;
        for(int i=0;i<ja.length();i++)
        {
            String bookTitle=ja.getJSONObject(i).get("title").toString();
            if(bookTitle.equalsIgnoreCase("To Kill a Mockingbird"))
            {
                bookExist=true;
                break;
            }
          //  System.out.println(ja.getJSONObject(i).get("title").toString());
        }

        Assert.assertEquals(bookExist,true);


    }
    @Test
    public void getTotalPriceOfBooks()
    {
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/books");
        JSONArray ja = new JSONArray(res.asString());
        double total=0;
        for(int i=0;i<ja.length();i++)
        {
            double bookPrice =  Double.parseDouble(ja.getJSONObject(i).get("price").toString());
            total+=bookPrice;
        }

Assert.assertEquals(total,47.95);

    }}