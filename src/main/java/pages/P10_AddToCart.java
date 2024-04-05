package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_AddToCart extends PageBase {
    public P10_AddToCart(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By removeItemBtn = By.cssSelector("button.remove-btn");
    private final By updateCartBtn = By.id("updatecart");
    private final By quantityTxt = By.cssSelector("input.qty-input");
    public By totalLbl = By.cssSelector("td.subtotal");
    public By emptyCartCheckout = By.cssSelector("div.no-data");

    public P10_AddToCart addToCart() {
        clickButton(driver.findElement(addToCartBtn));
        return this;
    }

    public P10_AddToCart UpdateProductQuantityInCart(String quantity) {
        clearText(driver.findElement(quantityTxt));
        setTextElement(driver.findElement(quantityTxt), quantity);
        clickButton(driver.findElement(updateCartBtn));
        return this;
    }

    public P10_AddToCart RemoveProductFromCart() {
        clickButton(driver.findElement(removeItemBtn));
        return this;
    }
}