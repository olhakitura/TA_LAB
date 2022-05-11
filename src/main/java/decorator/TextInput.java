package decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends ElementDecorator{
    public TextInput(WebElement webElement) {
        super(webElement);
    }
    public void sendKeys(CharSequence... charSequence){
        webElement.clear();
        super.sendKeys(charSequence);
    }
}
