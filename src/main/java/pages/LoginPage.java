package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "Login")
    public WebElement loginButton;

    Waiter waiter = new Waiter();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public HomePage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        waiter.waitForPageLoaded();
        return new HomePage(driver);
    }
}
