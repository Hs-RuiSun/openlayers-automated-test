package com.cgi.selenium.devtool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class DriverLog {
    private static WebDriver driver;

    public void setUp() throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new Augmenter().augment(new ChromeDriver(caps));
        /*System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        driver = new Augmenter().augment(new FirefoxDriver(caps));*/
    }

    public static void main(String[] argv) throws Exception {
        DriverLog profiler = new DriverLog();
        profiler.setUp();
        try {
            profiler.ntracking();
            /**
             * method-1: run JavaScript
             */
            String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
            String netData = ((JavascriptExecutor) driver).executeScript(scriptToExecute).toString();
            System.out.println(netData);
        } finally {
            profiler.tearDown();
        }
    }

    public void ntracking() {
        driver.get("http://192.168.1.138:2020/#!/map");
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//*[@id=\"username\"]"))));
        WebElement usernameElement = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement signinElement = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        usernameElement.sendKeys("userGFI");
        passwordElement.sendKeys("gfi2015");
        signinElement.click();
    }

    public void tearDown() throws Exception {
        try {
            /**
             * method-2: get driver logs
             */
            Logs logs = driver.manage().logs();
            System.out.println("Log types: " + logs.getAvailableLogTypes());
            List<LogEntry> entries = driver.manage().logs().get(LogType.PROFILER).getAll();
            System.out.println("Is profiler log empty? " + entries.size());
            printLog(LogType.BROWSER);
        } finally {
            driver.quit();
        }
    }

    void printLog(String type) throws IOException {
        List<LogEntry> entries = driver.manage().logs().get(type).getAll();
        System.out.println(entries.size() + " " + type + " log entries found");
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("C:\\Users\\ruby.sun\\Downloads\\log.txt")));
        for (LogEntry entry : entries) {
            //JSONObject message = new JSONObject(entry.getMessage());
            //JSONObject devToolsMessage = message.getJSONObject("message");

            //if(devToolsMessage.getString("method").equals("Network.responseReceived")) {
            //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            br.write(entry.getMessage() + "\r\n");
            //}
        }
        br.flush();
        br.close();
    }
}
