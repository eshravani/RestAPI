package postbodycreation;
/*
Different ways to create POST request body
1. Post request body using Hashmap
2. Post request body creation using Org.JSON
3. Post request body creation using POJO class
4. Post request using external json file data
*/

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import pojoClasses.CreateStudentBody;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class CreatePostBodyRequests {
    @Test
    public void usingHashMapCreateStudent()
    {
        HashMap data = new HashMap();
        data.put("name","Shravani");
        data.put("location", "New York");
        data.put("phone","");
        String courses[] = {"Java","Python","JavaScript"};
        data.put("courses",courses);

        given().contentType("application/json")
                .body(data)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201).log().all().body("name",equalTo("Shravani"))
                .body("courses",hasItems("Java","Python","JavaScript"));
    }

    @Test
    public void usingOrgJsonCreateStudent()
    {
        JSONObject data = new JSONObject();
        data.put("name","Shravani");
        data.put("location", "Houston");
        data.put("phone","123-345-3456");
        String courses[] = {"Java","Python","JavaScript","RestAssured"};
        data.put("courses",courses);

        given().contentType("application/json")
                .body(data.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201).log().all().body("name",equalTo("Shravani"));
    }

    @Test
    public void usingPOJOCreateStundent()
    {
        CreateStudentBody cs = new CreateStudentBody();
        cs.setname("Shravani Embadi");
        cs.setLocation("Houston");
        cs.setPhone("234-456-3454");
        String courses[] = {"Java","Python","JavaScript","RestAssured"};
        cs.setCourses(courses);

        given().contentType("application/json")
                .body(cs)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201).log().all().body("name",equalTo("Shravani Embadi"));

    }

    @Test
    public void usingJsonFileCreateStudent()
    {
        try {
            File f = new File(".//createStundet.json");
            FileReader fr = new FileReader(f);
            JSONTokener js = new JSONTokener(fr);
            JSONObject data = new JSONObject(js);
            given().contentType("application/json")
                    .body(data.toString())
                    .when().post("http://localhost:3000/students")
                    .then().statusCode(201).log().all().body("name",equalTo("John Doew"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}