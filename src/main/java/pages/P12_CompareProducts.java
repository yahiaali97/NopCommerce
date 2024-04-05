package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12_CompareProducts extends PageBase {

    public P12_CompareProducts(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By addToCompareBtn = By.cssSelector("button.button-2.add-to-compare-list-button\n");
    private final By clearListBtn = By.cssSelector("a.clear-list");
    public By noDataLbl = By.cssSelector("div.no-data");
    public By firstProductName = By.linkText("Apple MacBook Pro 13-inch");
    public By secondProductName = By.linkText("Asus N551JK-XO076H Laptop");

    public P12_CompareProducts addProductToCompare() {
        clickButton(driver.findElement(addToCompareBtn));
        return this;
    }

    public P12_CompareProducts clearCompareTable() {
        clickButton(driver.findElement(clearListBtn));
        return this;
    }
}