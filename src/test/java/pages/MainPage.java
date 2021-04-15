package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import common.explicitWait.WaitListElementsVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        new WaitElementVisible(driver, signIn).waitUntil().click();
    }

    public void selectContactButton() {
        new WaitElementVisible(driver,contactUs).waitUntil().click();
    }

    public void selectSignoutButton() {
        new WaitElementVisible(driver, signOut).waitUntil().click();
    }

    public void selectCustomerAccount() {
        new WaitElementVisible(driver, customerAccount).waitUntil().click();
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


    public void selectCategory(int tabIndex, String category) {
        List<WebElement> categoriesList = null;
        switch (tabIndex) {
            case 1:
                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab1).waitUntil();
                break;
            case 2:
                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab2).waitUntil();
                break;
            case 3:
                categoriesList = new WaitListElementsVisible(driver, categoriesUnderTab3).waitUntil();
        }
        if (categoriesList != null) {
            for (int i = 0; i < categoriesList.size(); i++) {
                if (categoriesList.get(i).getAttribute("innerText").equals(category)) {
                    categoriesList.get(i).click();
                    break;
                }
            }
        }
        else {
            System.out.println("Wrong data");
        }
    }
}
