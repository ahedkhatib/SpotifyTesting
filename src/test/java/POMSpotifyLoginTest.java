import org.example.HomePage;
import org.example.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class POMSpotifyLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
/*
    @BeforeEach
    public void setUp() {
        driver = getDriver();
        //driver.manage().window().maximize();
        driver.get("http://localhost:8082/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        HomePage home = loginPage.loginAsValidUser("user@example.com", "password123");
        assertTrue(home.isLoggedInSuccessfully());
    }

    @Test
    public void testInvalidLogin() {
        LoginPage returnedPage = loginPage.loginWithInvalidCredentials("wronguser@example.com", "wrongpassword");
        assertTrue(driver.getTitle().contains("Login"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }*/
}
