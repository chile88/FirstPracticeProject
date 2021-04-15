package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    // Constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = ".info-account")
    WebElement welcomeMessage;

    @FindBy(xpath = "//a[@title = 'Orders']")
    WebElement orderHistory;

    // Actions
    public boolean checkWelcomeMessage() {
        return new WaitElementVisible(driver, welcomeMessage).waitUntil().isDisplayed();
    }

    public String getWelcomeMessageContent() {
        return new WaitElementVisible(driver, welcomeMessage).waitUntil().getText();
    }

    public void selectOrderHistory() {
        new WaitElementClickable(driver, orderHistory).waitUntil().click();
    }
}
