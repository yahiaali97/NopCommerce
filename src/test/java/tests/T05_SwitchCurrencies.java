package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.P05_SwitchCurrencies;

import static org.testng.Assert.assertEquals;

public class T05_SwitchCurrencies extends TestBase {
    P05_SwitchCurrencies switchCurrenciesObject;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can Change Currency")
    public void userCanChangeCurrency() {
        switchCurrenciesObject = new P05_SwitchCurrencies(driver);
        switchCurrenciesObject.selectCurrencyOption();
        assertEquals(driver.findElement(switchCurrenciesObject.currencyOptions).getText(), "US Dollar" + "\n" + "Euro");
    }
}