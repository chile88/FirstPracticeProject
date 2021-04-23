package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
    WebDriver driver;

    //Constructor
    public SigninPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement signinButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    WebElement forgotPassword;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(xpath = "//div[@id = 'create_account_error']//li")
    WebElement createAccountError;

    @FindBy(xpath = "//div[@class = 'alert alert-danger']//li")
    WebElement authenicationError;

    // Sign in
    public void signIn(String username, String password) {
        new WaitElementVisible(driver, email).waitUntil().clear();
        email.sendKeys(username);
        new WaitElementVisible(driver, this.password).waitUntil().clear();
        this.password.sendKeys(password);
        signinButton.click();
    }

    public boolean checkCreateAccountErrorMessage() {
        return new WaitElementVisible(driver, createAccountError).waitUntil().isDisplayed();
    }

    public String getCreateAccountErrorContent() {
        return createAccountError.getText();
    }


    public boolean checkAuthenticationMessage() {
        return new WaitElementVisible(driver, authenicationError).waitUntil().isDisplayed();
    }

    public String getAuthenicationMessageContent() {
        return authenicationError.getText();
    }

    public boolean checkErrorMessaneContent(String actualMessage, String expectedMessage) {
        return actualMessage.equals(expectedMessage);
    }

    public void createAccountWithEmail(String email) {
        new WaitElementVisible(driver, emailCreate).waitUntil().clear();
        emailCreate.sendKeys(email);
        new WaitElementClickable(driver, createAccountButton).waitUntil().click();
    }

    public void selectForgotPassword() {
        new WaitElementClickable(driver, forgotPassword).waitUntil().click();
    }

}
