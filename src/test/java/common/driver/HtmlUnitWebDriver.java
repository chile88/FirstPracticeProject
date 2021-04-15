package common.driver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitWebDriver extends Driver{

    public HtmlUnitWebDriver() {
        super();
        webdriver = new HtmlUnitDriver();
    }
}
