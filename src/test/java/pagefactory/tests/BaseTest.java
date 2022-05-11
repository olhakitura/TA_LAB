package pagefactory.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pagefactory.pages.CartPage;
import pagefactory.pages.HomePage;
import pagefactory.pages.ProductListingPage;
import util.WebdriverSingleton;

public class BaseTest {
    public WebDriver getDriver(){return WebdriverSingleton.getInstance();
    }


    @BeforeTest
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void testsSetUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebdriverSingleton.close();
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
