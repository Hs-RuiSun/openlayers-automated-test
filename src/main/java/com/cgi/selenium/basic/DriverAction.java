package com.cgi.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DriverAction {
    public static void clickAfterRefresh(WebDriver driver) {
        driver.get("http://demo.guru99.com/popup.php");
        WebElement element = driver.findElement(By.xpath("/html/body/p/a"));
        Point link = element.getLocation();
        int x = link.getX() + 2;
        int y = link.getY() + 2;
        driver.navigate().refresh();
        Actions action = new Actions(driver);
        action.moveByOffset(x, y).click().build().perform();
    }

    public static void openInANewTab(WebDriver driver) {
        driver.get("http://seleniumtutorialpoint.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"post-393\"]/div/div/ul/li[1]/strong/a"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        //switching control to new tab
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        //action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
       /* Actions mouseAction = new Actions(driver);
        Action openInNewTab = mouseAction.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
        openInNewTab.perform();*/
        /*Action openInNewWindow = mouseAction.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
        openInNewWindow.perform();*/
    }

    public static void dragDrop(WebDriver driver) {
        driver.get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        Action dragAndDrop = new Actions(driver).clickAndHold(From)
                .moveToElement(To)
                .release(To)
                .build();
        dragAndDrop.perform();
    }

    public static void mouse(WebDriver driver) {
        String url = "https://www.facebook.com/";
        driver.get(url);
        WebElement button = driver.findElement(By.id("//*[@id=\"u_0_2\"]"));
        Actions mouseMoveClick = new Actions(driver);
        System.out.println(button.getLocation().getX() + "," + button.getLocation().getX());
        Action action = mouseMoveClick.moveByOffset(button.getLocation().getX(), button.getLocation().getX()).click().build();
        action.perform();
        /*String baseUrl = "http://facebook.com";
        driver.get(baseUrl);
        WebElement txtUsername = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder.moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick()
                .contextClick()   //right click
                .build();
        seriesOfActions.perform();*/
    }

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        openInANewTab(driver);
    }
}
