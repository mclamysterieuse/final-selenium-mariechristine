package pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {


    By productTitleBy = By.cssSelector("span.a-size-base-plus.a-color-base.sc-product-title.sc-grid-item-product-title");

    By productQuantityBy = By.cssSelector("span.a-dropdown-prompt");

    public final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCardTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       return wait.until(ExpectedConditions.elementToBeClickable(productTitleBy)).getText();
    }
    public String getProductQuantity() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(productQuantityBy).getText();
    }
}
