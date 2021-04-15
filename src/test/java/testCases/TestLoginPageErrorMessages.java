package testCases;

import data.testdata.TestLoginData;
import data.testdata.TestMessageData;
import data.testdata.TestRegisterData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SigninPage;
import testbase.TestBase;

public class TestLoginPageErrorMessages extends TestBase {
    SigninPage objSigninPage;
    MainPage objMainPage;

    @Test(priority = 0)
    public void tesEmptyLoginErrorMessage() {
        // Create main page
        objMainPage = new MainPage(driver);
        // Select account link
        objMainPage.selectSigninButton();
        // Go to signin page
        objSigninPage = new SigninPage(driver);
        // Login with empty login credentials
        objSigninPage.signIn(TestLoginData.emptyData.getEmail(), TestLoginData.emptyData.getPassword());
        // create signin page
        objSigninPage = new SigninPage(driver);
        // Assert authentication error message is displayed
        Assert.assertTrue(objSigninPage.checkAuthenticationMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getAuthenicationMessageContent().equals(TestMessageData.loginEmailRequired.getMessage()));

    }

    @Test(priority = 1)
    public void testInvalidEmailErrorMessage() {
        objSigninPage.signIn(TestLoginData.invalidEmail.getEmail(), TestLoginData.invalidEmail.getPassword());
        // Assert authentication error message is displayed
        Assert.assertTrue(objSigninPage.checkAuthenticationMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getAuthenicationMessageContent().equals(TestMessageData.invalidEmailCredentials.getMessage()));
    }

    @Test(priority = 2)
    public void testInvalidPasswordMessage() {
        objSigninPage.signIn(TestLoginData.invalidPass.getEmail(), TestLoginData.invalidPass.getPassword());
        // Assert authentication error message is displayed
        Assert.assertTrue(objSigninPage.checkAuthenticationMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getAuthenicationMessageContent().equals(TestMessageData.invalidPassCredentials.getMessage()));
    }

    @Test(priority = 3)
    public void testEmptyPasswordMessage() {
        objSigninPage.signIn(TestLoginData.emptyPassword.getEmail(), TestLoginData.emptyPassword.getPassword());
        // Assert authentication error message is displayed
        Assert.assertTrue(objSigninPage.checkAuthenticationMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getAuthenicationMessageContent().equals(TestMessageData.loginPassRequired.getMessage()));
    }

    @Test(priority = 4)
    public void testWrongCredentialMessage() {
        objSigninPage.signIn(TestLoginData.wrongData.getEmail(), TestLoginData.wrongData.getPassword());
        // Assert authentication error message is displayed
        Assert.assertTrue(objSigninPage.checkAuthenticationMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getAuthenicationMessageContent().equals(TestMessageData.wrongCredentials.getMessage()));
    }

    @Test(priority = 5)
    public void testInvalidEmailRegistterMessage() {
        objSigninPage.createAccountWithEmail(TestRegisterData.invalidEmail.getEmail());
        // Assert create account error message is displayed
        Assert.assertTrue(objSigninPage.checkCreateAccountErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getCreateAccountErrorContent().equals(TestMessageData.invalidEmailCredentials.getMessage()));
    }

    @Test(priority = 6)
    public void testExistingEmailRegisterMessage() {
        objSigninPage.createAccountWithEmail(TestRegisterData.existingEmail.getEmail());
        // Assert create account error message is displayed
        Assert.assertTrue(objSigninPage.checkCreateAccountErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getCreateAccountErrorContent().equals(TestMessageData.existingEmail.getMessage()));

    }

    @Test(priority = 7)
    public void testEmptyEmailRegisterMessage() {
        objSigninPage.createAccountWithEmail(TestRegisterData.emptyEmail.getEmail());
        // Assert create account error message is displayed
        Assert.assertTrue(objSigninPage.checkCreateAccountErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objSigninPage.getCreateAccountErrorContent().equals(TestMessageData.invalidEmailCredentials.getMessage()));
    }

}
