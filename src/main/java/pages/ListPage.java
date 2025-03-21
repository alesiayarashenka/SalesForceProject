package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class ListPage extends BasePage {

    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String PHONE_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String EMAIL_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//a[contains(@class,'emailuiFormattedEmail')]";
    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//*[contains(text(),'%s')]";

    Waiter waiter = new Waiter();

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public String getExistEmailByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(EMAIL_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public ListPage clickOnAccountName(String accountName) {
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).click();
        waiter.waitForPageLoaded();
        return this;
    }
}
