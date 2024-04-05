package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P01_Registration;
import pages.P02_Login;

import static org.testng.Assert.assertTrue;

public class T02_Login extends TestBase {
    HomePage homeObject;
    P01_Registration registerObject;
    P02_Login loginObject;
    static Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().firstName();
    static String email = fakeData.internet().emailAddress();
    static String password = fakeData.number().digits(8);

    @Test(priority = 1)
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

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Login with Valid Credentials")
    public void userLogin() {
        homeObject = new HomePage(driver);
        loginObject = new P02_Login(driver);

        homeObject.openLoginPage();
        loginObject.enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }
}