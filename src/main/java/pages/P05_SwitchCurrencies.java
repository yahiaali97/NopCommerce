package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P05_SwitchCurrencies extends PageBase {

    public P05_SwitchCurrencies(WebDriver driver) {
        super(driver);
    }

    //Todo:define locators using By
    public final By currencyOptions = By.id("customerCurrency");

    public P05_SwitchCurrencies selectCurrencyOption() {
        select = new Select(driver.findElement(currencyOptions));
        select.selectByIndex(1);
        return this;
    }
}
