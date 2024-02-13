package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class singOut {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement homebox;

    @FindBy(xpath = "//a[@id='nav-item-signout']")
    private WebElement singOut;

    @FindBy(xpath = "//a[@id='nav-item-signout']")
    private WebElement signOutLink;

    public singOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean signOutButton(){
        try {

            Actions actions = new Actions(driver);
            actions.moveToElement(homebox).perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signOutLink));

            singOut.click();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
