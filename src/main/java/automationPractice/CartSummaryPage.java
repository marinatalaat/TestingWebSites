package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartSummaryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public String getShirtName(){
        return driver.findElement(By.xpath("//tr[@id='product_1_1_0_458188']/td[@class='cart_description']/p/a")).getText();
    }

    public AddressesPage navigateToAddressesTab(){
        driver.findElement(By.xpath("//p/a/span[contains(text(),'Proceed to checkout')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(text(),'Addresses')]")));

        return new AddressesPage(driver);

    }
}
