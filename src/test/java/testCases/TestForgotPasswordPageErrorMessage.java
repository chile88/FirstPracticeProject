package testCases;

import common.SetUp;
import data.testdata.TestForgotPasswordData;
import data.testdata.TestMessageData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.MainPage;
import pages.SigninPage;

public class TestForgotPasswordPageErrorMessage extends SetUp {
    MainPage objMainPage;
    SigninPage objSigninPage;
    ForgotPasswordPage objForgotPasswordPage;

    @Test(priority = 0)
    // Test error message when attempting forgot password with empty email
    public void testEmptyEmail() {
        // Create Main page
        objMainPage = new MainPage(driver);
        // Select Signin button
        objMainPage.selectSigninButton();
        // Create Signin page
        objSigninPage = new SigninPage(driver);
        // Select forgot password link
        objSigninPage.selectForgotPassword();
        // Create Forgot Password page
        objForgotPasswordPage = new ForgotPasswordPage(driver);
        // Attempt forgot password with empty email
        objForgotPasswordPage.forgotPassword(TestForgotPasswordData.emptyEmail.getEmail());
        // Assert error message is displayed
        Assert.assertTrue(objForgotPasswordPage.checkErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objForgotPasswordPage.errorMessageContent().equals(TestMessageData.invalidEmailForgotPassword.getMessage()));
    }

    @Test
    // Test error message when attempting forgot password with invalid email
    public void testInvalidEmail() {
        // Attempt forgot password with empty email
        objForgotPasswordPage.forgotPassword(TestForgotPasswordData.invalidEmail.getEmail());
        // Assert error message is displayed
        Assert.assertTrue(objForgotPasswordPage.checkErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objForgotPasswordPage.errorMessageContent().equals(TestMessageData.emptyEmailForgotPassword.getMessage()));
    }

    @Test
    // Test error message when attempting forgot password with non registered email
    public void testNonregisteredEmail() {
        // Attempt forgot password with empty email
        objForgotPasswordPage.forgotPassword(TestForgotPasswordData.notregisteredEmail.getEmail());
        // Assert error message is displayed
        Assert.assertTrue(objForgotPasswordPage.checkErrorMessage());
        // Assert error message's content
        Assert.assertTrue(objForgotPasswordPage.errorMessageContent().equals(TestMessageData.nonregisteredEmail.getMessage()));

    }
}
