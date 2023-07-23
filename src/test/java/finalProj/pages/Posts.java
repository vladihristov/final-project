package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Posts {
    private final WebDriver driver;

   @FindBy(css = "h3.text-center")
   WebElement pageHeading;
   @FindBy(css = ".uploadfilecontainer")
   WebElement uploadContainer;
   @FindBy(id="choose-file")
   WebElement browseBTN;
   @FindBy(name="caption")
   WebElement postPlaceholderText;
   @FindBy(id="create-post")
   WebElement submitBTN;

    public Posts(WebDriver driver) {
        this.driver = driver;
    }
    public void postText(String postText){
        postPlaceholderText.sendKeys(postText);
    }
    public void submitPost(){
        submitBTN.click();
    }
    public void uploadImage(){
        uploadContainer.sendKeys("\\testFiles\\austronaut.jpg");
    }
}
