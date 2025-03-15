package tests;

import objects.Account;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("375441000000");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setContactFirstName("Sarah");
        contact.setContactLastName("Connor");
        contact.setEmail(account.getAccountName() + "@mail.ru");
        contact.setTitle("Contact");
        contact.setDescription("nothing");
        contact.setPhone("375441000000");
        contact.setSalutation("Ms.");

        String nameInContactsList = contact.getContactFirstName() + " " + contact.getContactLastName();

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_LIST_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact, account);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(listPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(listPage.getExistAccountName(nameInContactsList), nameInContactsList);
        Assert.assertEquals(listPage.getExistAccountOwnerByAccountName(account.getAccountName()), "ayar");
        Assert.assertEquals(listPage.getExistPhoneNumberByAccountName(account.getAccountName()), contact.getPhone());
        Assert.assertEquals(listPage.getExistEmailByAccountName(account.getAccountName()), contact.getEmail());
    }

    @Test
    public void checkContactInViewTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("375441000000");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setContactFirstName("Sarah");
        contact.setContactLastName("Connor");
        contact.setEmail(account.getAccountName() + "@mail.ru");
        contact.setTitle("Contact");
        contact.setDescription("nothing");
        contact.setPhone("375441000000");
        contact.setSalutation("Ms.");

        String nameInCard = contact.getSalutation() + " " + contact.getContactFirstName() + " " + contact.getContactLastName();

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_LIST_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact, account);
        contactListPage
                .openPage(CONTACT_LIST_URL);
        listPage
                .clickOnAccountName(contact.getContactFirstName());
        Assert.assertEquals(listPage.getFieldValueByName("Account Name", account.getAccountName()), account.getAccountName());
        Assert.assertEquals(listPage.getFieldValueByName("Name", contact.getContactFirstName()), nameInCard);
        Assert.assertEquals(listPage.getFieldValueByName("Phone", contact.getPhone()), contact.getPhone());
        Assert.assertEquals(listPage.getFieldValueByName("Description", contact.getDescription()), contact.getDescription());
        Assert.assertEquals(listPage.getFieldValueByName("Title", contact.getTitle()), contact.getTitle());
        Assert.assertEquals(listPage.getFieldValueByName("Email", contact.getEmail()), contact.getEmail());
    }
}
