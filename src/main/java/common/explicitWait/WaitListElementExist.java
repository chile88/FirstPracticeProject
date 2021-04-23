package common.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WaitListElementExist extends Wait<List<WebElement>>{
    By locator;

    public WaitListElementExist(WebDriver driver, By locator) {
        super(driver);
        this.locator = locator;
    }

    public List<WebElement> waitUntil() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }
}
