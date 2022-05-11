package businessobject;

import pagefactory.pages.ProductListingPage;

public class ChangeFilter {
    public void changeFilter(String filtersearch){
        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.selectSortFilter(filtersearch);
    }
}
