package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    public final WebDriver driver;

    By quantityBy = By.cssSelector("#quantity");

    @FindBy(css = "#B07XLML2YS > a:nth-child(2) > span > div")
    public WebElement cartProductTitle;
    @FindBy(css = "#productTitle")
    public WebElement productTitle;

    @FindBy(css = "#add-to-cart-button")
    public WebElement addToCartButton;
    @FindBy(css = "#attach-sidesheet-view-cart-button")
    public WebElement openCartButton;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // get on retourne quelque chose.
    public ProductsPage updateQuantity(int productIndex, int newQuantity) {
        WebElement quantitySelectTag = driver.findElements(quantityBy).get(productIndex);
        Select dropdownQuantity = new Select(quantitySelectTag);
        dropdownQuantity.selectByIndex(newQuantity);
        return this;
    }

    public ProductsPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public ProductsPage goToCardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cartProductTitle)).click();
        return this;
    }

    public ProductsPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openCartButton)).click();
        return new ProductsPage(driver);
    }

    public ProductsPage getProductTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productTitle.getText();
        return new ProductsPage(driver);
    }

}

