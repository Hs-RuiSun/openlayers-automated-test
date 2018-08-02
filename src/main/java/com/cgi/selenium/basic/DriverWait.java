package com.cgi.selenium.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverWait {
    public static void isVisible(WebDriver driver) {
        driver.get("file:///C:/Users/ruby.sun/Downloads/selenium.html");
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inpute")));
        WebElement element = driver.findElement(By.id("input"));
        element.sendKeys("yeah");
    }
    
    public static void isEnabled(WebDriver driver) {
        driver.manage().window().maximize();
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        driver.get(contactUrl);
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

        WebElement saveButton = driver.findElement(By.id("demo"));

        if (saveButton.isDisplayed() == true) {
            System.out.println("save button is displayed");
        }

        if (saveButton.isEnabled() == false) {
            System.out.println("save button is not enabled");
        }

        WebElement javaRadioButton = driver.findElement(By.id("java1"));

        (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(javaRadioButton));

        javaRadioButton.click();

        if (saveButton.isEnabled() == true) {
            System.out.println("save button is enabled");
        }
    }


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        isVisible(driver);
    }
}
