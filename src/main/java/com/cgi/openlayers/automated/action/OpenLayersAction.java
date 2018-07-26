package com.cgi.openlayers.automated.action;

import com.cgi.openlayers.automated.common.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OpenLayersAction extends Commons{
    public static void getAircraft() throws IOException {
        //0 maximize browser
        driver.manage().window().maximize();
        
        //1. get map element's offset, because all the elements on map are relative to map 
        String mapXPath = "//*[@id=\"map\"]";
        WebElement map = driver.findElement(By.xpath(mapXPath));
        int offX = map.getLocation().getX();
        int offY = map.getLocation().getY();
        
        //2. code needs to do this after comparing determined and actual coordinates
        offX = offX - 45;
        offY = offY - 25;

        //3. wait until other section appears
        String otherToggleXPath = "//*[@id=\"aircraft-selection\"]/div[3]/div[1]/table[1]/tbody[last()]/tr/th/span[contains(text(), 'Other')]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otherToggleXPath)));
        
        //4. click Airport link
        String airportLinkXPath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/a";
        driver.findElement(By.xpath(airportLinkXPath)).click();
        try {
            System.out.println("Waiting for 3 seconds");
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e) {
            System.out.println("Unable to wait");
        }
        
        //5. go back map
        String mapLinkXPath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/a";
        driver.findElement(By.xpath(mapLinkXPath)).click();
        
        //6. get one of 'other' flight
        String openLayerScript = "var layers = map.getLayers();\r\n" + 
                "var layer = layers.item(10);\r\n" + 
                "var source = layer.getSource();\r\n" + 
                "var features = source.getFeatures();\r\n" + 
                "var aircraft = features[0];\r\n" + 
                "var aircraftCoord = aircraft.getGeometry().getCoordinates();\r\n" + 
                "var aircraftPix = map.getPixelFromCoordinate(aircraftCoord);" + 
                "return aircraftPix";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;         
        ArrayList<Double> aircraftCoord = (ArrayList<Double>) jsExecutor.executeScript(openLayerScript); 
        
        //7. move mouse to aircraft and click
        Actions mouseMoveClick = new Actions(driver);
        System.out.println((aircraftCoord.get(0).intValue() + offX) + "," + (aircraftCoord.get(1).intValue() + offY));
        mouseMoveClick.moveByOffset((aircraftCoord.get(0).intValue() + offX),(aircraftCoord.get(1).intValue() + offY))
                      .click()
                      .build()
                      .perform();
        
        //8. verify flight detail panel pop-up
        String flightPanelXPath = "//*[@id=\"flight-details-title\"]/div";
        try {
            WebElement flightPanel = driver.findElement(By.xpath(flightPanelXPath));
            System.out.println("find flight panel element, yeah!!!!");
        }catch(Exception e) {
            System.out.println("couldn't find flight panel element");
        }
    }
}