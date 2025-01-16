import org.example.CartPage;
import org.example.Currency;
import org.example.HomePageOnline;
import org.example.OrderConfirmationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.example.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineBoutiqueTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        //driver.manage().window().maximize();
        driver.get("https://cymbal-shops.retail.cymbal.dev/");
    }

    /****@BeforeEach
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.getDriver();
        //driver.manage().window().maximize();
        driver.get("https://cymbal-shops.retail.cymbal.dev/");
    }****/

    /*@BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");   // to launch Chrome without GUI
        driver = new RemoteWebDriver(new URL("http://16.171.132.126:4444"), options);
        driver.get("https://cymbal-shops.retail.cymbal.dev/");
    }*/

    @Test
    public void testOrderInUSD() {
        Currency usd = new Currency("USD", "$");


        HomePageOnline homePage = new HomePageOnline(driver);
        CartPage cartPage = homePage
                .selectCurrency(usd)
                .goToProductPage("Sunglasses")
                .addProductToCartAndProceed();

        assertTrue(cartPage.verifyProductInCart("Sunglasses", "$28.98"));

        OrderConfirmationPage confirmationPage = cartPage.completeOrder();
        assertTrue(confirmationPage.isOnCheckoutPage());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
