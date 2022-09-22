package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.component.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderCheckBox = $("#genterWrapper"),
            userUserNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

        return this;
    }
    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public PracticeFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }
    public PracticeFormPage setGender(String gender) {
        genderCheckBox.$(byText(gender)).click();
        return this;
    }
    public PracticeFormPage setUserNumber(String userNumber) {
        userUserNumberInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPage setBirthDate(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }
}
