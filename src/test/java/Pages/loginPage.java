package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriver driver;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement signInButton;

    @FindBy(id = "ap_email")
    private WebElement emailInput;

    @FindBy(className = "a-button-input")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean loginAccount(String userName, String password) {
        try {
            signInButton.click();
            waitForVisibility(emailInput,2);
            emailInput.sendKeys(userName);
            continueButton.click();
            waitForVisibility(passwordInput,2);
            passwordInput.sendKeys(password);
            signInSubmitButton.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void waitForVisibility(WebElement element, int timeoutInSeconds) {
        Duration customTimeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, customTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
