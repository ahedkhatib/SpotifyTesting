package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private Currency currency;

    private By productNameBy = By.xpath("//div[contains(@class,'cart-summary-item-row')]//h4[text()='Sunglasses']");
    private By totalPriceBy = By.xpath("//div[contains(text(),'Total')]/following-sibling::div[contains(text(),'$28.98')]");
    private By confirmationMessageBy = By.xpath("//h3[text()='Your order is complete!']");
    private By placeOrderButtonBy = By.xpath("//button[contains(text(),'Place Order')]");

    public CartPage(WebDriver driver, Currency currency) {
        this.driver = driver;
        this.currency = currency;
    }

    public boolean verifyProductInCart(String productName, String expectedTotal) {
        boolean isProductNameCorrect = driver.findElement(productNameBy).getText().equals(productName);
        boolean isTotalPriceCorrect = driver.findElement(totalPriceBy).getText().contains(expectedTotal);
        return isProductNameCorrect && isTotalPriceCorrect;
    }


    public OrderConfirmationPage completeOrder() {
        driver.findElement(placeOrderButtonBy).click();
        return new OrderConfirmationPage(driver);
    }

}
