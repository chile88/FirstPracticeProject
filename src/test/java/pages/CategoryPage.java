package pages;

import common.actions.ActionScroll;
import common.explicitWait.WaitElementVisible;
import common.explicitWait.WaitListElementsVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    WebDriver driver;
    // Constructor
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = ".category-name")
    WebElement categoryName;

    @FindBy(css = ".heading-counter")
    WebElement headingCounter;

    @FindBy(css = ".product_list .product-container .product-name")
    List<WebElement> productList;

    @FindBy(xpath = "//span[text()='Quick view']")
    List<WebElement> quickViewList;



    // Actions

    public String getCategoryName() {
        return new WaitElementVisible(driver, categoryName).waitUntil().getText().trim();
    }

    public int getNumberOfProduct() {
        String message = new WaitElementVisible(driver, headingCounter).waitUntil().getText();
        return Integer.parseInt(message.split(" ")[2]);
    }

    public int getProductListSize() {
        return new WaitListElementsVisible(driver, productList).waitUntil().size();
    }

    public void hoverProduct(int index) {
        Actions actions = new Actions(driver);
        new WaitListElementsVisible(driver, productList).waitUntil();
        new ActionScroll(driver, productList.get(index)).perform();
        actions.moveToElement(productList.get(index)).perform();
    }

    public void selectQuickView(int index) {
        new WaitElementVisible(driver, quickViewList.get(index)).waitUntil().click();

    }

}
