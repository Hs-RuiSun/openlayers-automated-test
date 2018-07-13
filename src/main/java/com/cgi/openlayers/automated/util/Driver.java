package com.cgi.openlayers.automated.util;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.cgi.openlayers.automated.common.Commons;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver extends Commons {
    /** Run browser */
    public static void openBrowser() throws Exception {
        try {
            if (JsonData.Browser.contains("Firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Windows.mainWindow = driver.getWindowHandle();
            }
            else if (JsonData.Browser.contains("IE")) {
                System.setProperty("webdriver.ie.driver", "Z:\\Drivers\\IEDriverServer.exe");
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("internet explorer");
                capability.setPlatform(Platform.WINDOWS);
                capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
                capability.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                if (JsonData.Browser.equals("IEGrid")) {
                    driver = new RemoteWebDriver(new URL("http://10.12.12.219:4444/wd/hub"), capability);
                }
                else if (JsonData.Browser.equals("IE")) {
                    driver = new InternetExplorerDriver();
                }
                Windows.mainWindow = driver.getWindowHandle();
                driver.manage().window().maximize();
            }
            else if (JsonData.Browser.contains("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.WINDOWS);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--enable-automation");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                // capability.setCapability(ChromeOptions.CAPABILITY, options);
                // capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                if (JsonData.Browser.equals("Chrome")) {
                    driver = new ChromeDriver(options);
                }
                else if (JsonData.Browser.equals("ChromeGrid")) {
                    driver = new RemoteWebDriver(new URL("http://10.12.12.219:4444/wd/hub"), options);
                }
                Windows.mainWindow = driver.getWindowHandle();
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void close() throws IOException {
        driver.close();
    }
}
