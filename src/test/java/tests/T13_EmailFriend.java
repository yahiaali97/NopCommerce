package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class T13_EmailFriend extends TestBase {
    HomePage homeObject;
    P01_Registration registerObject;
    P02_Login loginObject;
    P03_ProductSearch searchObject;
    P13_EmailFriend emailFriendObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String personalMsg = "This product is very good for you";
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new HomePage(driver);
        registerObject = new P01_Registration(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg)
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void SearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    public void userLogin() {
        homeObject = new HomePage(driver);
        loginObject = new P02_Login(driver);

        homeObject.openLoginPage();
        loginObject.enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Email Friend")
    public void emailFriend() {
        emailFriendObject = new P13_EmailFriend(driver);
        emailFriendObject.sendEmailToFriend(email, personalMsg);
        assertTrue(driver.findElement(emailFriendObject.ConfirmationMsg).getText()
                .contains("Your message has been sent"));
    }
}