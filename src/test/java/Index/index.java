package Index;


import Pages.searchBox;
import Pages.shoppinCart;
import com.sun.jdi.event.ThreadDeathEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.example.configuration;

import static org.testng.AssertJUnit.assertEquals;
import Pages.loginPage;
import Pages.singOut;

public class index {

    public WebDriver driver;
    private configuration configure;



    @BeforeTest
    public void setup(){
        configure = new configuration();
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","/Users/ankitsharma/Desktop/JAVA_Testing/Sellenium Testing/src/main/resources/chromedriver");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void homePage() throws InterruptedException {
        driver.get(configure.getWebsiteUrl());
        String exTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String acTitle = driver.getTitle();
        Thread.sleep( 2000);
        assertEquals(exTitle,acTitle);
    }

    @Test(priority = 2)
    public void loginPage(){
        loginPage login = new loginPage(driver);
        boolean logged = login.loginAccount(configure.getUserName(), configure.getPassWord());
        if(logged){
            System.out.println("user is successfully logged in");
        }else{
            System.out.println("user can not logged in");
        }
    }

    @Test(priority = 3)
    public void searchBox()throws InterruptedException{
        searchBox search = new searchBox(driver);
        if(search.checkSearchBox("Nike Air Jordan")){
            System.out.println("Search box is working fine");
        }
        else {
            System.out.println("Search box is not working fine");
        }

        driver.navigate().to("https://www.amazon.in/");
    }



    @Test(priority = 4)
    public void addToCart() throws InterruptedException {
        shoppinCart shopping = new shoppinCart(driver);
        if(shopping.addToCartFunction()){
            System.out.println("Reached to CheckOut page");
        }
        else {
            System.out.println("Failed to reach Checkout page ");
        }

        driver.navigate().to("https://www.amazon.in/");

    }

    @Test(priority = 5)
    public void singOut() throws  InterruptedException{
        singOut sigout = new singOut(driver);

        if(sigout.signOutButton()){
            System.out.println("Log out done by testing");
        }
        else {
            System.out.println("failed to signout");
        }

        Thread.sleep(3000);
        driver.quit();

    }

}
