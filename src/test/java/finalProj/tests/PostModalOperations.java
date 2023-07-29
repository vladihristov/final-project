package finalProj.tests;

import finalProj.pages.HeaderUnauthenticated;
import finalProj.pages.HomePage;
import finalProj.pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class PostModalOperations {
    private WebDriver driver;
    private final String homeURL = "http://training.skillo-bg.com/";
    private final int postIndex = 0;

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
    public void newPostTest() {
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

        System.out.println("Verify the user is on the posts page after login");
        login.verifyUrlAfterLogin();

        System.out.println("Open one of the posts. Let's try with the 1st post");
        HomePage homePage = new HomePage(driver);
        homePage.openPostByIndex(postIndex);

        System.out.println("Like the post and verify it is liked");
        homePage.likePost();
        homePage.verifyPostIsLiked();

        System.out.println("Remove the like and verify it is not liked");
        homePage.removePostLike();
        homePage.verifyPostIsNotLiked();

        System.out.println("Dislike the post and verify it is disliked");
        homePage.dislikePost();
        homePage.verifyPostIsDisliked();

        System.out.println("Remove post dislike and verify it is no longer disliked");
        homePage.removePostDislike();
        homePage.verifyPostIsNotDisliked();

        System.out.println("Like the post again and post a message");
        homePage.likePost();
        homePage.verifyPostIsLiked();
        homePage.writeComment("Nice post!");
        homePage.postComment();
        Assert.assertEquals(homePage.getCommentText(homePage.getCommentsCount()-1), "Nice post!", "Text is incorrect");

        System.out.println("Verify the like and post are saved after page refresh");
        driver.navigate().refresh();
        homePage.openPostByIndex(postIndex);
        homePage.verifyPostIsLiked();
        Assert.assertEquals(homePage.getCommentText(homePage.getCommentsCount()-1), "Nice post!", "Text is incorrect");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
