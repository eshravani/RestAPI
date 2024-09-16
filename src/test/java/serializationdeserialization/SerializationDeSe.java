package serializationdeserialization;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojoClasses.CreateStudentBody;

//convert pojo-josn-serialization
//conver json-pojo-deserialization
public class SerializationDeSe {

    @Test
    public void convertPojoToJson() throws JsonProcessingException {

        //creating java object using pojo
        CreateStudentBody cs = new CreateStudentBody();
        cs.setname("Shravani");
        cs.setLocation("Houston");
        String[] courses = {"python", "java script"};
        cs.setCourses(courses);

        //converting pojo to Json
        ObjectMapper objectMapper = new ObjectMapper();
        String jsondata = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cs); //json data will be in the string format.
        System.out.println(jsondata);
    }

    @Test
    public void jsonToPojo() throws JsonProcessingException {
        //creating json object
        String jsonData = "{\n" +
                "  \"name\": \"John Doew\",\n" +
                "  \"location\": \"New Yorkk\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"courses\": [\n" +
                "    \"Java\",\n" +
                "    \"Python\",\n" +
                "    \"JavaScript\"\n" +
                "  ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
//convert json to Pojo
        CreateStudentBody csdpojo=objectMapper.readValue(jsonData,CreateStudentBody.class);
        System.out.println(csdpojo.getName());
        System.out.println(csdpojo.getCourses());
        System.out.println(csdpojo.getLocation());
        System.out.println(csdpojo.getCourses()[0]);
        System.out.println(csdpojo.getCourses()[1]);

    }
}