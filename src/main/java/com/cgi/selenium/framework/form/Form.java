package com.cgi.selenium.framework.form;

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
    public static void mouse(WebDriver driver) {
        String baseUrl = "http://facebook.com";
        driver.get(baseUrl);
        WebElement txtUsername = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder.moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick()
                .contextClick()
                .build();
        seriesOfActions.perform();
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
            }
            else {
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
    }

    public static void login(WebDriver driver) {
        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("passwd"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");

        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");

        // using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");

        driver.get("http://demo.guru99.com/test/radio.html");
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));

        // Radio Button1 is selected
        radio1.click();
        System.out.println("Radio Button Option 1 Selected");

        // Radio Button1 is de-selected and Radio Button2 is selected
        radio2.click();
        System.out.println("Radio Button Option 2 Selected");

        // Selecting CheckBox
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));

        // This will Toggle the Check box
        option1.click();

        // Check whether the Check box is toggled on
        if (option1.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        }
        else {
            System.out.println("Checkbox is Toggled Off");
        }

        // Selecting Checkbox and using isSelected Method
        driver.get("http://demo.guru99.com/test/facebook.html");
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
        for (int i = 0; i < 2; i++) {
            chkFBPersist.click();
            System.out.println("Facebook Persists Checkbox Status is -  " + chkFBPersist.isSelected());
        }
    }

    public static void main(String[] args) {

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        mouse(driver);

        // driver.close();

    }
}
