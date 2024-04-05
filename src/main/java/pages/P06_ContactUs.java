package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ContactUs extends PageBase {

    public P06_ContactUs(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By name = By.id("FullName");
    private final By email = By.id("Email");
    private final By inquiry = By.id("Enquiry");
    private final By submitBtn = By.xpath("//button[@name='send-email']");
    public By submitMsg = By.cssSelector("div.result");

    public P06_ContactUs fillContactUsForm(String setName, String setEmail, String setInquiry) {
        setTextElement(driver.findElement(name), setName);
        setTextElement(driver.findElement(email), setEmail);
        setTextElement(driver.findElement(inquiry), setInquiry);
        return this;
    }

    public P06_ContactUs submitForm() {
        clickButton(driver.findElement(submitBtn));
        return this;
    }
}