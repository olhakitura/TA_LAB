package pagefactory.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends BasePage{
    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//a[@data-id ='HP']")
    private WebElement checkboxBrand;

    @FindBy(xpath ="//div[@class='sort']/a")
    private List<WebElement> sortFilters;

    @FindBy(xpath = "//input[@class='sidebar-search__input ng-pristine ng-valid ng-touched']")
    private WebElement searchFieldBrand;

    @FindBy(xpath = "//div[@class='goods-tile__inner'][1]")
    private WebElement firstProductInProductList;

    @FindBy(css = "//div[@id='gotoproducts']//ul[@id='notliders']/li[1]//input[@value='Купить']" )
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='customer-link header-cart customer-links-hover']/a[@href='cart']")
    private WebElement miniCartButton;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement popUpButton;

    @FindBy(xpath = "//div[@id = 'bottom_bar")
    private WebElement bottomBar;

    @FindBy(xpath = "//a[text()='x']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@id='gotoproducts']//ul[@id='notliders']/li[1]//span[@class='pricetiny'][1]")
    private WebElement priceTiny;

    public ProductListingPage() {
        super();
    }

    public void clickCheckbox(){
        checkboxBrand.click();
    }


    public void fillSearchField(String brand){
        searchFieldBrand.sendKeys(brand);
    }

    public void selectSortFilter(String filter){
        for(WebElement i: sortFilters){
            if(i.getText().equals(filter)){
                i.click();
            }
        }
    }

    public List<WebElement> getSortFilters(){
        return sortFilters;
    }

    public WebElement getMiniCartButton(){
        return miniCartButton;
    }


    public void clickBuyButton() {
        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[value=Купить]).click();");

    }

    public WebElement getBuyButton() {return  buyButton;}



    public void clickMiniCartButton(){
        miniCartButton.click();
    }


    public WebElement getPriceTiny(){return priceTiny;}

    public void closePopUp(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
/*
        Actions clickAction = new Actions(driver).click(closeButton);
        clickAction.build().perform();

 */
    }
}
