package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkOutPage {
    private static WebDriver driver;
    private By summary = By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]");
    private By cartItem = By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]");
    private By cartName = By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[2]/div/ol/li[1]/div/div/div[1]/div[1]");
    private By itemDetail = By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]");
    private By shippingCompany = By.name("company");
    private By shippingAddress = By.name("street[0]");
    private By shippingCity = By.name("city");
    private By shippingState = By.name("region_id");
    private By shippingZip = By.name("postcode");
    private By shippingCountry = By.name("country_id");
    private By shippingPhone = By.name("telephone");
    private By shippingMethod = By.name("ko_unique_3");
    private By shippingContinue = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
    private By paymentAddress = By.className("billing-address-details");
    private By placeOrder = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
    private By orderNumber = By.className("order-number");


    public checkOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlCheckOut() {
        return driver.getCurrentUrl();
    }

    public void clickSummary() {
        driver.findElement(summary).click();
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(summary));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(summary)).click().perform();
    }

    public void cartItem(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        Actions action = new Actions(driver);
        String expectedItems = driver.findElement(cartItem).getText();
        String expectedItemName = driver.findElement(cartName).getText();
        System.out.println(expectedItemName);
    }

    public void itemDetail(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(itemDetail)).click();
        System.out.println("Item Detail");

    }

    public void setCompany(String strCompany) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingCompany));
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(shippingCompany)).sendKeys(strCompany);
        driver.findElement(shippingCompany).sendKeys(strCompany);

    }

    public void setAddress(String strAddress) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingAddress));
        driver.findElement(shippingAddress).sendKeys(strAddress);
    }

    public void setCity(String strCity) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingCity));
        driver.findElement(shippingCity).sendKeys(strCity);
    }

    public void setState() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingState));
        Select state = new Select(driver.findElement(shippingState));
        state.selectByVisibleText("California");
    }

    public void setZip(String strZip) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingZip));
        driver.findElement(shippingZip).sendKeys(strZip);
    }

    public void setCountry() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingCountry));
        Select country = new Select(driver.findElement(shippingCountry));
        country.selectByVisibleText("United States");
    }

    public void setPhone(String strPhone) {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingPhone));
        driver.findElement(shippingPhone).sendKeys(strPhone);
    }

    public void setMethod(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingMethod));
        driver.findElement(shippingMethod).click();
    }

    public void clickContinue() {
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(shippingContinue));
        driver.findElement(shippingContinue).click();
    }

    public String checkAddress(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(paymentAddress));
        String expectedAddress = driver.findElement(paymentAddress).getText();
//        System.out.println(expectedAddress);
        return expectedAddress;
    }

    public void clickPlaceOrder(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(placeOrder)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOrderNumber(){
        WebElement waiting = new WebDriverWait(driver, Duration.ofSeconds(300)).until(ExpectedConditions.visibilityOfElementLocated(orderNumber));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(orderNumber)).click().perform();
    }





}

