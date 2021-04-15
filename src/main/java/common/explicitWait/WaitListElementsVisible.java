package common.explicitWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WaitListElementsVisible extends Wait<List<WebElement>> {
    List<WebElement> listElement;

    public WaitListElementsVisible(WebDriver driver, List<WebElement> listElement){
        super(driver);
        this.listElement = listElement;

    }

    public List<WebElement> waitUntil() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listElement));

        return listElement;
    }
}
