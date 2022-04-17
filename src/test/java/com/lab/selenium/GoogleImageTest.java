package com.lab.selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;

public class GoogleImageTest {

    private WebDriver driver;
    private static final String GOOGLE_URL="http://google.com/";



    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();

    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GOOGLE_URL);
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath){

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkImageTabContainsImages(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.name("q")).sendKeys("image" + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-hveid='CAEQAw']"))).click();
        List<WebElement> myImages = driver.findElements(xpath("//img[contains(@src, 'data:image/')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(myImages));
        takeSnapShot(driver, "screenshots/google.jpeg");
        assertTrue(myImages.stream().allMatch(WebElement::isDisplayed));


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }



}
