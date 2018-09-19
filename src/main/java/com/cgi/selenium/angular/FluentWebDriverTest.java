package com.cgi.selenium.angular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

public class FluentWebDriverTest {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();
        FluentWebDriver fwd = new FluentWebDriver(wd);

        //fwd.element("fooelementname").element("barelementname", className("bar")).button().click();

    }
}
