package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;
import pages.P08_CheckoutProduct;
import pages.P10_AddToCart;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class T08_CheckoutProduct extends TestBase {
    P03_ProductSearch searchObject;
    P10_AddToCart shoppingCartObject;
    P08_CheckoutProduct checkoutObject;

    Faker fakeData = new Faker();
    String billingFirstName = fakeData.name().firstName();
    String billingLastName = fakeData.name().lastName();
    String billingEmail = fakeData.internet().emailAddress();
    String billingCountry = "Egypt";
    String billingCity = "Giza";
    String billingAddress1 = "Giza";
    String billingPostalCode = "12568";
    String billingPhoneNumber = "0100000000";

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    public void UserCanAddProductToShoppingCart() {
        shoppingCartObject = new P10_AddToCart(driver);

        shoppingCartObject.addToCart();
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User Can Checkout as Guest")
    public void checkoutAsGuest() throws InterruptedException {
        checkoutObject = new P08_CheckoutProduct(driver);

        checkoutObject
                .openCheckoutPage()
                .checkoutAsGuest();
        Thread.sleep(500);
        checkoutObject.fillBillingForm(billingFirstName,
                billingLastName,
                billingEmail,
                billingCountry,
                billingCity,
                billingAddress1,
                billingPostalCode,
                billingPhoneNumber);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(checkoutObject.orderDetailsLink).isDisplayed());
        checkoutObject.switchToOrderDetails();

        wait.until(d -> driver.findElement(checkoutObject.pdfInvoiceLink).isDisplayed());
        checkoutObject.DownloadPDFInvoice();
        Thread.sleep(4000);
        checkoutObject.PrintOrderDetails();
    }
}