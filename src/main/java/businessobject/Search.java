package businessobject;

import pagefactory.pages.HomePage;

public class Search {
    public void searchByKeyword(String object){
        HomePage homePage = new HomePage();
        homePage.clickSearchButton();
        homePage.searchByKeyword(object);
        }
    }

