package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class intimateProductPage {
    private WebDriver driver;

    private By XS = new By.ByXPath("//*[@id=\"option-label-size-143-item-166\"]");
    private By S = new By.ByXPath("//*[@id=\"option-label-size-143-item-167\"]");
    private By M = new By.ByXPath("//*[@id=\"option-label-size-143-item-168\"]");
    private By L = new By.ByXPath("//*[@id=\"option-label-size-143-item-169\"]");
    private By XL = new By.ByXPath("//*[@id=\"option-label-size-143-item-170\"]");

    private By black = new By.ByXPath("//*[@id=\"option-label-color-93-item-49\"]");
    private By grey = new By.ByXPath("//*[@id=\"option-label-color-93-item-52\"]");
    private By green = new By.ByXPath("//*[@id=\"option-label-color-93-item-53\"]");
    private By orange = new By.ByXPath("//*[@id=\"option-label-color-93-item-56\"]");
    private By red = new By.ByXPath("//*[@id=\"option-label-color-93-item-58\"]");
    private By white = new By.ByXPath("//*[@id=\"option-label-color-93-item-59\"]");

    private By qty = new By.ById("qty");
    private By addToCart = new By.ByXPath("//*[@id=\"product-addtocart-button\"]");

    private By checkCart = new By.ByXPath("//span[@class = \"counter qty\"]");
    private By backProduct = new By.ByXPath("/html/body/div[2]/div[2]/ul/li[4]/a");

    public intimateProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // select size
    public void selectSize(String strSize) {
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (strSize == "XS") {
            waits.until(ExpectedConditions.elementToBeClickable(XS)).click();
        } else if (strSize == "S") {
            waits.until(ExpectedConditions.elementToBeClickable(S)).click();
        } else if (strSize == "M") {
            waits.until(ExpectedConditions.elementToBeClickable(M)).click();
        } else if (strSize == "L") {
            waits.until(ExpectedConditions.elementToBeClickable(L)).click();
        } else if (strSize == "XL") {
            waits.until(ExpectedConditions.elementToBeClickable(XL)).click();
        }
    }

    // select color
    public void selectColorA(String select) {
        if (select == "Orange") {
            driver.findElement(orange).click();
        } else if (select == "Red") {
            driver.findElement(red).click();
        } else if (select == "White") {
            driver.findElement(white).click();
        }
    }
    public void selectColorB(String select) {
        if (select == "Black") {
            driver.findElement(black).click();
        } else if (select == "Grey") {
            driver.findElement(grey).click();
        } else if (select == "Green") {
            driver.findElement(green).click();
        }
    }

    // select quantity
    public void setQty(String strQty) {
        driver.findElement(qty).clear();
        driver.findElement(qty).sendKeys(strQty);
    }

    // add to cart
    public void clickAddToCart() {
        driver.findElement(addToCart).submit();
    }

    // click back product
    public productPage clickBackProduct() {
        driver.findElement(backProduct).click();
        return new productPage(driver);
    }
    // get url intimate product
    public String getUrlIntimateProduct() {
        return driver.getCurrentUrl();
    }

    // get cart
    public String getCart() {
        WebElement xCart = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(checkCart));
        return xCart.findElement(checkCart).getText().split("\n")[0];
    }

}
