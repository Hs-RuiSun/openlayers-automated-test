package com.cgi.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DriverAction {
    public static void dragDrop(WebDriver driver) {
        driver.get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        Action dragAndDrop = new Actions(driver).clickAndHold(From)
                                                .moveToElement(To)
                                                .release(To)
                                                .build();
        dragAndDrop.perform();
    }
    public static void mouse(WebDriver driver) {
        String baseUrl = "http://facebook.com";
        driver.get(baseUrl);
        WebElement txtUsername = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder.moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick()
                .contextClick()   //right click
                .build();
        seriesOfActions.perform();
    }
    
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        dragDrop(driver);
    }
}
