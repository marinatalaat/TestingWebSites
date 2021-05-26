package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public PaymentPage choosePayByBankWire(){
        driver.findElement(By.className("bankwire")).click();
        return new PaymentPage(driver);
    }

    public PaymentPage confirmOrder(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(text(),'Order summary')]")));
        driver.findElement(By.xpath("//button/span[contains(text(),'I confirm my order')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/strong[contains(text()"+
                ",'Your order will be sent as soon as we receive payment.')]")));

        return new PaymentPage(driver);
    }

    public void SignOut(){
        driver.findElement(By.xpath("//div/a[@class='logout']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(text(),'Authentication')]")));
    }
}
