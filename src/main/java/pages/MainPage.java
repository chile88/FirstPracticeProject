package pages;

import common.explicitWait.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class MainPage {
    WebDriver driver;

    //Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Locators
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signIn;

    @FindBy(xpath = "//a[@title = 'Log me out']")
    WebElement signOut;

    @FindBy(xpath = "//a[@title = 'View my customer account']//span")
    WebElement customerAccount;

    @FindBy(id = "contact-link")
    WebElement contactUs;

    @FindBy(id = "search_query_top")
    WebElement searchTextBox;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(css = ".menu-content>li>a[title='Women']")
    WebElement womenTab;

    @FindBy(css = ".menu-content>li>a[title='Dresses']")
    WebElement dressesTab;

    @FindBy(css = ".menu-content>li>a[title='T-shirts']")
    WebElement tShirtsTab;

    @FindBy(css = ".menu-content>li:nth-child(1) li>a")
    List<WebElement> categoriesUnderTab1;

    @FindBy(css = ".menu-content>li:nth-child(2) li>a")
    List<WebElement> categoriesUnderTab2;

    @FindBy(css = ".menu-content>li:nth-child(3) li>a")
    List<WebElement> categoriesUnderTab3;


    // Actions
    public boolean checkSigninButton() {
        return signIn.isDisplayed();
    }

    public boolean checkSignoutButton() {
        return signOut.isDisplayed();
    }

    public boolean checkCustomerAccount() {
        return customerAccount.isDisplayed();
    }

    public String getCustomerAccountContent() {
        return customerAccount.getText();
     }

    public void selectSigninButton() {
        new WaitElementClickable(driver, signIn).waitUntil().click();
    }

    public void selectContactButton() {
        new WaitElementClickable(driver,contactUs).waitUntil().click();
    }

    public void selectSignoutButton() {
        new WaitElementClickable(driver, signOut).waitUntil().click();
    }

    public void selectCustomerAccount() {
        new WaitElementClickable(driver, customerAccount).waitUntil().click();
    }

    public void searchProduct(String searchText) {
        new WaitElementVisible(driver, searchTextBox).waitUntil().clear();
        searchTextBox.sendKeys(searchText);
        new WaitElementClickable(driver, searchButton).waitUntil().click();
    }

    public void hoverTab(int tabIndex) {
        Actions actions = new Actions(driver);
        switch (tabIndex) {
            case 1:
                actions.moveToElement(new WaitElementVisible(driver, womenTab).waitUntil()).perform();
                break;
            case 2:
                actions.moveToElement(new WaitElementVisible(driver, dressesTab).waitUntil()).perform();
                break;
            case 3:
                actions.moveToElement(new WaitElementVisible(driver, tShirtsTab).waitUntil()).perform();
                break;
        }
    }


    public void selectCategory(int tabIndex, String category) throws Exception {
        List<WebElement> categoriesList = null;
        switch (tabIndex) {
            case 1:
                new WaitElementExists(driver, By.cssSelector(".menu-content>li:nth-child(1) li>a")).waitUntil();
                categoriesList = categoriesUnderTab1;
//                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab1).waitUntil();
                break;
            case 2:
                new WaitElementExists(driver, By.cssSelector(".menu-content>li:nth-child(2) li>a")).waitUntil();
                categoriesList = categoriesUnderTab2;
//                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab2).waitUntil();
                break;
            case 3:
                new WaitElementExists(driver, By.cssSelector(".menu-content>li:nth-child(3) li>a")).waitUntil();
                categoriesList = categoriesUnderTab3;
//                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab3).waitUntil();
        }
        if (categoriesList != null) {
            for (int i = 0; i < categoriesList.size(); i++) {
                if (categoriesList.get(i).getAttribute("innerText").equals(category)) {
                    new WaitElementVisible(driver,categoriesList.get(i)).waitUntil().click();
                    break;
                }
            }
        }
        else {
            throw new Exception("Wrong data");
        }
    }
}
