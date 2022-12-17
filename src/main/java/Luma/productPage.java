package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {
    private static WebDriver driver;

    private By tees1 = new By.ByXPath(" //*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/a");
    private By tees2 = new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[7]/div/a");

    private By cart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By checkout = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");

    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setClickCart() {
        driver.findElement(tees1).click();
    }

    public checkOutPage clickCheckOut() {
        driver.findElement(tees2).click();
        return new checkOutPage(driver);
    }

    public intimateProductPage clickTees1(){
        driver.findElement(tees1).click();
        return new intimateProductPage(driver);
    }
    public intimateProductPage clickTees2(){
        driver.findElement(tees2).click();
        return new intimateProductPage(driver);
    }
    public String getUrlProduct() {
        return driver.getCurrentUrl();
    }
}
