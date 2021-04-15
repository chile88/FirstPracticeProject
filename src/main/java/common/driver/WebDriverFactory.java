package common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {
    private String name;

    public WebDriverFactory(String name) {
        this.name = name;
    }

    public WebDriver create() throws Exception {
        if (name.equals("chrome")) {
            return new ChromeWebDriver().get();
        }
        else if (name.equals("firefox")) {
            return new FirefoxWebDriver().get();
        }
        else if (name.equals("htmlunit")) {
            return new HtmlUnitWebDriver().get();
        }

        throw new Exception("cannot find webdriver");
    }
}
