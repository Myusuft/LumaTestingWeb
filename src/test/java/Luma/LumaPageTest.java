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
        create.setFirstName("Ekas");
        create.setLastName("Ekas franchise");
        create.clickSubscribe();
        create.setEmail("ekas111@gmail.com");
        create.setPassword("EkasFranchise777");
        create.setConfirmPassword("EkasFranchise777");
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
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
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
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
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
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
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
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        String url = checkout.getUrlCheckOut();
        assertEquals("https://magento.softwaretestingboard.com/checkout/", url);
    }

    //Masih error
    @Test
    @Order(7)
    public void testSummaryCheck(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        String actualJumlahProduk = "8 Items in Cart";
        String[] actualItem1 = new String[] {"Logan HeatTec® Tee", "4", "$96.00", "M", "Black"};
        String[] actualItem2 = new String[] {"Balboa Persistence Tee", "4", "$116.00", "S", "Green"};

        checkOutPage checkout = new checkOutPage(driver);
        checkout.itemDetail();
//        checkout.cartItem();
    }

    @Test
    @Order(8)
    public void testShippingAddress(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        checkout.setCompany("PT. Yusuf Franchise");
        checkout.setAddress("Jl. Raya Cikarang");
        checkout.setCity("Bekasi");
        checkout.setState();
        checkout.setZip("17530");
        checkout.setCountry();
        checkout.setPhone("081234567890");
        checkout.setMethod();
        checkout.clickContinue();

    }

    @Test
    @Order(9)
    public void testPaymentAddress(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        checkout.setCompany("PT. Yusuf Franchise");
        checkout.setAddress("Jl. Raya Cikarang");
        checkout.setCity("Bekasi");
        checkout.setState();
        checkout.setZip("17530");
        checkout.setCountry();
        checkout.setPhone("081234567890");
        checkout.setMethod();
        checkout.clickContinue();

        String actualAddress = "Muhammad Yusuf franchise\n" +
                "Jl. Raya Cikarang\n" +
                "Bekasi, California 17530\n" +
                "United States\n" +
                "081234567890";

       assertEquals(actualAddress, checkout.checkAddress());

    }


    //Error di button place order
    @Test
    @Order(10)
    public void testPlaceOrder(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        checkout.setCompany("PT. Yusuf Franchise");
        checkout.setAddress("Jl. Raya Cikarang");
        checkout.setCity("Bekasi");
        checkout.setState();
        checkout.setZip("17530");
        checkout.setCountry();
        checkout.setPhone("081234567890");
        checkout.setMethod();
        checkout.clickContinue();

        checkout.clickPlaceOrder();
    }


    //Error di button place order
    @Test
    @Order(11)
    public void testOrderSuccess(){
        homePage home = new homePage(driver);
        home.clickSignIn();

        signInPage signIn = new signInPage(driver);
        signIn.setEmail("ekas111@gmail.com");
        signIn.setPassword("EkasFranchise777");
        signIn.clickSignInBTN();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setTees();
        product.setClickCart();
        product.setCheckout();

        checkOutPage checkout = new checkOutPage(driver);
        checkout.setCompany("PT. Yusuf Franchise");
        checkout.setAddress("Jl. Raya Cikarang");
        checkout.setCity("Bekasi");
        checkout.setState();
        checkout.setZip("17530");
        checkout.setCountry();
        checkout.setPhone("081234567890");
        checkout.setMethod();
        checkout.clickContinue();

        checkout.clickPlaceOrder();

        checkout.clickOrderNumber();
        String expectedOrderNumber = "Order # 000011346";
        orderPage order = new orderPage(driver);
        assertEquals(expectedOrderNumber, order.getOrderNumber());
    }

}
