package pages;

import objects.Contact;
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

    public String nameInContactsList(Contact contact){
        return contact.getContactFirstName() + " " + contact.getContactLastName();
    }

    public String nameInCard(Contact contact){
        return contact.getSalutation() + " " + contact.getContactFirstName() + " " + contact.getContactLastName();
    }
}
