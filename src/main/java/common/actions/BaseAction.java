package common.actions;

import org.openqa.selenium.WebDriver;

public abstract class BaseAction {
    WebDriver driver;

    protected BaseAction(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void perform();
}
