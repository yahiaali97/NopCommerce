package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P13_EmailFriend extends PageBase {

    public P13_EmailFriend(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By emailFriendBtn = By.cssSelector("div.email-a-friend");
    private final By emailFriendTxt = By.id("FriendEmail");
    private final By personalMsgTxt = By.id("PersonalMessage");
    private final By submitSentBtn = By.xpath("//button[@name=\"send-email\"]");
    public By ConfirmationMsg = By.cssSelector("div.result");

    public P13_EmailFriend sendEmailToFriend(String friendEmail, String personalMsg) {
        clickButton(driver.findElement(emailFriendBtn));
        setTextElement(driver.findElement(emailFriendTxt), friendEmail);
        setTextElement(driver.findElement(personalMsgTxt), personalMsg);
        clickButton(driver.findElement(submitSentBtn));
        return this;
    }
}