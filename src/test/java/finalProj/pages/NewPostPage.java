package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage {
    private final WebDriver driver;
    private final String newPostPageURL = "http://training.skillo-bg.com/posts/create";
    WebDriverWait wait;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    public void postText(String postText){
        postPlaceholderText.sendKeys(postText);
    }
    public void submitPost(){
        submitBTN.click();
    }
    public void uploadImage(File file){
        uploadContainer.sendKeys(file.getAbsolutePath());
    }
    public void checkURLNewPost(){
        wait.until(ExpectedConditions.urlToBe(newPostPageURL));
    }
}
