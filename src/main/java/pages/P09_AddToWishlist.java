package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_AddToWishlist extends PageBase {

    public P09_AddToWishlist(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    public By addToWishlistBtn = By.id("add-to-wishlist-button-4");
    public By wishlistHeader = By.cssSelector("h1");
    public By productCell = By.cssSelector("a.product-name");
    public By productQty = By.cssSelector("input.qty-input");
    private final By updateWishlistBtn = By.id("updatecart");
    private final By removeFromCartCheck = By.cssSelector("button.remove-btn");
    public By emptyCartLbl = By.cssSelector("div.no-data");

    public P09_AddToWishlist AddProductToWishlist() {
        clickButton(driver.findElement(addToWishlistBtn));
        return this;
    }

    public P09_AddToWishlist updateProductQty(String pQty) {
        clearText(driver.findElement(productQty));
        setTextElement(driver.findElement(productQty), pQty);
        clickButton(driver.findElement(updateWishlistBtn));
        return this;
    }

    public P09_AddToWishlist removeProductFromWishlist() {
        clickButton(driver.findElement(removeFromCartCheck));
        return this;
    }
}