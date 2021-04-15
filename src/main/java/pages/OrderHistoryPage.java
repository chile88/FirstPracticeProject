package pages;

import common.actions.GetCurrentDate;
import common.explicitWait.WaitListElementsVisible;
import data.definition.HistoryRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import java.util.List;

public class OrderHistoryPage {
    WebDriver driver;

    // Constructor
    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = "table[id = 'order-list'] tbody .color-myaccount")
    List<WebElement> orderReferenceList;

    @FindBy(css = "table[id = 'order-list'] tbody .history_date")
    List<WebElement> dateList;

    @FindBy(css= "table[id = 'order-list'] tbody .price")
    List<WebElement> priceList;

    // Actions

    public HistoryRecord getData(int i){
        new WaitListElementsVisible(driver, orderReferenceList);
        new WaitListElementsVisible(driver, priceList);
        new WaitListElementsVisible(driver, dateList);
        HistoryRecord data = new HistoryRecord()
                .setOrderReference(orderReferenceList.get(i).getText())
                .setDate(dateList.get(i).getText())
                .setPrice(priceList.get(i).getText());
        return data;
    }

    public boolean compareToCurrentDate( int i) {
        return dateList.get(i).getText().equals(new GetCurrentDate().getCurrentDate("MM/dd/yyy"));
    }







}
