package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.P04_ProductHoverMenu;

import static org.testng.Assert.assertTrue;

public class T04_ProductHoverMenu extends TestBase {
    P04_ProductHoverMenu hoverMenuObject;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can Hover on Product Menu and Select Sub Category")
    public void userCanChooseProductUsingHoverMenu() {
        hoverMenuObject = new P04_ProductHoverMenu(driver);
        hoverMenuObject
                .hoverOverComputersMenu()
                .clickNotebooksMenu();
        assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}