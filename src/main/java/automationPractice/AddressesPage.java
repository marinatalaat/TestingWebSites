package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddressesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public ShippingPage navigateToShippingTab(){
        driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(text(),'Shipping')]")));

        return new ShippingPage(driver);
    }
}
