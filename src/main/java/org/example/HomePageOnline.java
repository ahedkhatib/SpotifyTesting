package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePageOnline {
    private WebDriver driver;
    private Currency currency;

    private By currencyDropdownBy = By.name("currency_code");
    private String productCardByNameXPath = "//div[contains(@class,'hot-product-card-name') and text()='%s']/ancestor::div[contains(@class,'hot-product-card')]//a";


    public HomePageOnline(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageOnline selectCurrency(Currency currency) {
        this.currency = currency;
        Select currencyDropdown = new Select(driver.findElement(currencyDropdownBy));
        currencyDropdown.selectByValue(currency.getCode());
        return this;
    }

    public ProductPage goToProductPage(String productName) {
        String productXPath = String.format(productCardByNameXPath, productName);
        driver.findElement(By.xpath(productXPath)).click();
        return new ProductPage(driver, currency);
    }

}
