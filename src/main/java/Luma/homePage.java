package Luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    public WebDriver driver;
    public By createAnAccount = new By.ByLinkText("Create an Account");
    public By signIn = new By.ByLinkText("Sign In");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    // create account
    public createAccountPage clickCreateAnAccount() {
        driver.findElement(createAnAccount).click();
        return new createAccountPage(driver);
    }
    // sign in
    public signInPage clickSignIn() {
        driver.findElement(signIn).click();
        return new signInPage(driver);
    }
    // get url
    public String getUrlHome() {
        return driver.getCurrentUrl();
    }

}
