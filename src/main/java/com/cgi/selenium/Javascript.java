package com.cgi.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Javascript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "var arr = [555,666]; var aircraftCoord = function(){ return arr}; return arr;";
        ArrayList aircraftCoord = (ArrayList) js.executeScript(javascript); 
        System.out.println(aircraftCoord);
        
    }
}
