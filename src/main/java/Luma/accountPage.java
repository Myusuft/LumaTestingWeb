package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class accountPage {
    private static WebDriver driver;
    private By men = new By.ById("ui-id-5");
    private By tops = new By.ById("ui-id-17");
    private By tees = new By.ById("ui-id-21");

    private By clickCart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]");
//    private By cart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By checkout = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");
    private By menu = new By.ByXPath("//button[@class = \"action switch\"]");
    private By signOut = new By.ByXPath("//li[@class = \"authorization-link\"]");

public accountPage(WebDriver driver) {
        this.driver = driver;
    }

    //setMen
    public void setMen() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(men));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(men)).perform();
    }

    //setTops
    public void setTops() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(tops));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(tops)).perform();
    }

    //setTees
    public productPage setTees() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(tees));
        Actions action = new Actions(driver);
        action.click(driver.findElement(tees)).perform();
        return new productPage(driver);
    }

    //setClickCart
    public void setClickCart() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(clickCart));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(clickCart)).click().perform();
    }

    //checkout
    public checkOutPage setCheckout() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(checkout));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(checkout)).click().perform();
        return new checkOutPage(driver);
    }
    public void setMenu(){
        driver.findElement(menu).click();
    }

    public logOutPage setSignOut(){
        driver.findElement(signOut).click();
        return new logOutPage(driver);
    }

    public String getUrlAccount() {
        return driver.getCurrentUrl();
    }




}
