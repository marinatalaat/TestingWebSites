import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpAndLogInTests extends BaseTest{

    String FName = "fname";
    String LName = "Lname";
    String phone = "1234567890";
    String email = FName+"la23"+"@"+LName+".com";
    String pass = "123456";

    @Test(priority = 1)
    public void testSignUp(){
    ProfilePage profile = homePage.navigateToSignUp().signUp(FName, LName, phone, email, pass);
    wait.until(ExpectedConditions.presenceOfElementLocated(profile.userNameLocator()));
    String userName = profile.getLoggedUserName();
    Assert.assertEquals(userName, "Hi, "+FName+" "+LName, "USER NAME IS INCORRECT");
    profile.logOut();
    }

    @Test (priority = 2)
    public void testLogIn(){
        ProfilePage profile = homePage.navigateToLogIn().logIn(email, pass);
        wait.until(ExpectedConditions.presenceOfElementLocated(profile.userNameLocator()));
        String userName = profile.getLoggedUserName();
        Assert.assertEquals(userName, "Hi, "+FName+" "+LName, "USER NAME IS INCORRECT");
        profile.logOut();
    }
}
