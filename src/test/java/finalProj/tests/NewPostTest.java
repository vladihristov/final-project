package finalProj.tests;

import finalProj.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class NewPostTest extends BaseTest{
    File file = new File("src/test/java/finalProj/testFiles/austonaut.jpg");

    @Test
    public void newPostTest(){
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

        System.out.println("Go to the Profile page and check post count");
        HeaderLoggedIn headerLoggedUser = new HeaderLoggedIn(driver);
        headerLoggedUser.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        int postsCount = profilePage.getPostCount();

        System.out.println("Go to the New Post page");
        headerLoggedUser.goToNewPost();

        System.out.println("Verify the user is on the New Post page");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.checkURLNewPost();

        System.out.println("Upload an image");
        newPostPage.uploadPostImage(file);

        System.out.println("Add text content to the post");
        newPostPage.postText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Test content");

        System.out.println("Click the Submit button");
        newPostPage.submitPost();

        System.out.println("Check post count again");
        profilePage.verifyProfileUrl();
        int currentPostCount = profilePage.getPostCount();
        Assert.assertEquals(currentPostCount,postsCount +1, "The post count is incorrect");
    }
}
