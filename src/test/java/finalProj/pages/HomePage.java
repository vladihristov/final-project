package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final String homeURL = "http://training.skillo-bg.com/posts/all";
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "app-post-detail")
    List<WebElement> homePostsList;
    @FindBy(css = ".like.far.fa-heart.fa-2x")
    WebElement heartIcon;
    @FindBy(css = ".like.far.fa-heart.fa-2x.liked")
    WebElement heartIconSelected;
    @FindBy(css = "div[class='icons-container'] i[class='ml-4 far fa-thumbs-down fa-2x']")
    WebElement dislikeIcon;
    @FindBy(css = ".ml-4.far.fa-thumbs-down.fa-2x.liked")
    WebElement dislikeIconSelected;
    @FindBy(css = "input[placeholder='Comment here']")
    WebElement postCommmentInputField;
    @FindBy(css = ".col-12.comment-content")
    List<WebElement> postCommentsList;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void checkURLNewPost(){
        wait.until(ExpectedConditions.urlToBe(homeURL));
    }
    public int getPostCount(){
        return homePostsList.size();
    }
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public  void openPostByIndex(int index){
        clickElement(homePostsList.get(index));
    }
    public void likePost(){
        clickElement(heartIcon);
    }
    public void removePostLike(){
        clickElement(heartIconSelected);
    }
    public void dislikePost(){
        clickElement(dislikeIcon);
    }
    public void removePostDislike(){
        clickElement(dislikeIconSelected);
    }
    public void verifyPostIsLiked(){
        wait.until(ExpectedConditions.visibilityOf(heartIconSelected));
    }
    public void verifyPostIsNotLiked(){
        wait.until(ExpectedConditions.visibilityOf(heartIcon));
    }
    public void verifyPostIsDisliked(){
        wait.until(ExpectedConditions.visibilityOf(dislikeIconSelected));
    }
    public void verifyPostIsNotDisliked(){
        wait.until(ExpectedConditions.visibilityOf(dislikeIcon));
    }
    public void writeComment(String text){
        postCommmentInputField.sendKeys(text);
    }
    public void postComment(){
        postCommmentInputField.sendKeys(Keys.ENTER);
    }
    public int getcommentsCount(){
       return postCommentsList.size();
    }
    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public String getCommentText(int listIndex){
        String commentText = getElementText(postCommentsList.get(listIndex));
        return commentText;
    }
}
