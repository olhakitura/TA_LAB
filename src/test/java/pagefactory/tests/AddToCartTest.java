package pagefactory.tests;

import businessobject.ChangeFilter;
import businessobject.Search;
import model.Filter;
import model.Filters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ListenerTest;
import util.XmlToObject;

import java.util.List;

@Listeners(ListenerTest.class)

public class AddToCartTest extends BaseTest {
    private static final int WAITING_TIME = 200;

    static final Logger logger = Logger.getLogger(AddToCartTest.class);

    @DataProvider(name="data", parallel = true)
    public Object[][] dataFirst() {
        XmlToObject xmlToObject = new XmlToObject();
        Filters filter = xmlToObject.convert();
        List <Filter> filters = filter.getFilters();
        return new Object[][] {
                {filters.get(0) },
                {filters.get(1) },
                {filters.get(2) },
                {filters.get(3) },
                {filters.get(4) }
        };

    }

    @Test(dataProvider = "data")
    public void checkAddToCart(Filter filter){
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        getHomePage().waitForPageLoadComplete(WAITING_TIME );
        getHomePage().waitElementToBeClickable(WAITING_TIME , getHomePage().getSearchButton());
        new Search().searchByKeyword(filter.getName());
        logger.info("The search word is entered.");
        getProductListingPage().waitForPageLoadComplete(WAITING_TIME );
        getProductListingPage().waitElementToBeClickable(WAITING_TIME , getProductListingPage().getSortFilters().get(1));
        new ChangeFilter().changeFilter(filter.getFiltersearch());
        logger.info("The filter is changed.");
        getProductListingPage().waitForAjaxToComplete(WAITING_TIME );
        getProductListingPage().clickBuyButton();
        getProductListingPage().waitForAjaxToComplete(WAITING_TIME );
        getProductListingPage().clickMiniCartButton();
        logger.info("The cart is open.");
        getCartPage().waitForPageLoadComplete(WAITING_TIME);
        Assert.assertTrue(Integer.parseInt(getCartPage().getPrice()) <= Integer.parseInt(filter.getSum()));

    }


}
