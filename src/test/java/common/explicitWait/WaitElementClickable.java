package common.explicitWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitElementClickable extends Wait<WebElement> {
    WebElement element;

    public WaitElementClickable(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
    }

    public WebElement waitUntil() {
        new WaitElementVisible(driver, element).waitUntil();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

}
