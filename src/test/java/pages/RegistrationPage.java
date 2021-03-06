package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static utils.RandomUtils.*;


public class RegistrationPage {





        String firstName = getRandomString(10),
                lastName = getRandomString(8),
                email = getRandomEmail(),
                gender = getRandomGender(1, 1),
                mobile = getRandomPhone(),
                dayOfBirth = getRandomInt(10, 28) + "",
                monthOfBirth = getRandomMonth(1, 1),
                yearOfBirth = getRandomInt(1950, 2000) + "",
                subject1 = getRandomSubjects(1, 1),
                subject2 = getRandomSubjects(1, 1),
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "che.png",
                currentAddress = getRandomString(50),
                state = "NCR",
                city = "Delhi";

        @Step("Open students registration form")
        public void openPage () {
            open("https://demoqa.com/automation-practice-form");
        }

        @Step("Fill students registration form")
        public void fillForm () {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
            $(byText(gender)).click();
            $("#userNumber").setValue(mobile);
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption(yearOfBirth);
            $(".react-datepicker__month-select").selectOption(monthOfBirth);
            $(".react-datepicker__day--0" + dayOfBirth).click();
            $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();
            $(byText(hobby2)).click();
            $(byText(hobby3)).click();
            $("#uploadPicture").uploadFromClasspath("img/" + picture);
            $("#currentAddress").setValue(currentAddress);
            $("#state").click();
            $("#stateCity-wrapper").$(byText(state)).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText(city)).click();
            $("#submit").click();
        }

        @Step("Check successful form submit")
        public void checkData () {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
            $x("//td[text()='Student Email']").parent().shouldHave(text(email));
            $x("//td[text()='Gender']").parent().shouldHave(text(gender));
            $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
            $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
            $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));
            $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby2 + ", " + hobby3));
            $x("//td[text()='Picture']").parent().shouldHave(text(picture));
            $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
            $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
        }
    }

