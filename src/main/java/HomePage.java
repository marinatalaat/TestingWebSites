import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By myAccountLink = By.xpath("//a[contains(., 'My Account')]");
    private By signUpLink = By.xpath("//a[@class = 'dropdown-item tr']");
    private By logInLink = By.xpath("//a[@href = 'https://phptravels.net/login']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private void clickOnMyAccountLink(){
        driver.findElement(myAccountLink).click();
    }

    public SignUpPage navigateToSignUp(){
        clickOnMyAccountLink();
        driver.findElement(signUpLink).click();
        return new SignUpPage(driver);
    }

    public LogInPage navigateToLogIn(){
        clickOnMyAccountLink();
        driver.findElement(logInLink).click();
        return new LogInPage(driver);
    }
}
