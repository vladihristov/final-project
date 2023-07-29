package finalProj.tests;

import finalProj.pages.HeaderUnauthenticated;
import finalProj.pages.HomePage;
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

//In this test we will verify that unauthenticated users can go to a profile page of users
public class OpenUserProfilePage {
    private WebDriver driver;
    private final String homeURL = "http://training.skillo-bg.com/";
    int index = 0;
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
    public void openProfilePageFromPost() throws InterruptedException {
        System.out.println("Verify there are posts on the Homepage");
        HomePage homePage = new HomePage(driver);
        homePage.waitPostsToAppear();
        System.out.println("Click on a username and verify it opens the 404 error page");
        homePage.clickUserName(index);
        homePage.verifyNotFoundUrl();

        System.out.println("Login with an account that has no posts. It is best if we have a special account only for this test");
        HeaderUnauthenticated headerUnauthenticated = new HeaderUnauthenticated(driver);
        headerUnauthenticated.goToLogin();
        headerUnauthenticated.verifyLoginUrl();
        Login login = new Login(driver);
        String username = "blabla101";
        String password = "7777777$aA";
        login.enterUserNameOrEmail(username);
        login.enterPass(password);
        login.clickSignInBtn();

        System.out.println("Verify we are on the correct page after login and wait for the posts to load");
        login.verifyUrlAfterLogin();
        homePage.waitPostsToAppear();

        System.out.println("Check and click on the Follow button");
        String homePostUsername = homePage.getPostUsernameText(index);
        String followBtnTxt = homePage.getPostFollowBtnText(index);
        homePage.clickFollowBtn(index);
        System.out.println("Click on the username to go to the User Profile page");
        //Since there are many toast messages when we unfollow a user the only working solution I found is to add unconditional wait in this form
        Thread.sleep(4000);
        //driver.navigate().refresh(); if the Thread.sleep does not work we can use page refresh too
        homePage.clickUserName(index);
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfileUrl();
        String profilePageUsername = profilePage.getUsernameText();
        Assert.assertEquals(profilePageUsername, homePostUsername, "The username text is incorrect");
        String currentFollowBtnTxt = profilePage.getFollowBtnText();
        Assert.assertNotEquals(currentFollowBtnTxt, followBtnTxt, "The 'Follow' button text is incorrect");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
