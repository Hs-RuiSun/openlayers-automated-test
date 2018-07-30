package com.cgi.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{
    @FindBy(id="map")
    private WebElement map;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
