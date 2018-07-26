package com.cgi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File {
    public static void upload(WebDriver driver) {
        String baseUrl = "http://demo.guru99.com/test/upload/";
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        uploadElement.sendKeys("C:\\Users\\ruby.sun\\Downloads\\TestSuite.xlsx");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
    }
    public void download(WebDriver driver) {
        
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        upload(driver);
    }
}
