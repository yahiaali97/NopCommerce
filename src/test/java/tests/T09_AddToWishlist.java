package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;
import pages.P09_AddToWishlist;

import static org.testng.Assert.assertTrue;

public class T09_AddToWishlist extends TestBase {
    P03_ProductSearch searchObject;
    P09_AddToWishlist wishlistObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    public void UserSearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("apple mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Add Product to Wishlist")
    public void userCanAddProductToWishlist() {
        wishlistObject = new P09_AddToWishlist(driver);

        wishlistObject.AddProductToWishlist();
        driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");

        assertTrue(driver.findElement(wishlistObject.wishlistHeader).isDisplayed());
        assertTrue(driver.findElement(wishlistObject.productCell).getText()
                .contains(productName));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Update the Quantity of Product in Wishlist Page")
    public void userCanUpdateQtyOfProductInWishlist() {
        wishlistObject.updateProductQty("5");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Remove Product From Wishlist")
    public void userCanRemoveProductFromWishlist() {
        wishlistObject.removeProductFromWishlist();
        assertTrue(driver.findElement(wishlistObject.emptyCartLbl).getText()
                .contains("The wishlist is empty"));
    }
}