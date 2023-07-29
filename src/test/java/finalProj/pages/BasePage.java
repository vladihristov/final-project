package finalProj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait smallWait;
    protected WebDriverWait mediumWait;
    protected WebDriverWait longWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    protected void clickElement(WebElement element) {
        mediumWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    protected String getElementText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void verifyURL(String url){
        mediumWait.until(ExpectedConditions.urlToBe(url));
    }
    public void verifyUrlContains(String url) {
        mediumWait.until(ExpectedConditions.urlContains(url));
    }
    public int getListSize(List webElement){
        return webElement.size();
    }
    public void verifyVisibility(WebElement webElement){
        smallWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
