package pages;

import common.explicitWait.WaitElementVisible;
import common.explicitWait.WaitListElementsVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchPage {
    WebDriver driver;
    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(css = ".product_list  .product-container .product-name")
    List<WebElement> productList;

    @FindBy(css = ".alert-warning")
    WebElement noResultMessage;

    @FindBy(css = ".heading-counter")
    WebElement counterMessage;

    // Actions
    public int getNumberOfResult() {
        String message = new WaitElementVisible(driver, counterMessage).waitUntil().getText();
        return Integer.parseInt(message.split(" ")[0]);
    }

    public int getProductListSize() {
        return new WaitListElementsVisible(driver, productList).waitUntil().size();
    }

    public String getNoResulstMessageContent() {
        return new WaitElementVisible(driver, noResultMessage).waitUntil().getText();
    }

    public boolean checkNoResultsMessage() {
        return new WaitElementVisible(driver, noResultMessage).waitUntil().isDisplayed();
    }

    public boolean checkSearchResult(String searchText) {
        boolean result = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getText().contains(searchText)) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }


}
