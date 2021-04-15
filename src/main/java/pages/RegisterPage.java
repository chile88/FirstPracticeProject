package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    //Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(id = "id_gender1")
    WebElement titleOption1;

    @FindBy(id = "id_gender2")
    WebElement titleOption2;

    @FindBy(id = "customer_firstname")
    WebElement firstName1;

    @FindBy(id = "customer_lastname")
    WebElement lastName1;

    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(id = "passwd")
    WebElement passWord;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement checkbox1;

    @FindBy(id = "optin")
    WebElement checkbox2;

    @FindBy(id = "firstname")
    WebElement firstName2;

    @FindBy(id = "lastname")
    WebElement lastName2;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement states;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "id_country")
    WebElement countries;

    @FindBy(id = "other")
    WebElement additionalInfomation;

    @FindBy(id = "phone")
    WebElement homePhone;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    WebElement submit;

    public void selectTitle(String title) {
        if (title == "1") {
            new WaitElementVisible(driver, titleOption1).waitUntil().click();
        }
        else if(title == "2") {
            new WaitElementVisible(driver, titleOption2).waitUntil().click();
        }

    }

    public void enterFirstName1(String firstName) {
        new WaitElementVisible(driver, firstName1).waitUntil().clear();
        firstName1.sendKeys(firstName);
    }

    public void enterLastName1(String lastName) {
        new WaitElementVisible(driver, lastName1).waitUntil().clear();
        lastName1.sendKeys(lastName);
    }

    public String getEmailValue() {
        return new WaitElementVisible(driver, emailAddress).waitUntil().getAttribute("value");
    }

    public void enterPassword(String password) {
        new WaitElementVisible(driver, passWord).waitUntil().clear();
        passWord.sendKeys(password);
    }

    public void selectDayOfBirth(String day) {
        Select selectDay = new Select(days);
        selectDay.selectByValue(day);
    }

    public void selectMonthOfBirth(String month) {
        Select selectMonth = new Select(months);
        selectMonth.selectByValue(month);
    }

    public void selectYearOfBirth(String year) {
        Select selectYear = new Select(years);
        selectYear.selectByValue(year);
    }

    public void selectCheckbox1(boolean option) {
        if (option == true && checkbox1.isSelected() == false ) {
            checkbox1.click();
        }
    }

    public void selectCheckbox2(boolean option) {
        if (option == true && checkbox2.isSelected() == false) {
            checkbox2.click();
        }
    }

    public void enterFirstName2(String firstName) {
        new WaitElementVisible(driver, firstName2).waitUntil().clear();
        firstName2.sendKeys(firstName);
    }

    public void enterLastName2(String lastName) {
        new WaitElementVisible(driver, lastName2).waitUntil().clear();
        lastName2.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        new WaitElementVisible(driver, this.company).waitUntil().clear();
        this.company.sendKeys(company);

    }

    public void enterAddress1(String address) {
        new WaitElementVisible(driver, address1).waitUntil().clear();
        address1.sendKeys(address);
    }

    public void enterAddress2(String address) {
        new WaitElementVisible(driver, address2).waitUntil().clear();
        address2.sendKeys(address);
    }

    public void enterCity(String city) {
        new WaitElementVisible(driver, this.city).waitUntil().clear();
        this.city.sendKeys(city);
    }

    public void selectState(String state) {
        Select selectState = new Select(states);
        selectState.selectByVisibleText(state);
    }

    public void enterPostCode(String postcode) {
        new WaitElementVisible(driver, postCode).waitUntil().clear();
        postCode.sendKeys(postcode);
    }

    public void selectCountry(String country) {
        Select selectCountry = new Select(countries);
        selectCountry.selectByVisibleText(country);
    }

    public void enterAdditionInformation(String additionInfo) {
        new WaitElementVisible(driver, additionalInfomation).waitUntil().clear();
        additionalInfomation.sendKeys(additionInfo);
    }

    public void enterHomePhone(String number) {
        new WaitElementVisible(driver, homePhone).waitUntil().clear();
        homePhone.sendKeys(number);
    }

    public void enterMobilePhone(String number) {
        new WaitElementVisible(driver, mobilePhone).waitUntil().clear();
        mobilePhone.sendKeys(number);
    }

    public void enterAliasAddress(String address) {
        new WaitElementVisible(driver, aliasAddress).waitUntil().clear();
        aliasAddress.sendKeys(address);
    }

    public void selectSubmitButton() {
        new WaitElementClickable(driver, submit).waitUntil().click();
    }

}
