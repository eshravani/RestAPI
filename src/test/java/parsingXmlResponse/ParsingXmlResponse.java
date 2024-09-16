package parsingXmlResponse;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingXmlResponse {

    @Test
    public void validateXML(){
        when()
                .get("https://mocktarget.apigee.net/xml")
                .then()
                .body("root.firstName",equalTo("John"));
    }

    @Test
    public void validateXMLRes(){
        Response res=when()
                .get("https://mocktarget.apigee.net/xml");

        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(res.xmlPath().get("root.firstName").toString(),"John");

    }

    @Test
    public void validateXMLResp(){
        Response res=when()
                .get("https://mocktarget.apigee.net/xml");

        XmlPath xmlPath = new XmlPath(res.asString());
        Assert.assertEquals(xmlPath.get("root.firstName").toString(),"John");
        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(res.xmlPath().get("root.firstName").toString(),"John");

    }
}
