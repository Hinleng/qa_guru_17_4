package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void demoqaPracticeFormTest(){
        open("/automation-practice-form");
        $(".row h5").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("David");
        $("#lastName").setValue("Hardy");
        $("#userEmail").setValue("gaguru@guru.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1357924680");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("ToolsQA.png");
        $("#currentAddress").setValue("89 COLUMBIA ST NEW YORK NY 10002-1916 USA");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("David"), text("Hardy"),
                text("gaguru@guru.ru"), text("1357924680"), text("10 January,2008"), text("English"), text("Reading"), text("ToolsQA.png"), text("89 COLUMBIA ST NEW YORK NY 10002-1916 USA"), text("NCR Noida"));
    }
}
