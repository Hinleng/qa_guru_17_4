package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static tests.utils.RandomUtils.randomCityGenerator;

public class RegistrationWithJavaFakerTests extends TestBase {
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Filling out Practice form in Demoqa")
    void demoqaPracticeFormTest() {
        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.options().option("Male","Female","Other");
        String number = faker.phoneNumber().subscriberNumber(10);
        String day = String.format("%02d", faker.number().numberBetween(1, 28));
        String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String year = faker.number().numberBetween(1930,2000) + "";
        String object = faker.options().option("English", "Chemistry", "Computer Since", "Commerce", "Economics", "Social Studies");
        String hobby = faker.options().option("Sports", "Reading", "Music");
        String image = "ToolsQA.png";
        String address = faker.address().fullAddress();
        String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        String city = randomCityGenerator(state);


        step("Open registration form", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Fill form", () -> {
        registrationPage.setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubjects(object)
                .setHobbies(hobby)
                .uploadPicture(image)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();
        });
        step("Check form results", () -> {
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", object)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", image)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
        });
    }
}
