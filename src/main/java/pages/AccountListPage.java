package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage{

    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String PHONE_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, accountName))).getText();
    }

    public AccountPage clickOnAccountName(String accountName) {
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).click();
        return new AccountPage(driver);
    }
}
