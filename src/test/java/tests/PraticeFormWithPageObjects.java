package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PraticeFormWithPageObjects {
    RegistrationPage registrationPage;

    @Test
    void successfulFillFormTest() {
        registrationPage = new RegistrationPage();

        registrationPage.openPage();
        registrationPage.fillForm();
        registrationPage.checkData();


    }
}
