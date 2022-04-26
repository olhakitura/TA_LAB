package pagefactory.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pagefactory.pages.CartPage;
import pagefactory.pages.HomePage;
import pagefactory.pages.ProductListingPage;
import util.PropertiesReader;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;

    String url = new PropertiesReader().getUrl();


    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();

    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ProductListingPage getProductListingPage() {
        return new ProductListingPage(getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }


}
