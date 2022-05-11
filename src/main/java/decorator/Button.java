package decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

public class Button extends ElementDecorator{

    public Button(WebElement webElement) {
        super(webElement);
    }
    public void click(){
        try{
            super.click();
        }catch(ElementClickInterceptedException e){
            super.click();
        }
    }
}
