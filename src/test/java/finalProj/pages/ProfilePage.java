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

public class ProfilePage extends BasePage {
    private final String profileURL = "http://training.skillo-bg.com/users";
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
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getPostCount(){
        return getListSize(postsList);
    }
    public void verifyURL(){
        longWait.until(ExpectedConditions.urlContains(profileURL));
    }
    public String getToastMessageText(){
        return getElementText(toastMessage);
    }
    public void openEditProfileModal(){
        clickElement(editBtn);
    }
    public String getPublicInfoText(){
        return getElementText(userPublicInfo);
    }
    public String getUsernameText(){
        verifyVisibility(userName);
        return getElementText(userName);
    }
    public void clickFollowBtn(){
        clickElement(followBtn);
    }
    public String getFollowBtnText(){
        return getElementText(followBtn);
    }
}
