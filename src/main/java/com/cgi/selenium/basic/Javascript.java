package com.cgi.selenium.basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Javascript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String javascript = "return [613.0450345394756, 142.1858329595642];";
        String[] aircraftCoord = (String[]) js.executeScript(javascript);
        System.out.println(aircraftCoord);

    }
}
