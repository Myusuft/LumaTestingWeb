package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    public WebDriver driver;
    public By email = By.id("email");
    public By password = By.id("pass");
    public By signInBTN = By.id("send2");

    public signInPage(WebDriver driver) {
        this.driver = driver;
    }

    // email
    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    // password
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    // sign in
    public accountPage clickSignInBTN() {
        driver.findElement(signInBTN).submit();
        return new accountPage(driver);
    }

}
