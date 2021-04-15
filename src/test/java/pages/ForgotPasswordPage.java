package pages;

import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;

    // Constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(xpath = "//p[@class='submit']//button")
    WebElement submitButton;

    @FindBy(css = ".alert-success")
    WebElement confirmationMessage;

    @FindBy(css = ".alert-danger li")
    WebElement errorMessage;

    public void forgotPassword(String email) {
        new WaitElementVisible(driver, this.email).waitUntil().clear();
        this.email.sendKeys(email);
        new WaitElementVisible(driver, submitButton).waitUntil().click();
    }

    public boolean checkConfirmationMessage() {
        return new WaitElementVisible(driver, confirmationMessage).waitUntil().isDisplayed();
    }

    public String confirmationMesssageContent() {
        return confirmationMessage.getText();
    }

    public boolean checkErrorMessage() {
        return new WaitElementVisible(driver, errorMessage).waitUntil().isDisplayed();
    }

    public  String errorMessageContent() {
        return errorMessage.getText();
    }

}
