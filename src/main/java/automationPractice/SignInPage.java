package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;
    String userName = "ITI QATesting";

    public SignInPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public MyAccountPage SignIn(String email, String password){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='account']//span[contains(text(),'"+userName+"')]")));

        return new MyAccountPage(driver);
    }
}
