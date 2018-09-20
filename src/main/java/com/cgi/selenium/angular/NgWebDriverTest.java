package com.cgi.selenium.angular;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NgWebDriverTest {
    public static WebDriver webDriver;
    public static NgWebDriver ngWebDriver;
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
        webDriver.manage().window().maximize();
        
        ngWebDriver = new NgWebDriver((JavascriptExecutor)webDriver);
        
        webDriver.findElement(ByAngular.model("name")).sendKeys("Test Company");
        webDriver.findElement(ByAngular.model("employees")).sendKeys("1000");
        webDriver.findElement(ByAngular.model("headoffice")).sendKeys("Mysore");
        webDriver.findElement(ByAngular.buttonText("Submit")).click();
    }
}
