package com.cgi.openlayers.automated.common;

import org.openqa.selenium.By;

public class Click extends Commons {

    public static void XPATH(String XPATH) {
        element = driver.findElement(By.xpath(XPATH));
        element.click();
    }

    public static void multipleXPATH(String XPATH, String jsonValues[]) throws InterruptedException {
        String[] stringList = jsonValues;
        for (int i = 0; i < stringList.length; i++) {
            String clickMultiple = XPATH + stringList[i] + "')]";
            XPATH(clickMultiple);
        }
    }

    public static void CLASS(String CLASS) {
        element = driver.findElement(By.xpath(CLASS));
        element.click();
    }

    public static void LINK(String LINKTEXT) {
        element = driver.findElement(By.linkText(LINKTEXT));
        element.click();
    }

    public static void ID(String ID) {
        element = driver.findElement(By.id(ID));
        element.click();
    }

    public static void NAME(String NAME) {
        element = driver.findElement(By.name(NAME));
        element.click();
    }

    public static void CSSSELECTOR(String SELECTOR) {
        element = driver.findElement(By.cssSelector(SELECTOR));
        element.click();
    }
}
