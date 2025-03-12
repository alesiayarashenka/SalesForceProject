package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }
}
