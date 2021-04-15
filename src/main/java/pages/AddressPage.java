package pages;


import common.explicitWait.WaitElementClickable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage {
    WebDriver driver;
    // Constructor
    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(name = "processAddress")
    WebElement proccedToCheckOut;

    // Actions
    public void selectProccedToCheckOut() {
        new WaitElementClickable(driver, proccedToCheckOut).waitUntil().click();
    }
}
