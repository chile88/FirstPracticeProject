package testcases;

import data.testdata.TestMessageData;
import data.testdata.TestRegisterData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.SigninPage;
import testbase.TestBase;

public class TestRegisterAccount extends TestBase {
    MainPage objMainPage;
    SigninPage objSigninPage;
    RegisterPage objRegisterPage;
    MyAccountPage objMyAccountPage;

    @Test
    public void testRegisterAccount() {
        // Create Main page
        objMainPage = new MainPage(driver);
        // Select sign in button
        objMainPage.selectSigninButton();
        // Create SignIn page
        objSigninPage = new SigninPage(driver);
        // Enter valid email and select create account button
        String email = TestRegisterData.validData.getEmail();
        objSigninPage.createAccountWithEmail(email);
        // Create Register page
        objRegisterPage = new RegisterPage(driver);

        // Enter data into Register page
        String firstname = TestRegisterData.validData.getFirstName1() ;
        String lastname = TestRegisterData.validData.getLastName1();
        objRegisterPage.selectTitle(TestRegisterData.validData.getTitle());
        objRegisterPage.enterFirstName1(firstname);
        objRegisterPage.enterLastName1(lastname);
        objRegisterPage.enterPassword(TestRegisterData.validData.getPassword());
        objRegisterPage.selectDayOfBirth(TestRegisterData.validData.getDayOfBirth());
        objRegisterPage.selectMonthOfBirth(TestRegisterData.validData.getMonthOfBirth());
        objRegisterPage.selectYearOfBirth(TestRegisterData.validData.getYearOfBirth());
        objRegisterPage.selectCheckbox1(TestRegisterData.validData.getCheckbox1());
        objRegisterPage.selectCheckbox2(TestRegisterData.validData.getCheckbox2());
        objRegisterPage.enterFirstName2(TestRegisterData.validData.getFirstName2());
        objRegisterPage.enterLastName2(TestRegisterData.validData.getLastName2());
        objRegisterPage.enterCompany(TestRegisterData.validData.getCompany());
        objRegisterPage.enterAddress1(TestRegisterData.validData.getAddress1());
        objRegisterPage.enterAddress2(TestRegisterData.validData.getAddress2());
        objRegisterPage.enterCity(TestRegisterData.validData.getCity());
        objRegisterPage.selectState(TestRegisterData.validData.getState());
        objRegisterPage.enterPostCode(TestRegisterData.validData.getPostCode());
        objRegisterPage.selectCountry(TestRegisterData.validData.getCountry());
        objRegisterPage.enterAdditionInformation(TestRegisterData.validData.getAdditionInformation());
        objRegisterPage.enterHomePhone(TestRegisterData.validData.getHomePhone());
        objRegisterPage.enterMobilePhone(TestRegisterData.validData.getMobilePhone());
        objRegisterPage.enterAliasAddress(TestRegisterData.validData.getAliasAddress());
        // Check email displayed correctly
        Assert.assertTrue(email.equals(objRegisterPage.getEmailValue()));
        // Select Submit button
        objRegisterPage.selectSubmitButton();
        // Assert customer account is displayed in Main page
        Assert.assertTrue(objMainPage.checkCustomerAccount());
        Assert.assertTrue(objMainPage.getCustomerAccountContent().equals(firstname + " " + lastname));
        // Create MyAccount page
        objMyAccountPage = new MyAccountPage(driver);
        // Check welcome message is displayed
        Assert.assertTrue(objMyAccountPage.checkWelcomeMessage());
        // Assert welcome message's content is correct
        Assert.assertTrue(objMyAccountPage.getWelcomeMessageContent().equals(TestMessageData.welcomeMessage.getMessage()));
    }
}
