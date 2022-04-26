package pagefactory.tests;

import model.TestData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import util.PropertiesReader;
import util.XmlToObject;

import static org.testng.Assert.assertFalse;

public class AddToCartTest extends BaseTest {


    @Test
    public void checkAddToCart() {
        XmlToObject xmlToObject = new XmlToObject();
        TestData testData = xmlToObject.convert();
        Logger logger = LogManager.getLogger("devpinoyLogger");
        String newUrl = new PropertiesReader().getNewUrl();

        getHomePage().searchByKeyword(testData.getName());
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getBrandCheckbox());
        getProductListingPage().clickCheckbox();
        getDriver().get(newUrl);
        logger.debug("Changed default filters");
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getAddToCartButton());
        getProductListingPage().clickAddToCartButton();
        logger.debug("Added to cart");
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getMiniCartButton());
        getProductListingPage().clickMiniCartButton();
        logger.debug("Opened cart");
        getProductListingPage().closePopUp();
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getMiniCartButton());
        getProductListingPage().clickMiniCartButton();
        logger.debug("Checking sum");
        getCartPage().waitForAjaxToCompletePdp(30);
        assertFalse(Integer.getInteger(getCartPage().getPrice()) <= Integer.getInteger(testData.getSum()));



    }


}
