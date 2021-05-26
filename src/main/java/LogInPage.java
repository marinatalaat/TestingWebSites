import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private WebDriver driver;
    private By userEmailField = By.xpath("//input[@name='username']");
    private By userPasswordField =By.xpath("//input[@name='password']");
    private By logInButton = By.xpath("//button[contains(., 'Login')]");

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public ProfilePage logIn(String email, String password){
        driver.findElement(userEmailField).sendKeys(email);
        driver.findElement(userPasswordField).sendKeys(password);
        driver.findElement(logInButton).click();

        return new ProfilePage(driver);
    }


}
