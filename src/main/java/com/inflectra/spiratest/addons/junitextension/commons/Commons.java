package com.inflectra.spiratest.addons.junitextension.commons;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import java.util.List;

public class Commons {
    /* Global Elements */
    public static WebDriver driver;
    public static WebElement element;
    public static List<WebElement> elements;

    /** Project URL */
    public static String projectUrl = "http://web6.qa.navtechinc.com/";

    /** To Run test suites */
    public static JUnitCore jUnitCore = new JUnitCore();

    /** Test Result */
    public static String spiraTestResult = null;

    /** Junit Test Result */
    public static Result junitTestResult = null;

    /** Actual Value */
    public static String actualResult = null;

    /** Expected Result */
    public static String expectedResult = null;

    /** Test Case Execution Start Time */
    public static long startTime_case;

    /** Test Case Execution End Time */
    public static long endTime_case;

    /** Test Start Time */
    public static long startTime;

    /** Test End Time */
    public static long endTime;

    /** Test Execution total time */
    public static long totalTime;

    /** FluentWait object */
    public static WebDriverWait waitElement;

    /** screen object for Sikuli */
    public static Screen screen;

    /** action object */
    public static Actions action;

}
