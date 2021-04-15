package common.actions;

import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionScroll extends BaseAction {
    WebElement element;

    public ActionScroll(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
    }

    @Override
    public void perform() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WaitElementVisible(driver, element).waitUntil();
    }
}
