package common.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitElementNotExist extends Wait<Void> {
    By locator;

    public WaitElementNotExist(WebDriver driver, By locator) {
        super(driver);
        this.locator = locator;
    }

    @Override
    public Void waitUntil() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
