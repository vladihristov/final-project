package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderLoggedIn extends BasePage {

    @FindBy(id="homeIcon")
    WebElement logo;
    @FindBy(id="nav-link-home")
    WebElement homeBTN;
    @FindBy(id="nav-link-profile")
    WebElement profileBTN;
    @FindBy(id="nav-link-new-post")
    WebElement newPostsBTN;
    @FindBy(id="search-bar")
    WebElement searchInput;
    @FindBy(css = ".fas.fa-search")
    WebElement searchIcon;
    @FindBy(css = ".fa-sign-out-alt")
    WebElement signOutBTN;
    @FindBy(css = ".dropdown-container")
    WebElement searchDropdown;
    @FindBy(css = ".dropdown-container .btn.btn-primary")
    List <WebElement> searchDropdownFollowBTNs;
    @FindBy(css = ".dropdown-container .post-user")
    List <WebElement> searchDropdownUsers;
    @FindBy(css = ".dropdown-container app-small-user-profile")
    List<WebElement> searchDropdownRows;
    public HeaderLoggedIn(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void goToNewPost(){
        clickElement(newPostsBTN);
    }

    public void goToProfilePage(){
        clickElement(profileBTN);
    }
    public void searchByKeyword(String searchKeyword){
        searchInput.sendKeys(searchKeyword);
    }
    public void verifyDropdownAppears(){
        longWait.until(ExpectedConditions.visibilityOf(searchDropdown));
    }
    public int getRowListSize(){
       return searchDropdownRows.size();
    }
    public void openSearchResultByIndex(int index){
        clickElement(searchDropdownUsers.get(index));
    }
    public void followUserByIndex(int index){
        clickElement(searchDropdownFollowBTNs.get(index));
    }
    public String getUsernameByIndex(int index){
        return getElementText(searchDropdownUsers.get(index));

    }
    public String getBtnTextByIndex(int index){
        return getElementText(searchDropdownFollowBTNs.get(index));
    }
    public void clickSearchIcon(){
        clickElement(searchIcon);
    }
    public void clickSearchInput(){
        clickElement(searchInput);
    }
}