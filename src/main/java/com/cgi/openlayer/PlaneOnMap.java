package com.cgi.openlayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PlaneOnMap {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String script = "var layers = map.getLayers();\r\n" + 
                "var layer = layers.item(10);\r\n" + 
                "var source = layer.getSource();\r\n" + 
                "var features = source.getFeatures();\r\n" + 
                "var aircraft = features[0];\r\n" + 
                "var aircraftCoord = aircraft.getGeometry().getCoordinates();\r\n" + 
                "var aircraftPix = map.getPixelFromCoordinate(aircraftCoord)\r\n" + 
                "return aircraftPix;";
        List<Double> aircraftPixels = (List<Double>)((JavascriptExecutor)driver).executeScript(script);
        /* need to do some pixel processing*/
        Actions actionBuilder = new Actions(driver);
        Action action = actionBuilder.moveByOffset(aircraftPixels.get(0).intValue(), aircraftPixels.get(1).intValue())
                .click()
                .build();
        action.perform();
        /* verify click reaction to know if we click on a plane*/
    }
}
