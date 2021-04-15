package testCases;

import data.testdata.TestLoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SigninPage;
import testbase.TestBase;

public class TestLogin extends TestBase {
    MainPage objMainPage;
    SigninPage objSigninPage;

    @Test
    public void testLogin() {
        // Create main page
        objMainPage = new MainPage(driver);
        // Select account link
        objMainPage.selectSigninButton();
        // Go to signin page
        objSigninPage = new SigninPage(driver);
        // Sign in
        objSigninPage.signIn(TestLoginData.correctData.getEmail(), TestLoginData.correctData.getPassword());
        // Assert customer account is displayed on main page
        Assert.assertTrue(objMainPage.checkCustomerAccount());
        // Assert log out button is displayed on main page
        Assert.assertTrue(objMainPage.checkSignoutButton());
        // Sign out
        objMainPage.selectSignoutButton();
        // Assert SignIn button is displayed on main page
        Assert.assertTrue(objMainPage.checkSigninButton());
    }
}
