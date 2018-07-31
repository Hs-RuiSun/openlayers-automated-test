package com.cgi.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Browser {
    public static void cannotFindElement(WebDriver driver) {
        driver.get("http://www.facebook.com");
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id='elementId']"));
        }catch(NoSuchElementException e) {
             System.out.println("catch exception");
        }
        System.out.println("code disappears");
    } 
    
    public static void multipleWindows(WebDriver driver) {
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                driver.close();
            }
        }
        driver.switchTo().window(MainWindow);
    }

    public static void navigate(WebDriver driver) {
        String baseUrl = "http://www.google.com";
        driver.get(baseUrl);
    }

    public static void switchTab(WebDriver driver) {
        driver.manage().window().maximize();
        // driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t"); //can't open a new tab????
        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    /**
     * 1. window.scrollBy
     * 2. scroll a specific element into view
     * @param driver
     * @throws InterruptedException
     */
    public static void scroll(WebDriver driver) throws InterruptedException {
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        /*
        //window scrollBy
        jse.executeScript("window.scrollBy(0,4500)", ""); //scroll down
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0, -1000)", ""); //scroll up
         */        
        
        //WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/p[8]/img"));
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        System.out.println(element.getText());
    }

    public static void createScreenShot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*
         * System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe"); WebDriver driver = new
         * FirefoxDriver();
         */
        /*navigate(driver);
        scroll(driver);
        createScreenShot(driver);*/
        //multipleWindows(driver);
        cannotFindElement(driver);
    }
}
