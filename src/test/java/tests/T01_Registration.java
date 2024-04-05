package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P01_Registration;

import static org.testng.Assert.assertTrue;

public class T01_Registration extends TestBase {
    HomePage homeObject;
    P01_Registration registerObject;
    static Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().firstName();
    static String email = fakeData.internet().emailAddress();
    static String password = fakeData.number().digits(8);

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Registered Successfully")
    public void userRegistration() {
        homeObject = new HomePage(driver);
        registerObject = new P01_Registration(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }
}