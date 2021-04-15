package pages;

import common.explicitWait.WaitElementClickable;
import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator
    @FindBy(css = ".primary_block [itemprop='name']")
    WebElement productName;

    @FindBy(id = "our_price_display")
    WebElement unitPrice;

    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(id = "group_1")
    WebElement sizes;

    @FindBy(css = ".color_pick.selected")
    WebElement selectedColor;


    @FindBy(xpath = "//button[@name='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
    WebElement iframeProduct;


    // Actions
    public void enterQuantityWanted(String number) {
        new WaitElementVisible(driver, quantityWanted).waitUntil().clear();
        quantityWanted.sendKeys(number);
    }

    public void selectSize(String size) {
        //Select selectSize = new Select(new WaitElementVisible(driver, sizes).waitUntil());
        Select selectSize = new Select(sizes);
        selectSize.selectByVisibleText(size);
    }

    public void selectSubmitButton() {
        new WaitElementClickable(driver, submitButton).waitUntil().click();
    }

    public String getSelectedColor() {
        return new WaitElementVisible(driver, selectedColor).waitUntil().getAttribute("title").toString();
    }

    public String getPrice(int quantityWanted) {
        String price = "$";
        Double total = Double.parseDouble(new WaitElementVisible(driver, unitPrice).waitUntil().getText().replace("$", ""))*quantityWanted;
        return price.concat(total.toString());
    }

    public String getProductName() {
        return new WaitElementVisible(driver, productName).waitUntil().getText();
    }

    public void switchToIframe() {
        driver.switchTo().frame(new WaitElementVisible(driver, iframeProduct).waitUntil());
    }

}
