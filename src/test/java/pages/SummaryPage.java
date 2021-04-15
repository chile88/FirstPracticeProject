package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    WebDriver driver;

    //Constructor
    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = ".first_item .cart_description .product-name a")
   WebElement productName;

    @FindBy(css = ".first_item .cart_description small a")
    WebElement productAttributes;

    @FindBy(css = ".first_item .cart_unit .price span")
    WebElement unitPrice;

    @FindBy(css = ".first_item .cart_quantity .cart_quantity_input")
    WebElement quantityWanted;

    @FindBy(css = ".first_item .cart_total .price")
    WebElement totalProductsPrice;

    @FindBy(id = "total_shipping")
    WebElement totalShippingFee;

    @FindBy(id = "total_tax")
    WebElement totalTax;

    @FindBy(id = "total_price")
    WebElement totalPrice;

    @FindBy(css = ".cart_navigation [title='Proceed to checkout']")
    WebElement proccedToCheckOut;

    // Actions

    public String getProductName() {
        return new WaitElementVisible(driver, productName).waitUntil().getText();
    }

    public  String getProductAttributes() {
        return new WaitElementVisible(driver, productAttributes).waitUntil().getText();
    }

    public String getQuantityWanted() {
        return new WaitElementVisible(driver, quantityWanted).waitUntil().getText();
    }

    public String getUnitPrice() {
        return new WaitElementVisible(driver, unitPrice).waitUntil().getText();
    }

    public String getTotalProductPrice() {
        return new WaitElementVisible(driver, totalProductsPrice).waitUntil().getText();
    }

    public String getTotalShippingFee() {
        return new WaitElementVisible(driver, totalShippingFee).waitUntil().getText();
    }

    public String getTotalTax() {
        return new WaitElementVisible(driver, totalTax).waitUntil().getText();
    }

    public String getTotalPrice() {
        return new WaitElementVisible(driver, totalPrice).waitUntil().getText();
    }

    public boolean checkTotalPrice() {
        Double totalProductPrice = Double.parseDouble(this.getTotalProductPrice().replace("$", ""));
        Double totalShippingFee = Double.parseDouble(this.getTotalShippingFee().replace("$", ""));
        Double totalTax = Double.parseDouble(this.getTotalTax().replace("$", ""));
        Double totalPrice = Double.parseDouble(this.getTotalPrice().replace("$", ""));
        return (totalPrice == totalProductPrice+totalShippingFee+totalTax);
    }

    public void selectProccedToCheckOut() {
        new WaitElementClickable(driver, proccedToCheckOut).waitUntil().click();
    }

}
