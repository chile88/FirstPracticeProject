package common.driver;

import common.PropertyLoader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver extends Driver {
    // constructor
    public ChromeWebDriver() {
        super();
        ChromeOptions options = new ChromeOptions();
        if (PropertyLoader.loadProperty("headlessmode").equals("true")) {
            options.addArguments("--headless");
        }
        webdriver = new ChromeDriver(options);
    }
}
