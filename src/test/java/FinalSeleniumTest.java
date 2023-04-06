import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductsPage;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class FinalSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }

    @Test
    public void testAmazon() {
        String keyword = "2";
        String Test = "Tapo Caméra Surveillance WiFi intérieure 1080P C200, détection de mouvement, audio bidirectionnel, compatible avec Alexa et Google Assistant, pour Bébé/Animaux";

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        String realTitle = homePage.closeCookiePopup()
                .openNewPage()
                .openSearchResult()
                .goToCardPage()
                .updateQuantity(0,1)
                .addToCart()
                .openCart().toString();
        Assert.assertEquals(cartPage.getProductQuantity(), keyword);
        Assert.assertEquals(cartPage.getCardTitle(),Test);

    }
}
