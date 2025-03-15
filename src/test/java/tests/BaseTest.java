package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestConstants, IConstants {

    WebDriver driver;
    AccountListPage accountListPage;
    HomePage homePage;
    NewAccountModalPage newAccountModalPage;
    LoginPage loginPage;
    NewContactModalPage newContactModalPage;
    ContactListPage contactListPage;
    ListPage listPage;

    public void initPages() {
        accountListPage = new AccountListPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
        contactListPage = new ContactListPage(driver);
        listPage = new ListPage(driver);
    }

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        initPages();
    }
}

