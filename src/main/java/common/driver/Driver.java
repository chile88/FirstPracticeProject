package common.driver;

import org.openqa.selenium.WebDriver;

public abstract class Driver {
    protected WebDriver webdriver;

    public WebDriver get() {
        return webdriver; // new Driver();
    }
}
