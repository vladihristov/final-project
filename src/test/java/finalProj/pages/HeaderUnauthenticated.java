package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderUnauthenticated {
    private final WebDriver driver;

    @FindBy(id="homeIcon")
    WebElement logo;
    @FindBy(id="nav-link-home")
    WebElement homeBTN;
    @FindBy(id="nav-link-login")
    WebElement loginBTN;
    public HeaderUnauthenticated(WebDriver driver) {
        this.driver = driver;
    }
    public void goToLogin(){
        loginBTN.click();
    }
}
