package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ChangePassword extends PageBase {

    public P07_ChangePassword(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    public By myAccountLink = By.linkText("My account");
    public By changePWLink = By.xpath("//a[@href='/customer/changepassword']");
    private final By oldPW = By.id("OldPassword");
    private final By newPW = By.id("NewPassword");
    private final By confirmNewPW = By.id("ConfirmNewPassword");
    private final By changePWBtn = By.xpath("//button[@class='button-1 change-password-button']");
    private final By confirmLbl = By.xpath("//span[@class='close']");

    public P07_ChangePassword openMyAccountPage() {
        clickButton(driver.findElement(myAccountLink));
        return this;
    }

    public P07_ChangePassword openChangePWPage() {
        clickButton(driver.findElement(changePWLink));
        return this;
    }

    public P07_ChangePassword changePassword(String oldPass, String newPass) {
        setTextElement(driver.findElement(oldPW), oldPass);
        setTextElement(driver.findElement(newPW), newPass);
        setTextElement(driver.findElement(confirmNewPW), newPass);
        clickButton(driver.findElement(changePWBtn));
        clickButton(driver.findElement(confirmLbl));
        return this;
    }
}