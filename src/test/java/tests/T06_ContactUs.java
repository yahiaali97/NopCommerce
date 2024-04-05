package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P06_ContactUs;

import static org.testng.Assert.assertTrue;

public class T06_ContactUs extends TestBase {
    HomePage homeObject;
    P06_ContactUs contactUsObject;
    String name = "robert";
    String email = "robert@example.com";
    String inquiry = "I can't add items to the cart";

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can Send Complain or Inquiry")
    public void OpenContactUsPage() {
        homeObject = new HomePage(driver);
        contactUsObject = new P06_ContactUs(driver);

        homeObject.openContactPage();
        contactUsObject
                .fillContactUsForm(name, email, inquiry)
                .submitForm();
        assertTrue(driver.findElement(contactUsObject.submitMsg).getText()
                .contains("Your enquiry has been successfully sent"));
    }
}