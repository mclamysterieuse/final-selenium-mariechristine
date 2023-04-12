package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "sp-cc-accept")
    public WebElement cookieAcceptButtonLocator;

    @FindBy(css = "#nav-xshop > a:nth-child(3)")
    public WebElement bestSellerLocator;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage closeCookiePopup() {
        cookieAcceptButtonLocator.click();
        return this;
    }

    public SearchResultPage openNewPage() {
        bestSellerLocator.click();
        return new SearchResultPage(driver);
    }

}
