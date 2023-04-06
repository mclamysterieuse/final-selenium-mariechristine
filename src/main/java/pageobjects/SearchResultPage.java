package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    WebDriver driver;

    By highTechResultLocator = By.cssSelector("div._p13n-zg-nav-tree-all_style_zg-browse-group__88fbz > div:nth-child(20) > a");


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage openSearchResult() {
        driver.findElement(highTechResultLocator).click();
        return new ProductsPage(driver);
    }

}
