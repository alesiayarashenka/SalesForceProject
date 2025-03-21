package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();

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
        softAssert.assertEquals(listPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(listPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
        softAssert.assertEquals(listPage.getExistAccountOwnerByAccountName(account.getAccountName()), "ayar");
        softAssert.assertAll();
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
        softAssert.assertEquals(accountListPage.getFieldValueByNameForAccount("Account Name", account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(accountListPage.getFieldValueByNameForAccount("Website", account.getWebSite()), account.getWebSite());
        softAssert.assertEquals(accountListPage.getFieldValueByNameForAccount("Type", account.getType()), account.getType());
        softAssert.assertEquals(accountListPage.getFieldValueByNameForAccount("Phone", account.getPhone()), account.getPhone());
        softAssert.assertEquals(accountListPage.getFieldValueByNameForAccount("Description", account.getDescription()), account.getDescription());
        softAssert.assertAll();
    }
}

