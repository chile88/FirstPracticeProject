package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import common.explicitWait.WaitElementNotExist;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartProductPage {
    WebDriver driver;
    // Constructor
    public CartProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "layer_cart_product_title")
    WebElement productName;

    @FindBy(id = "layer_cart_product_attributes")
    WebElement productAttributes;

    @FindBy(id = "layer_cart_product_quantity")
    WebElement productQuantity;

    @FindBy(id = "layer_cart_product_price")
    WebElement productPrice;

    @FindBy(css = "a[title='Proceed to checkout']")
    WebElement proceedToCheckOut;

    @FindBy(css = "span[title='Continue shopping']")
    WebElement continueShopping;

    // Actions
    public String getProductName() {
        return new WaitElementVisible(driver, productName).waitUntil().getText();
    }

    public void selectProceedToCheckOut() {
        new WaitElementNotExist(driver, By.cssSelector(".fancybox-overlay")).waitUntil();
        new WaitElementClickable(driver, proceedToCheckOut).waitUntil().click();
    }

    public void selectContinueShopping() {
        new WaitElementClickable(driver, continueShopping).waitUntil().click();
    }

    public String getProductAttributes() {
        return new WaitElementVisible(driver, productAttributes).waitUntil().getText();
    }

    public String getProductQuantity() {
        return new WaitElementVisible(driver, productQuantity).waitUntil().getText();
    }

    public String getProductPrice() {
        return new WaitElementVisible(driver, productPrice).waitUntil().getText();
    }



}
