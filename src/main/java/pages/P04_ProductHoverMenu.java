package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P04_ProductHoverMenu extends PageBase {
    public P04_ProductHoverMenu(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    //Todo:define locators using By
    private final By computerMenu = By.linkText("Computers");
    private final By notebooksMenu = By.linkText("Notebooks");

    public P04_ProductHoverMenu hoverOverComputersMenu() {
        action.moveToElement(driver.findElement(computerMenu)).perform();
        return this;
    }

    public void clickNotebooksMenu() {
        action.click(driver.findElement(notebooksMenu)).perform();
    }
}