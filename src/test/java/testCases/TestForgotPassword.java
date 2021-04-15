package testCases;

import common.SetUp;
import data.testdata.TestForgotPasswordData;
import data.testdata.TestMessageData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.MainPage;
import pages.SigninPage;

public class TestForgotPassword extends SetUp {
    MainPage objMainPage;
    SigninPage objSigninPage;
    ForgotPasswordPage objForgotPassPage;

    @Test
    public void testForgotPassword() {
        // Create Main page
        objMainPage = new MainPage(driver);
        // Select account link
        objMainPage.selectSigninButton();
        // Go to Signin page
        objSigninPage = new SigninPage(driver);
        // Select forgot password link
        objSigninPage.selectForgotPassword();
        // Go to Forgot Password page
        objForgotPassPage = new ForgotPasswordPage(driver);
        // Forgot password
        objForgotPassPage.forgotPassword(TestForgotPasswordData.validEmail.getEmail());
        // Assert confirmation message is displayed
        Assert.assertTrue(objForgotPassPage.checkConfirmationMessage());
        // Assert confirmation message's content is correctly
        String actualMessage = TestMessageData.confirmationMessage.getMessage()+TestForgotPasswordData.validEmail.getEmail();
        Assert.assertTrue(objForgotPassPage.confirmationMesssageContent().equals(actualMessage));
    }

}
