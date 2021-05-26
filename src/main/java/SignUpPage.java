import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By phoneField = By.xpath("//input[@name='phone']");
    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By confirmPasswordField = By.xpath("//input[@name='confirmpassword']");
    private By signUpButton = By.xpath("//button[contains(.,'Sign Up')]");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }



    public ProfilePage signUp(String FName, String LName, String phone, String email, String password){

        driver.findElement(firstNameField).sendKeys(FName);
        driver.findElement(lastNameField).sendKeys(LName);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(signUpButton).click();

        return new ProfilePage(driver);
    }


}
