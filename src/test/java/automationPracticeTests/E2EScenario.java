package automationPracticeTests;

import automationPractice.CartSummaryPage;
import automationPractice.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class E2EScenario {

    WebDriver driver;
    HomePage homePage;
    String shirtName = "Faded Short Sleeve T-Shirts";

    @BeforeClass
    public void setup(){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        GoHome();
        homePage = new HomePage(driver);

    }


    public void GoHome(){
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @Test
    public void E2ETestCase(){

        CartSummaryPage page = homePage.navigateToSignUpPage().SignIn("ITI41@gmail.com", "ITI41").navigateToTShirtsTab().addShirtToCart();
        String name = page.getShirtName();
        page.navigateToAddressesTab()
                .navigateToShippingTab().checkTermsOfServices().navigateToPaymentTab().choosePayByBankWire().confirmOrder().SignOut();
        Assert.assertTrue(name.equalsIgnoreCase(shirtName), "wrong T-Shirt Name");
    }

}
