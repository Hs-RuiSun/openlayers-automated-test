package com.cgi.openlayers.automated.common;

import org.openqa.selenium.By;

public class Displayed extends Commons {
    public static boolean LINK(String LINKTEXT) {
        element = driver.findElement(By.linkText(LINKTEXT));
        return element.isDisplayed();
    }

    public static boolean NAME(String NAME) {
        element = driver.findElement(By.name(NAME));
        return element.isDisplayed();
    }

    public static boolean XPATH(String XPATH) {
        element = driver.findElement(By.xpath(XPATH));
        // String location = element.getLocation().toString();
        int count = 0;
        /*while (!element.isDisplayed()) {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(element.getLocation().x + ", " + element.getLocation().y + ", " + count++);
        }*/
        return element.isDisplayed();
    }

    public static boolean CLASS(String CLASS) {
        element = driver.findElement(By.className(CLASS));
        return element.isDisplayed();
    }
}
