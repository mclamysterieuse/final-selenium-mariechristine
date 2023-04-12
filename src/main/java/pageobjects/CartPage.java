package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    @FindBy(css = "span.a-size-base-plus.a-color-base.sc-product-title.sc-grid-item-product-title")
    public WebElement productTitle;

    @FindBy(css = "span.a-dropdown-prompt")
    public WebElement productQuantity;

    public final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCardTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(productTitle)).getText();
    }

    public String getProductQuantity() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return productQuantity.getText();
    }
}
