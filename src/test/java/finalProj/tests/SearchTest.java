package finalProj.tests;

import finalProj.pages.HeaderLoggedIn;
import finalProj.pages.HeaderUnauthenticated;
import finalProj.pages.Login;
import finalProj.pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest {
    private WebDriver driver;
    private final String homeURL = "http://training.skillo-bg.com/";
    private final String searchKeyWord = "test";
    int rowIndex = 0;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(homeURL);
    }
    @Test
    public void followUserAndOpenProfile() throws InterruptedException {
        System.out.println("Go To Login Page");
        HeaderUnauthenticated headerNotLoggedIn = new HeaderUnauthenticated(driver);
        headerNotLoggedIn.goToLogin();
        headerNotLoggedIn.verifyLoginUrl();

        System.out.println("Enter login credentials and login");
        Login login = new Login(driver);
        String username = "Vlad1TestAcc";
        String password = "7777777$aA";
        login.enterUserNameOrEmail(username);
        login.enterPass(password);
        login.clickSignInBtn();
        login.verifyUrlAfterLogin();

        System.out.println("Start searching and verify the search dropdown with results appears");
        HeaderLoggedIn headerLoggedIn = new HeaderLoggedIn(driver);
        headerLoggedIn.searchByKeyword(searchKeyWord);
        headerLoggedIn.verifyDropdownAppears();
        System.out.println("Check username and button text on a specified row by index");
        String searchDropdownUsernameText = headerLoggedIn.getUsernameByIndex(rowIndex);
        String searchDropdownBtnText = headerLoggedIn.getBtnTextByIndex(rowIndex);

        System.out.println("Follow the user");
        headerLoggedIn.followUserByIndex(rowIndex);
        headerLoggedIn.verifyDropdownAppears();
        ProfilePage profilePage = new ProfilePage(driver);
        System.out.println("Open the followed user and verify that the user is still followed on their profile page");
        //Since there are many toast messages when we unfollow a user the only working solution I found is to add unconditional wait in this form
        Thread.sleep(4000);
        headerLoggedIn.openSearchResultByIndex(rowIndex);

        System.out.println("Verify user profile page is opened");
        profilePage.verifyProfileUrl();

        System.out.println("Verify the user is the same as the one that is clicked. Verify the clicked Follow button is applied");
        String profilePageUsername = profilePage.getUsernameText();
        Assert.assertEquals(profilePageUsername, searchDropdownUsernameText, "The username is incorrect");
        Assert.assertNotEquals(profilePage.getFollowBtnText(), searchDropdownBtnText, "The follow button text is incorrect");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
