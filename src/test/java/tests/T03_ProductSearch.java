package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;

import static org.testng.Assert.assertTrue;

public class T03_ProductSearch extends TestBase {

    pages.P03_ProductSearch searchObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can Search for Product")
    public void userCanSearchForProduct() {
        searchObject = new pages.P03_ProductSearch(driver);
        searchObject.productSearch(productName);
        assertTrue(driver.findElement(searchObject.searchAssert).isDisplayed());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can Search for Product with Auto Suggest")
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }
}