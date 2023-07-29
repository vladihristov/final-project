package finalProj.tests;

import finalProj.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditPublicInfoTest {
    private WebDriver driver;
    private final String homeURL = "http://training.skillo-bg.com/";
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
    public void editProfilePublicInfo() {
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

        System.out.println("Go to the Profile page open the edit profile pop up");
        HeaderLoggedIn headerLoggedUser = new HeaderLoggedIn(driver);
        headerLoggedUser.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openEditProfileModal();

        System.out.println("Change the Additional profile text ");
        ProfilePopUp profilePopUp = new ProfilePopUp(driver);
        profilePopUp.waitEditProfilePopUp();
        profilePopUp.clearPublicInfo();
        String publicTextTyped = "Lorem Ipsum";
        profilePopUp.setPublicInfo(publicTextTyped);
        profilePopUp.saveProfileChanges();

        System.out.println("Check the toast message text confirming we have a positive response from the system");
        Assert.assertEquals(profilePage.getToastMessageText(),"Profile updated", "Incorrect toast message");
        String currentProfilePublicText = profilePage.getPublicInfoText();
        System.out.println("Verify that the text is added to the profile");
        Assert.assertEquals(currentProfilePublicText, username+"  "+publicTextTyped+" \uD83D\uDCF7✈\uFE0F\uD83C\uDFD5\uFE0F", "The profile public text is incorrect");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
