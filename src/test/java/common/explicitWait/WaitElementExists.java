package common.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitElementExists extends Wait<WebElement> {
    By locator;

    public WaitElementExists(WebDriver driver, By locator) {
        super(driver);
        this.locator = locator;
    }

    @Override
    public WebElement waitUntil() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
