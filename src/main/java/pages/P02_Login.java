package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login extends PageBase {

    public P02_Login(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By loginEmail = By.id("Email");
    private final By loginPW = By.id("Password");
    private final By loginBtn = By.xpath("//button[@class='button-1 login-button']");

    public P02_Login enterEmail(String email) {
        setTextElement(driver.findElement(loginEmail), email);
        return this;
    }

    public P02_Login enterPassword(String password) {
        setTextElement(driver.findElement(loginPW), password);
        return this;
    }

    public void clickLoginButton() {
        clickButton(driver.findElement(loginBtn));
    }
}
