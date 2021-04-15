package common.driver;

import common.PropertyLoader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver extends Driver {

    public FirefoxWebDriver() {
        super();
        FirefoxOptions option = new FirefoxOptions();
        if (PropertyLoader.loadProperty("headlessmode").equals("true")){
            option.addArguments("--headless");
        }
        webdriver = new FirefoxDriver(option);
    }
}
