package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderLoggedIn {
    private final WebDriver driver;

    @FindBy(id="homeIcon")
    WebElement logo;
    @FindBy(id="nav-link-home")
    WebElement homeBTN;
    @FindBy(id="nav-link-profile")
    WebElement profileBTN;
    @FindBy(id="nav-link-new-post")
    WebElement newPostsBTN;
    @FindBy(id="search-bar")
    WebElement searchBar;
    @FindBy(css = ".fas.fa-search")
    WebElement searchIcon;
    @FindBy(css = ".fa-sign-out-alt")
    WebElement signOutBTN;
    @FindBy(css = ".dropdown-container")
    WebElement searchDropdown;
    @FindBy(css = ".btn-primary.ng-star-inserted")
    WebElement followBTNs;
    public HeaderLoggedIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToNewPost(){
        newPostsBTN.click();
    }
}