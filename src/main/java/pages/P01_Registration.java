package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_Registration extends PageBase {

    public P01_Registration(WebDriver driver) {
        super(driver);
    }

    // Todo: define locators using By
    private final By genderSelect = By.id("gender-male");
    private final By fnBox = By.id("FirstName");
    private final By lnBox = By.id("LastName");
    private final By emailBox = By.id("Email");
    private final By pwBox = By.id("Password");
    private final By confirmPWBox = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    public By resultMsg = By.cssSelector("div.result");
    public By logoutLink = By.xpath("//a[@href='/logout']");


    public P01_Registration userRegistration(String firstName, String lastName, String emailAddress, String pass) {
        clickButton(driver.findElement(genderSelect));
        setTextElement(driver.findElement(fnBox), firstName);
        setTextElement(driver.findElement(lnBox), lastName);
        setTextElement(driver.findElement(emailBox), emailAddress);
        setTextElement(driver.findElement(pwBox), pass);
        setTextElement(driver.findElement(confirmPWBox), pass);
        clickButton(driver.findElement(registerBtn));
        return this;
    }

    public P01_Registration usrLogout() throws InterruptedException {
        Thread.sleep(1000);
        clickButton(driver.findElement(logoutLink));
        return this;
    }
}