package common.explicitWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Wait<E> {
    protected WebDriverWait wait;
    protected WebDriver driver;

    protected Wait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }

    abstract public E waitUntil();
}
