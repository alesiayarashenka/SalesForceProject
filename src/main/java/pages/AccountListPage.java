package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class AccountListPage extends ListPage {

    Waiter waiter = new Waiter();

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage openPage(String url) {
        waiter.waitForPageLoaded();
        driver.get(url);
        return this;
    }

    public String getFieldValueByNameForAccount(String nameField, String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, nameField, name))).getText();
    }
}
