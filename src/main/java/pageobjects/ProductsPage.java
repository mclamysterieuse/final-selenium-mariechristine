package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    By cartProductTitleBy = By.cssSelector("#B07XLML2YS > a:nth-child(2) > span > div");
    By ProductTitleBy = By.cssSelector("#productTitle");

    By quantityBy = By.cssSelector("#quantity");
    By addToCartButtonBy = By.cssSelector("#add-to-cart-button");
    By openCartButtonBy = By.cssSelector("#attach-sidesheet-view-cart-button");
    public final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // get on retourne quelque chose.
    public ProductsPage updateQuantity(int productIndex, int newQuantity) {
        WebElement quantitySelectTag = driver.findElements(quantityBy).get(productIndex);
        Select dropdownQuantity = new Select(quantitySelectTag);
        dropdownQuantity.selectByIndex(newQuantity);
        return this;
    }

    public ProductsPage addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(addToCartButtonBy).click();
        return this;
    }

    public ProductsPage goToCardPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cartProductTitleBy)).click();
        return this;
    }

    public ProductsPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openCartButtonBy)).click();
        return new  ProductsPage(driver);
    }

    public ProductsPage getProductTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(ProductTitleBy).getText();
        return new  ProductsPage(driver);
    }

}

