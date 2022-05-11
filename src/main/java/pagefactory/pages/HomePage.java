package pagefactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='customer-button search-icon js-search-open']" )
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='input_search']")
    private WebElement searchInput;

    public HomePage() {

    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword + Keys.ENTER);

    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}
