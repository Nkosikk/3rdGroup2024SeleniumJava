package Utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class generateTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().fullName();
    public static String zipcode = faker.address().zipCode();
//    public static String zipcode = faker.address().zipCode();
    public static String number = faker.app().name();


    @Test
    public void test(){
        System.out.println(number);
        System.out.println(zipcode);
    }



}
