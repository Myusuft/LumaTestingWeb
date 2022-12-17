package Luma;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LumaPageTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @BeforeEach
    public void setUp() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    @Order(1)
    public void testHomePage() {
        homePage homes = new homePage(driver);

        String url = homes.getUrlHome();
        assertEquals("https://magento.softwaretestingboard.com/", url);
    }
    @Test
    @Order(2)
    public void testCreateAccount() {
        homePage home = new homePage(driver);
        home.clickCreateAnAccount();

        createAccountPage create = new createAccountPage(driver);
        create.setFirstName("Muhammad");
        create.setLastName("Yusuf franchise");
        create.clickSubscribe();
        create.setEmail("mhyusuft111@gmail.com");
        create.setPassword("YusufFranchise777");
        create.setConfirmPassword("YusufFranchise777");
        create.clickCreateAccount();
        accountPage success = new accountPage(driver);
        String url = success.getUrlAccount();
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", url);
    }

    @Test
    @Order(3)
    public void testMenu(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("mhyusuft999@gmail.com");
        signIn.setPassword("YusufFranchise777");
        signIn.clickSignInBTN();

        accountPage account = new accountPage(driver);
        account.setMen();
        account.setTops();
        account.setTees();

        productPage product = new productPage(driver);
        String url = product.getUrlProduct();
        assertEquals("https://magento.softwaretestingboard.com/men/tops-men/tees-men.html", url);
    }

    //test select product
    @Test
    @Order(4)
    public void testSelectProduct(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("mhyusuft777@gmail.com");
        signIn.setPassword("YusufFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();

        productPage tees = new productPage(driver);
        tees.clickTees1();

        intimateProductPage intimate = new intimateProductPage(driver);
        String url = intimate.getUrlIntimateProduct();
        assertEquals("https://magento.softwaretestingboard.com/logan-heattec-reg-tee.html", url);

    }

    //test add to cart
    @Test
    @Order(5)
    public void testAddtoCart(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("mhyusuft777@gmail.com");
        signIn.setPassword("YusufFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();

        productPage tees = new productPage(driver);
        tees.clickTees1();

        intimateProductPage intimate = new intimateProductPage(driver);
        intimate.selectSize("M");
        intimate.selectColorB("Black");
        intimate.setQty("2");
        intimate.clickAddToCart();
        intimate.clickBackProduct();

        tees.clickTees2();
        intimate.selectSize("S");
        intimate.selectColorB("Green");
        intimate.setQty("2");
        intimate.clickAddToCart();

        assertEquals("4", intimate.getCart());
    }

    @Test
    @Order(6)
    public void testCheckOut(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("mhyusuft777@gmail.com");
        signIn.setPassword("YusufFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        String url = checkout.getUrlCheckOut();
        assertEquals("https://magento.softwaretestingboard.com/checkout/", url);
    }

}
