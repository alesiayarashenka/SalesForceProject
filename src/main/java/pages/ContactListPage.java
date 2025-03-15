package pages;

import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class ContactListPage extends ListPage {

    Waiter waiter = new Waiter();

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url) {
        waiter.waitForPageLoaded();
        driver.get(url);
        return this;
    }
}
