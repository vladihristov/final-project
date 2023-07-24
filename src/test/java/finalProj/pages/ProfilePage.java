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
    @FindBy(css = "profile-stat-count")
    WebElement postCounter;

    @FindBy(css = "app-post")
    List<WebElement> postsList;



    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public int getPostCount(){
        return postsList.size();
    }
    public void verifyURL(){
        wait.until(ExpectedConditions.urlContains(profileURL));
    }
}
