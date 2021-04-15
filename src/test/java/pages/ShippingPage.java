package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementExists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    WebDriver driver;

    // Constructor
    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "cgv")
    WebElement termOfService;

    @FindBy(name = "processCarrier")
    WebElement proccedToCheckOut;

    // Actions

    public void selectTermOfService() {
        termOfService = new WaitElementExists(driver, By.cssSelector("#cgv")).waitUntil();
        if (!termOfService.isSelected()) {
            termOfService.click();
        }
    }

    public void selectProccedToCheckOut() {
        new WaitElementClickable(driver, proccedToCheckOut).waitUntil().click();
    }

}
