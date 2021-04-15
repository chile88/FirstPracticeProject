package common.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitElementVisible extends Wait<WebElement> {
    WebElement element;

    public WaitElementVisible(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
    }

    public WaitElementVisible(WebDriver driver, By locator) {
        this(driver, driver.findElement(locator));
    }

    public WebElement waitUntil() {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
