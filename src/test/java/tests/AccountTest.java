package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("375441000000");
        account.setDescription("nothing");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_LIST_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(listPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(listPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
        Assert.assertEquals(listPage.getExistAccountOwnerByAccountName(account.getAccountName()), "ayar");
    }

    @Test
    public void checkAccountInViewTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("375441000000");
        account.setDescription("nothing");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_LIST_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage
                .openPage(ACCOUNT_LIST_URL);
        listPage.
                clickOnAccountName(account.getAccountName());
        Assert.assertEquals(listPage.getFieldValueByName("Account Name", account.getAccountName()), account.getAccountName());
        Assert.assertEquals(listPage.getFieldValueByName("Website", account.getWebSite()), account.getWebSite());
        Assert.assertEquals(listPage.getFieldValueByName("Type", account.getType()), account.getType());
        Assert.assertEquals(listPage.getFieldValueByName("Phone", account.getPhone()), account.getPhone());
        Assert.assertEquals(listPage.getFieldValueByName("Description", account.getDescription()), account.getDescription());
    }
}

