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
        Logger logger = LogManager.getLogger("ASYNC_JSON_FILE_APPENDER");
        Exception e = new Exception("This is only a test!");
        String newUrl = new PropertiesReader().getNewUrl();

        getHomePage().searchByKeyword(testData.getName());
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getBrandCheckbox());
        getProductListingPage().clickCheckbox();
        getDriver().get(newUrl);
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getAddToCartButton());
        getProductListingPage().clickAddToCartButton();
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getMiniCartButton());
        getProductListingPage().clickMiniCartButton();
        getProductListingPage().closePopUp();
        getProductListingPage().waitElementToBeClickable(30, getProductListingPage().getMiniCartButton());
        getProductListingPage().clickMiniCartButton();
        getCartPage().waitForAjaxToCompletePdp(30);
        assertFalse(Integer.getInteger(getCartPage().getPrice()) <= Integer.getInteger(testData.getSum()));
        logger.error("This is a simple message at ERROR level. " +
                "This is the minimum visible level.", e);


    }


}
