package pages;

import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;

    // Constructor
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = ".bankwire")
    WebElement bankwirePay;

    // Actions
    public void selectPaybyBankWire() {
        new WaitElementVisible(driver, bankwirePay).waitUntil().click();
    }
}
