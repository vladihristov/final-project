package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {
    private final String URLLogin = "http://training.skillo-bg.com/users/login";
    private final String postsURL = "http://training.skillo-bg.com/posts/all";
    @FindBy(css = "form .h4")
    WebElement signInText;
    @FindBy(name = "usernameOrEmail")
    WebElement userNameField;
    @FindBy(name = "password")
    WebElement passField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserNameOrEmail(String userName) {
        verifyVisibility(userNameField);
        userNameField.sendKeys(userName);
    }

    public void enterPass(String pass) {
        verifyVisibility(passField);
        passField.sendKeys(pass);
    }

    public void clickSignInBtn() {
        clickElement(signInBtn);
    }
    public void verifyUrlAfterLogin(){
        verifyURL(postsURL);
    }
}
