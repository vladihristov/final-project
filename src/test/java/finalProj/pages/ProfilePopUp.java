package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePopUp {
    private final WebDriver driver;
    WebDriverWait wait;

    @FindBy(tagName = "app-edit-profile-modal")
    WebElement profileModal;
    @FindBy(css = "[formcontrolname='username']")
    WebElement userNameInput;
    @FindBy(css = "[formcontrolname='email']")
    WebElement email;
    @FindBy(css = "[formcontrolname='password']")
    WebElement passwordInput;
    @FindBy(css = "[formcontrolname='confirmPassword']")
    WebElement confirmPasswordInput;
    @FindBy(css = "[formcontrolname='publicInfo']")
    WebElement publicInfoInput;
    @FindBy(css = "[type='submit']")
    WebElement saveBtn;


    public ProfilePopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void enterPassword(String passwordText){
        passwordInput.sendKeys(passwordText);
    }
    public void confirmPassword(String confirmPassword){
        confirmPasswordInput.sendKeys(confirmPassword);
    }
    public void clearPublicInfo(){
        publicInfoInput.clear();
    }
    public void setPublicInfo(String publicInfoText){
        publicInfoInput.sendKeys(publicInfoText);
    }
    public void saveProfileChanges(){
        saveBtn.click();
    }
    public void waitEditProfilePopUp(){
        wait.until(ExpectedConditions.visibilityOf(profileModal));
    }

}
