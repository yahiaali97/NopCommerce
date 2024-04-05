package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_ProductSearch extends PageBase {

    public P03_ProductSearch(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By searchTxtBox = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By searchAssert = By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']");
    public By assertAutoSuggestSearch = By.cssSelector("strong.current-item");
    public List<WebElement> optionElements;

    public P03_ProductSearch productSearch(String searchBarBox) {
        setTextElement(driver.findElement(searchTxtBox), searchBarBox);
        clickButton(driver.findElement(searchBtn));
        return this;
    }

    public P03_ProductSearch ProductSearchUsingAutoSuggest(String searchTxt) {
        setTextElement(driver.findElement(searchTxtBox), searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionElements = driver.findElements(By.id("ui-id-1"));
        optionElements.get(0).click();
        return this;
    }
}