package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {
    private final String profileURL = "http://training.skillo-bg.com/users";
    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait longWait;
    @FindBy(css = "profile-stat-count")
    WebElement postCounter;
    @FindBy(css = "app-post")
    List<WebElement> postsList;
    @FindBy(css = ".fas.fa-user-edit")
    WebElement editBtn;
    @FindBy(css = "[aria-label='Profile updated']")
    WebElement toastMessage;
    @FindBy(css = "div[class='col-12'] p")
    WebElement userPublicInfo;
    @FindBy(css = "div[class='col-12 col-lg-6 profile-user-settings'] h2")
    WebElement userName;
    @FindBy(css = ".btn.btn-primary.profile-edit-btn.ng-star-inserted")
    WebElement followBtn;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public int getPostCount(){
        return postsList.size();
    }
    public void verifyURL(){
        longWait.until(ExpectedConditions.urlContains(profileURL));
    }
    public String getToastMessageText(){
        return toastMessage.getText();
    }
    public void openEditProfileModal(){
        editBtn.click();
    }
    public String getPublicInfoText(){
        return userPublicInfo.getText();
    }
    public void getProfileText(){
        userPublicInfo.getText();
    }
    public String getUsernameText(){
        wait.until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }
    public void clickFollowBtn(){
        followBtn.click();
    }
    public String getFollowBtnText(){
        return followBtn.getText();
    }
}
