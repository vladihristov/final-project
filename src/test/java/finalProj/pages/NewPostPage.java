package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage extends BasePage {
    private final String newPostPageURL = "http://training.skillo-bg.com/posts/create";
   @FindBy(css = "h3.text-center")
   WebElement pageHeading;
   @FindBy(css = "input.file[type='file']")
   WebElement uploadContainer;
   @FindBy(id="choose-file")
   WebElement browseBTN;
   @FindBy(name="caption")
   WebElement postPlaceholderText;
   @FindBy(id="create-post")
   WebElement submitBTN;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void postText(String postText){
        postPlaceholderText.sendKeys(postText);
    }
    public void submitPost(){
        clickElement(submitBTN);
    }
    public void uploadPostImage(File file){
        uploadContainer.sendKeys(file.getAbsolutePath());
    }
    public void checkURLNewPost(){
        verifyURL(newPostPageURL);
    }
}
