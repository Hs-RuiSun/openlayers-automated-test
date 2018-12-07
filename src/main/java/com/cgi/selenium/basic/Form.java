package com.cgi.selenium.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Form {

    public static WebElement findElement(WebDriver driver) {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        WebElement element;
        try {
            element = driver.findElement(By.name("cuside"));
        } catch (Exception e) {
            System.out.println("will you come here?");
        }
        return null;
    }

    public static void alert(WebDriver driver) {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Text");
        System.out.println(alertMessage);
        alert.accept();
    }

    public static void link(WebDriver driver) {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String underConsTitle = "Under Construction: Mercury Tours";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(baseUrl);
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals(underConsTitle)) {
                System.out.println("\"" + t + "\"" + " is under construction.");
            } else {
                System.out.println("\"" + t + "\"" + " is working.");
            }
            driver.navigate().back();
        }
    }

    public static void select(WebDriver driver) {
        String baseURL = "http://demo.guru99.com/test/newtours/register.php";
        driver.get(baseURL);
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("ANTARCTICA");
        // Selecting Items in a Multiple SELECT elements
        driver.get("http://jsbin.com/osebed/2");
        Select fruits = new Select(driver.findElement(By.id("fruits")));
        fruits.selectByVisibleText("Banana");
        fruits.selectByIndex(1);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"fruits\"]/option[1]")).getAttribute("checked"));
    }

    public static void radioCheckbox(WebDriver driver) {
        driver.get("http://demo.guru99.com/test/radio.html");
        //input type=radio or type=checkbox
        List<WebElement> list = driver.findElements(By.xpath("/html/body/div/input"));
        for (WebElement element : list) {
            element.click();
        }

        WebElement element = driver.findElement(By.id("vfb-6-1"));
        System.out.println(element.getAttribute("checked"));
    }

    public static void login(WebDriver driver) {
        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("passwd"));
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");

        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");
    }

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        radioCheckbox(driver);
        // login(driver);
        // driver.close();
    }
}
