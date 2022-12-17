package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createAccountPage {
    public WebDriver driver;
    public By firstName = By.id("firstname");
    public By lastName = By.id("lastname");
    public By subscribe = By.id("is_subscribed");
    public By email = By.id("email_address");
    public By password = By.id("password");
    public By confirmPassword = By.id("password-confirmation");
    public By createAccount = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public createAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    // first name
    public void setFirstName(String strFirstName) {
        driver.findElement(firstName).sendKeys(strFirstName);
    }
    // last name
    public void setLastName(String strLastName) {
        driver.findElement(lastName).sendKeys(strLastName);
    }
    // subscribe
    public void clickSubscribe() {
        driver.findElement(subscribe).click();
    }
    // email
    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }
    // password
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }
    // confirm password
    public void setConfirmPassword(String strConfirmPassword) {
        driver.findElement(confirmPassword).sendKeys(strConfirmPassword);
    }
    // create account
    public void clickCreateAccount() {
        driver.findElement(createAccount).click();
    }
    // get url
    public String getUrlCreateAccount() {
        return driver.getCurrentUrl();
    }
}
