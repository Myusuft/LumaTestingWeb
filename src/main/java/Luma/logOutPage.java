package Luma;

import org.openqa.selenium.WebDriver;

public class logOutPage {
    private static WebDriver driver;

    public logOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlLogOut() {
        return driver.getCurrentUrl();
    }
}
