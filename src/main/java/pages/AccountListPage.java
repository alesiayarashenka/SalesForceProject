package pages;

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
}
