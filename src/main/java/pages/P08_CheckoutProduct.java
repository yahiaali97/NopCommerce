package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P08_CheckoutProduct extends PageBase {
    public P08_CheckoutProduct(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    public By agreeCheckbox = By.id("termsofservice");
    public By checkoutBtn = By.id("checkout");
    private final By guestCheckoutBtn = By.xpath("//button[@class='button-1 checkout-as-guest-button']");
    private final By billingFirstName = By.id("BillingNewAddress_FirstName");
    private final By billingLastName = By.id("BillingNewAddress_LastName");
    private final By billingEmail = By.id("BillingNewAddress_Email");
    private final By billingCountry = By.id("BillingNewAddress_CountryId");
    private final By billingCity = By.id("BillingNewAddress_City");
    private final By billingAddress1 = By.id("BillingNewAddress_Address1");
    private final By billingPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    private final By billingPhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public By continueBtn = By.xpath("//button[@class='button-1 new-address-next-step-button' and @name='save']");
    private final By ConfirmShippingCheckoutBtn = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private final By ConfirmPaymentMethodBtn = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By ConfirmPaymentInfoBtn = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private final By ConfirmOrderBtn = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    public By orderDetailsLink = By.linkText("Click here for order details.");
    private final By printInvoiceLink = By.xpath("//a[@class='button-2 print-order-button']");
    public By pdfInvoiceLink = By.xpath("//a[@class='button-2 pdf-invoice-button']");

    public P08_CheckoutProduct openCheckoutPage() {
        clickButton(driver.findElement(agreeCheckbox));
        clickButton(driver.findElement(checkoutBtn));
        return this;
    }

    public P08_CheckoutProduct checkoutAsGuest() {
        clickButton(driver.findElement(guestCheckoutBtn));
        return this;
    }

    public P08_CheckoutProduct fillBillingForm(String fName, String lName, String email, String country, String city, String address1, String postalCode, String phoneNumber) {
        setTextElement(driver.findElement(billingFirstName), fName);
        setTextElement(driver.findElement(billingLastName), lName);
        setTextElement(driver.findElement(billingEmail), email);
        setTextElement(driver.findElement(billingCountry), country);
        setTextElement(driver.findElement(billingCity), city);
        setTextElement(driver.findElement(billingAddress1), address1);
        setTextElement(driver.findElement(billingPostalCode), postalCode);
        setTextElement(driver.findElement(billingPhoneNumber), phoneNumber);
        clickButton(driver.findElement(continueBtn));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmShippingCheckoutBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmShippingCheckoutBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmPaymentMethodBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmPaymentMethodBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmPaymentInfoBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmPaymentInfoBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmOrderBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmOrderBtn));
        return this;
    }

    public P08_CheckoutProduct switchToOrderDetails() {
        clickButton(driver.findElement(orderDetailsLink));
        return this;
    }

    public P08_CheckoutProduct PrintOrderDetails() {
        clickButton(driver.findElement(printInvoiceLink));
        return this;
    }

    public P08_CheckoutProduct DownloadPDFInvoice() {
        clickButton(driver.findElement(pdfInvoiceLink));
        return this;
    }
}