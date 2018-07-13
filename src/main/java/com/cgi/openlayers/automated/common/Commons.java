package com.cgi.openlayers.automated.common;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Commons {
    /* Global Elements */
    public static WebDriver driver;
    public static WebElement element;

    /** Project URL */
  // public static String projectUrl = "www.gmail.com";

    /** To Run test suites */
    public static JUnitCore core = new JUnitCore();

    /** Junit Test Result */
    public static Result result = null;

    /** Test Result */
    public static String TestResult = null;

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
