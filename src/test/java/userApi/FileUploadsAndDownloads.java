package userApi;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FileUploadsAndDownloads {

    @Test
    public void singleFileUploadtest1()
    {
        File myfile = new File(".//myfile.txt");
        given().multiPart("file","myfile").contentType("multipart/form-data")
        .when().post("").then().statusCode(200).log().all();
    }

    @Test
    public void multipleFileUploadtest2()
    {
        File myfile1 = new File(".//myfile1.txt");
        File myfile2 = new File(".//myfile2.txt");
        given()
                .multiPart("file","myfile1")
                .multiPart("file","myfile2")
                .contentType("multipart/form-data")
                .when().post("").then()
                .statusCode(200)
                .body("[0].fileName",equalTo("myfile1.txt"))
                .body("[0].fileName",equalTo("myfile2.txt"))
                .log().all();
    }

    @Test
    public void multipleFileUploadtest3()
    {
        File myfile1 = new File(".//myfile1.txt");
        File myfile2 = new File(".//myfile2.txt");

        File fileArray[]={myfile1,myfile2};
        given()
                .multiPart("file",fileArray)
                .contentType("multipart/form-data")
                .when().post("").then()
                .statusCode(200)
                .body("[0].fileName",equalTo("myfile1.txt"))
                .body("[0].fileName",equalTo("myfile2.txt"))
                .log().all();
    }

    @Test
    public void sfileDownload()
    {

        given()
                .when().get("https//abcd.com")
                .then().statusCode(200).log().body();
    }
}
