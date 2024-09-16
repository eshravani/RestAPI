package fakerDataGeneration;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGeneration {

    @Test
    public void test1()
    {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = faker.name().username();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);

    }}

