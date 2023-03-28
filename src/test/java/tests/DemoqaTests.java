package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void demoqaPracticeFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("David")
                .setLastName("Hardy")
                .setUserEmail("gaguru@guru.ru")
                .setGender("Male")
                .setNumber("1357924680")
                .setDateOfBirth("10", "January", "2008")
                .setSubjects("English")
                .setHobbies("Reading")
                .uploadPicture("ToolsQA.png")
                .setAddress("89 COLUMBIA ST NEW YORK NY 10002-1916 USA")
                .setStateAndCity("NCR", "Noida")
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "David Hardy")
                .verifyResult("Student Email", "gaguru@guru.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1357924680")
                .verifyResult("Date of Birth", "10 January,2008")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "ToolsQA.png")
                .verifyResult("Address", "89 COLUMBIA ST NEW YORK NY 10002-1916 USA")
                .verifyResult("State and City", "NCR" + " " + "Noida");
    }
}
