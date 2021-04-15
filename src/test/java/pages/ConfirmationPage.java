package pages;

import common.explicitWait.WaitElementVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmationPage {
    WebDriver driver;

    // Constructor
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = "div.box")
    WebElement confirmBox;

    public String getConfirmCode() {
        new WaitElementVisible(driver, confirmBox).waitUntil();
        String content = confirmBox.getText();
        String text1 = "order reference ";
        String text2 = " in the subject of your bank wire";
        int index1 = content.indexOf(text1)+ text1.length();
        int index2 = content.indexOf(text2);
//        String a = content.replace("Your order on My Store is complete.\n" +
//                "Please send us a bank wire with\n" +
//                "- Amount $103.98\n" +
//                "- Name of account owner Pradeep Macharla\n" +
//                "- Include these details xyz\n" +
//                "- Bank name RTP\n" +
//                "- Do not forget to insert your order reference ", "");
//        String b = a.replace(" in the subject of your bank wire.\n" +
//                "An email has been sent with this information.\n" +
//                "Your order will be sent as soon as we receive payment.\n" +
//                "If you have questions, comments or concerns, please contact our expert customer support team. .", "");
//        Pattern confirmPattern = Pattern.compile("Do not forget to insert your order reference ([A-Z]+) in the subject of your bank wire");
//        Matcher matches = confirmPattern.matcher(content);
//        return matches.group(1);
        return content.substring(index1, index2);
    }
}
