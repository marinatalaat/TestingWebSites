import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;
    private By loggedUserName = By.xpath("//div[@class='col-md-8']");
    private By logOutDropDownMenu = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
    private By logOutLink = By.xpath("//a[contains(.,'Logout')]");

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public By userNameLocator(){
        return loggedUserName;
    }
    public String getLoggedUserName(){
        return driver.findElement(loggedUserName).getText();
    }

    public void logOut(){
        driver.findElement(logOutDropDownMenu).click();
        driver.findElement(logOutLink).click();
    }

}
