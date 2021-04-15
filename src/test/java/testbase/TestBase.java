package testbase;

import common.PropertyLoader;
import common.driver.WebDriverFactory;
import data.testdata.TestLoginData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import pages.SigninPage;

import java.io.File;


public class TestBase implements ITestListener {
    protected WebDriver driver;
    private MainPage objMainPage;
    private SigninPage objSigninPage;

    @BeforeClass
    public void initial() throws Exception {
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--headless");
//        driver = new FirefoxDriver(options);
        String browserName =  PropertyLoader.loadProperty("browser.name");
        String url = PropertyLoader.loadProperty("site.url");
        driver = new WebDriverFactory(browserName).create();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void logIn() {
        // Create main page
        objMainPage = new MainPage(driver);
        // Select account link
        objMainPage.selectSigninButton();
        // Go to signin page
        objSigninPage = new SigninPage(driver);
        objSigninPage.signIn(PropertyLoader.loadProperty("user.username"), PropertyLoader.loadProperty("user.password"));
    }


    @AfterMethod
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getStatus());
        if (ITestResult.FAILURE==result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot)driver;
                String path = "/tmp/selenium/" + this.getClass().getName() + ".png";
                File scrFile = ts.getScreenshotAs(OutputType.FILE);
                File destFile = new File(path);
                FileUtils.copyFile(scrFile, destFile);
                System.out.println("write screenshot at " + path);
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
    }
}
