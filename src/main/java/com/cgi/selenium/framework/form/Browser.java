package com.cgi.selenium.framework.form;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;

public class Browser {
    public static void navigate(WebDriver driver) {
        String baseUrl = "http://www.google.com";
        driver.get(baseUrl);
    }
    
    public static void switchTab(WebDriver driver) {
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");  //can't open a new tab????
        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    
    public static void scroll(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String scroll = "window.scroll(0, 10)";
        jse.executeScript(scroll, "");
    }
    
    public static void createScreenShot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());
    }
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
        
        navigate(driver);
        scroll(driver);
        createScreenShot(driver);
    }
}
