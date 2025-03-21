package pages;

import objects.Contact;
import org.openqa.selenium.By;
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

    public String getFieldValueByNameForContact(String nameField, String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, nameField, name))).getText();
    }
}
