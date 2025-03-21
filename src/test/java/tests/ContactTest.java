package tests;

import objects.Account;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ContactTest extends BaseTest {

    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();

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

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_LIST_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact, account);
        contactListPage.openPage(CONTACT_LIST_URL);
        softAssert.assertEquals(listPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(listPage.getExistAccountName(contactListPage.nameInContactsList(contact)), contactListPage.nameInContactsList(contact));
        softAssert.assertEquals(listPage.getExistAccountOwnerByAccountName(account.getAccountName()), "ayar");
        softAssert.assertEquals(listPage.getExistPhoneNumberByAccountName(account.getAccountName()), contact.getPhone());
        softAssert.assertEquals(listPage.getExistEmailByAccountName(account.getAccountName()), contact.getEmail());
        softAssert.assertAll();
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
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Account Name", account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Name", contact.getContactFirstName()), contactListPage.nameInCard(contact));
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Phone", contact.getPhone()), contact.getPhone());
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Description", contact.getDescription()), contact.getDescription());
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Title", contact.getTitle()), contact.getTitle());
        softAssert.assertEquals(contactListPage.getFieldValueByNameForContact("Email", contact.getEmail()), contact.getEmail());
        softAssert.assertAll();
    }
}
