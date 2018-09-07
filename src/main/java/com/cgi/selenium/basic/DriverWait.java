package com.cgi.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DriverWait {
    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isCompleted = wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
            }
        });
        System.out.println("is completed? " + isCompleted);
    }

    public static void testFluentWait(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        WebElement seleniumCheckbox = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("seleniumboxe"));
            }
        });
        /*
         * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("seleniumboxe"))); WebElement seleniumCheckbox
         * = driver.findElement(By.id("seleniumboxe"));
         */
        if (seleniumCheckbox == null) {
            System.out.println("no element is found");
            return;
        }
        System.out.println(seleniumCheckbox.isDisplayed());
    }

    public static void isEnabled(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seleniumbox")));
        WebElement seleniumCheckbox = driver.findElement(By.id("seleniumbox"));
        WebElement restCheckbox = driver.findElement(By.id("restapibox"));
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(seleniumCheckbox));
        if (seleniumCheckbox.isSelected() == false) {
            seleniumCheckbox.click();
        }
        if (restCheckbox.isSelected() == false) {
            restCheckbox.click();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        driver.get(url);
        testFluentWait(driver);
    }
}
