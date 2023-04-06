package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    By cookieAcceptButtonLocator = By.cssSelector("#sp-cc-accept");

    By bestSellerLocator = By.cssSelector("#nav-xshop > a:nth-child(3)");


    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage closeCookiePopup() {
        driver.findElement(cookieAcceptButtonLocator).click();
        return this;
    }
    public SearchResultPage openNewPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(bestSellerLocator).click();
        return new SearchResultPage(driver);
    }

}
