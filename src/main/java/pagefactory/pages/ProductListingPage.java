package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductListingPage extends BasePage{
    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    //select[@class ='select-css ng-valid ng-star-inserted ng-dirty ng-touched']/option[text() = ' От дорогих к дешевым ']
    @FindBy(xpath ="//a[@data-id ='HP']")
    private WebElement checkboxBrand;

    @FindBy(xpath = "//select[@class ='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement sortFilter;

    @FindBy(xpath = "//input[@class='sidebar-search__input ng-pristine ng-valid ng-touched']")
    private WebElement searchFieldBrand;

    @FindBy(xpath = "//div[@class='goods-tile__inner'][1]")
    private WebElement firstProductInProductList;

    @FindBy(xpath = "//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='header__button ng-star-inserted']")
    private WebElement miniCartButton;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement popUpButton;

    public void clickCheckbox(){
        checkboxBrand.click();
    }


    public void fillSearchField(String brand){
        searchFieldBrand.sendKeys(brand);
    }

    public WebElement getBrandCheckbox(){
        return checkboxBrand;
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }


    public WebElement getMiniCartButton(){
        return miniCartButton;
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickMiniCartButton(){
        miniCartButton.click();
    }

    public void closePopUp(){
        Actions clickAction = new Actions(driver).click(popUpButton);
        clickAction.build().perform();
    }
}
