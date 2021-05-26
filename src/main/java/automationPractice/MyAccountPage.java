package automationPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public MyAccountPage navigateToTShirtsTab(){
        driver.findElement(By.xpath("//div[@id='block_top_menu']"+
                "/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),'T-shirts')]")).click();

        return new MyAccountPage(driver);
    }

    public CartSummaryPage addShirtToCart(){

        String script = "arguments[0].scrollIntoView();";
        WebElement element = driver.findElement(By.className("left-block"));

       ((JavascriptExecutor) driver).executeScript(script,element);

        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.className("left-block"));
        actions.moveToElement(webElement).build().perform();

        driver.findElement(By.xpath("//a//span[contains(text(),'Add to cart')]")).click();

////div[@class='button-container']/a[@title='Proceed to checkout']
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-container']/a[@title='Proceed to checkout']")));

        driver.findElement(By.xpath("//div[@class='button-container']/a[@title='Proceed to checkout']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_title")));

        return new CartSummaryPage(driver);
    }
}
