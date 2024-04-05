package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;
import pages.P12_CompareProducts;

import static org.testng.Assert.assertTrue;

public class T12_CompareProducts extends TestBase {
    P03_ProductSearch searchObject;
    P12_CompareProducts compareObject;
    String firstProduct = "Apple MacBook Pro 13-inch";
    String secondProduct = "Asus N551JK-XO076H Laptop";

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to(getBaseUrl());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Compare Products")
    public void userCanCompareProducts() {
        searchObject = new P03_ProductSearch(driver);
        compareObject = new P12_CompareProducts(driver);

        searchObject.ProductSearchUsingAutoSuggest(firstProduct);
        compareObject.addProductToCompare();

        waitForSomeTime();
        searchObject = new P03_ProductSearch(driver);
        compareObject = new P12_CompareProducts(driver);
        searchObject.ProductSearchUsingAutoSuggest(secondProduct);
        compareObject.addProductToCompare();

        waitForSomeTime();
        driver.navigate().to(getBaseUrl() + "/compareproducts");
        assertTrue(driver.findElement(compareObject.firstProductName).getText()
                .contains("Apple"));
        assertTrue(driver.findElement(compareObject.secondProductName).getText()
                .contains("Asus"));
    }

    @Test(priority = 3)
    public void clearList() {
        searchObject = new P03_ProductSearch(driver);
        compareObject = new P12_CompareProducts(driver);

        compareObject.clearCompareTable();
        assertTrue(driver.findElement(compareObject.noDataLbl).getText()
                .contains("You have no items to compare"));
    }

    private T12_CompareProducts waitForSomeTime() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    private String getBaseUrl() {
        return "http://demo.nopcommerce.com";
    }
}