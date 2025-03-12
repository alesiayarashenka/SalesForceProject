package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest(){
    Account account = new Account();
    account.setAccountName("account" + random.nextInt(10));
    account.setWebSite("website");
    account.setType("Investor");
    account.setPhone("375441000000");
    account.setDescription("nothing");
    loginPage.openPage(LOGIN_URL)
            .login(username, password);
    newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
            .createNewAccount(account);
    accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
    }
}

