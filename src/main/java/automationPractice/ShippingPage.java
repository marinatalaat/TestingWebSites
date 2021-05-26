package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ShippingPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public ShippingPage checkTermsOfServices(){
        driver.findElement(By.id("cgv")).click();
        return new ShippingPage(driver);
    }


    public PaymentPage navigateToPaymentTab(){
        driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(text(),'Please choose your payment method')]")));

        return new PaymentPage(driver);
    }
}
