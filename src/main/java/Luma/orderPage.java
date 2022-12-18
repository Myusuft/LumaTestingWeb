package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderPage {
    private static WebDriver driver;
    private By orderNumber = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");

    public orderPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlOrder() {
        return driver.getCurrentUrl();
    }

    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText();
    }
}

