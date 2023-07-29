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

public class HomePage extends BasePage {
    private final String homeURL = "http://training.skillo-bg.com/posts/all";
    private final String notFoundUrl = "http://training.skillo-bg.com/not-found";
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
    @FindBy(css = ".post-user")
    List<WebElement> postUsers;
    @FindBy(css = "app-post-detail")
    List<WebElement> postsHomepage;
    @FindBy(css = ".row.post-list-container")
    WebElement postsContainer;
    @FindBy(css = ".btn.btn-primary")
    List<WebElement> postsFollowBtns;
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void checkURLNewPost(){
       verifyURL(homeURL);
    }
    public int getPostCount(){
        return getListSize(homePostsList);
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
        verifyVisibility(heartIconSelected);
    }
    public void verifyPostIsNotLiked(){
        verifyVisibility(heartIcon);
    }
    public void verifyPostIsDisliked(){
        verifyVisibility(dislikeIconSelected);
    }
    public void verifyPostIsNotDisliked(){
        verifyVisibility(dislikeIcon);
    }
    public void writeComment(String text){
        postCommmentInputField.sendKeys(text);
    }
    public void postComment(){
        postCommmentInputField.sendKeys(Keys.ENTER);
    }
    public int getCommentsCount(){
       return postCommentsList.size();
    }
    public String getCommentText(int listIndex){
        return getElementText(postCommentsList.get(listIndex));
    }
    public int getPostsUsersSize(){
        return getListSize(postUsers);
    }
    public String getPostUsernameText(int userIndex){
        return getElementText(postUsers.get(userIndex));
    }
    public void clickUserName(int userIndex){
        clickElement(postUsers.get(userIndex));
    }
    public void verifyNotFoundUrl() {
        verifyURL(notFoundUrl);
    }
    public void waitPostsToAppear(){
        verifyVisibility(postsContainer);
    }
    public int getFollowBtnsSize(){
        return getListSize(postsFollowBtns);
    }
    public String getPostFollowBtnText(int btnIndex){
        return getElementText(postsFollowBtns.get(btnIndex));
    }
    public void clickFollowBtn(int btnIndex){
        clickElement(postsFollowBtns.get(btnIndex));
    }
}
