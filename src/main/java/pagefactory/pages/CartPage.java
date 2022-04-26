package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span[1]")
    private WebElement cartReceiptPrice;

    public String getPrice(){
        return cartReceiptPrice.getText();
    }

}
