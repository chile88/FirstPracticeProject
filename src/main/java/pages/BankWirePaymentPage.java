package pages;

import common.explicitWait.WaitElementClickable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankWirePaymentPage {
    WebDriver driver;

    // Constructor
    public BankWirePaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = ".cart_navigation button[type = 'submit']")
    WebElement confirmOrder;

    // Actions
    public void selectConfirmMyOrder() {
        new WaitElementClickable(driver, confirmOrder).waitUntil().click();
    }
}
