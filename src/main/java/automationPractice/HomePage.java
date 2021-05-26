package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public HomePage navigateToHomePage(String url){
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return new HomePage(driver);
    }

    public SignInPage navigateToSignUpPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("login")));
        driver.findElement(By.className("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Already')]")));
        return new SignInPage(driver);
    }
}
