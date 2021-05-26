import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;

    @BeforeClass
    public void SetUp(){
        //System.setProperty("webdriver.chrome.driver" , "resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver , 20);
        goHome();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://phptravels.net/home");
    }


    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //Files.move(screenshot , new File("resources\\screenshots\\" + result.getName() + ".png"));
            System.out.println("Screenshot taken:" + screenshot.getAbsolutePath());
            Files.move(screenshot, new File("C:\\Users\\iti\\IdeaProjects\\testautomationu\\phpTravels\\src\\main\\resources\\screenshots\\" + result.getName() + ".png"));
        }
    }

}
