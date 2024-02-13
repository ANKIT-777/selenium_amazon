package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.time.Duration;


public class shoppinCart {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
    private WebElement searchButtom;
    @FindBy(xpath = "//button[@class='a-button-text']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToBuyButton;
    @FindBy(css = "#nav-cart.nav-a.nav-a-2")
    private WebElement cartButton;

    public shoppinCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean addToCartFunction() throws InterruptedException {
        try {


            searchBox.sendKeys("Iphone 15 pro max");
            searchButtom.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 250);");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

            addToCartButton.click();

            wait.until(ExpectedConditions.elementToBeClickable(cartButton));
            cartButton.click();

            proceedToBuyButton.click();

            String exTitle = "Amazon.in Shopping Cart";
            Assert.assertTrue(exTitle.contains(driver.getTitle()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }



}
