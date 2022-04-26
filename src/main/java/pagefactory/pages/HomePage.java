package pagefactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name ='search']")
    private WebElement searchInput;



    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword + Keys.ENTER);

    }
}
