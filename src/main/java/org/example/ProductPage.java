package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private Currency currency;


    private By addToCartButtonBy = By.xpath("//button[@type='submit' and contains(@class,'cymbal-button-primary')]");
    private By cartLinkBy = By.cssSelector("a[href='/cart']");

    public ProductPage(WebDriver driver, Currency currency) {
        this.driver = driver;
        this.currency = currency;
    }


    public CartPage addProductToCartAndProceed() {
        driver.findElement(addToCartButtonBy).click();
        driver.findElement(cartLinkBy).click();
        return new CartPage(driver, currency);
    }
}
