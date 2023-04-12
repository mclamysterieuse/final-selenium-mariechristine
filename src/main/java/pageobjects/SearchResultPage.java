package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    WebDriver driver;

    @FindBy(css = "div._p13n-zg-nav-tree-all_style_zg-browse-group__88fbz > div:nth-child(20) > a")
    public WebElement highTechResultLocator;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage openSearchResult() {
        highTechResultLocator.click();
        return new ProductsPage(driver);
    }

}
