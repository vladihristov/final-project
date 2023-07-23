package finalProj.tests;

import finalProj.pages.HeaderLoggedIn;
import finalProj.pages.HeaderUnauthenticated;
import finalProj.pages.Login;
import finalProj.pages.NewPostPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewPostTest {
    private WebDriver driver;
    private final String homeURL = "http://training.skillo-bg.com/";
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(homeURL);
    }
    @Test
    public void newPostTest(){
        System.out.println("Go To Login Page");
        HeaderUnauthenticated headerNotLoggedIn = new HeaderUnauthenticated(driver);
        headerNotLoggedIn.goToLogin();

        System.out.println("Enter login credentials and login");
        Login login = new Login(driver);
        login.enterUserNameOrEmail("dyuqweyu");
        login.enterPass("dyuqweyu");
        login.clickSignInBtn();

        System.out.println("Go to the New Post page");
        HeaderLoggedIn headerLoggedUser = new HeaderLoggedIn(driver);
        headerLoggedUser.goToNewPost();

        System.out.println("Verify the user is on the New Post page");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.checkURLNewPost();

        System.out.println("Upload an image");
        newPostPage.uploadImage();
    }
}
