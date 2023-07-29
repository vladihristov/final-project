package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderUnauthenticated extends BasePage {

    @FindBy(id="homeIcon")
    WebElement logo;
    @FindBy(id="nav-link-home")
    WebElement homeBTN;
    @FindBy(id="nav-link-login")
    WebElement loginBTN;
    public HeaderUnauthenticated(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void goToLogin(){
        clickElement(loginBTN);
    }
}
