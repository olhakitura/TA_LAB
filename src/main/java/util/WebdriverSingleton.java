package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private WebDriver driver;
    private static PropertiesReader propertiesReader = new PropertiesReader();


    public WebdriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }

        WebDriver instance;

        instance  = new ChromeDriver(){
            {manage().window().maximize();
            get(propertiesReader.getUrl());
            }
        };
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }

    public static void close(){
        try{
            if (webDriverThreadLocal !=null){
                webDriverThreadLocal.get().quit();
            }
        } catch(Exception e){
            System.err.println("ERROR: Can not close WebDriver!");
        }finally {
            webDriverThreadLocal.remove();
        }


    }
}