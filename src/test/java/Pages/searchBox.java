package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class searchBox {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
    private WebElement searchButtom;

    public searchBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkSearchBox(String text) throws InterruptedException {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(searchBox));
            searchBox.clear();
            searchBox.sendKeys(text);
            searchButtom.click();
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 250);");
            String expectedTitle = "Amazon.in : Nike Air Jordan";
            Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Search results title mismatch");

            return true;
        }
        catch (Exception e){
            return false;
        }

    }


}
