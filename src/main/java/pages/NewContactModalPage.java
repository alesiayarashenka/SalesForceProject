package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

public class NewContactModalPage extends BasePage {

    private static final String ACCOUNT_SELECT_ACCOUNT_XPATH =
            "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";

    @FindBy(xpath = "//*[@name='SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    Waiter waiter = new Waiter();

    Account account = new Account();

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        waiter.waitForPageLoaded();
        driver.get(url);
        return this;
    }

    public void contactSelectAccount(String option) {
        new Input(driver, "Account Name").writeTextInDropdownField(option);
        driver.findElement(By.xpath(String.format(ACCOUNT_SELECT_ACCOUNT_XPATH, option))).click();
    }

    public void createNewContact(Contact contact, Account account) {
        new Dropdown(driver, "Salutation").accountSelectOption(contact.getSalutation());
        new Input(driver, "First Name").writeTextToInput(contact.getContactFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getContactLastName());
        contactSelectAccount(account.getAccountName());
        new Input(driver, "Title").writeTextToInput(contact.getTitle());
        new Input(driver, "Description").writeTextToTextarea(contact.getDescription());
        new Input(driver, "Phone").writeTextToInput(contact.getPhone());
        new Input(driver, "Email").writeTextToInput(contact.getEmail());
        new Button(driver).clickButton(saveButton);
        waiter.waitForPageLoaded();
    }
}
