package com.cgi.openlayers.automated.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SendKeys extends Commons {
    public static void XPATH(String XPATH, String text) {
        WebElement element = driver.findElement(By.xpath(XPATH));
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public static void ID(String ID, String text) {
        WebElement element = driver.findElement(By.id(ID));
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public static void NAME(String NAME, String Text) {
        WebElement element = driver.findElement(By.name(NAME));
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Text);
    }

    public static void CLASS(String CLASS, String Text) {
        WebElement element = driver.findElement(By.className(CLASS));
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Text);
    }
}
