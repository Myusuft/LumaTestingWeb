package Luma;

import org.openqa.selenium.WebDriver;

public class checkOutPage {
    private static WebDriver driver;

    public checkOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlCheckOut() {
        return driver.getCurrentUrl();
    }
}
