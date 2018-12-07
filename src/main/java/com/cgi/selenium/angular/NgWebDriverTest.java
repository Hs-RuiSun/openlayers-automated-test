package com.cgi.selenium.angular;

import com.cgi.selenium.Config;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class NgWebDriverTest {
    @Autowired
    private WebDriver driver;

    @Test
    public void testNgWebDriver() throws InterruptedException {

        driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
        NgWebDriver ngdriver = new NgWebDriver((JavascriptExecutor) driver);

        driver.findElement(ByAngular.model("name")).sendKeys("Test Company");
        driver.findElement(ByAngular.model("employees")).sendKeys("1000");
        driver.findElement(ByAngular.model("headoffice")).sendKeys("Mysore");
        driver.findElement(ByAngular.buttonText("Submit")).click();

        Thread.sleep(2000);
        String txt = driver.findElement(ByAngular.repeater("company in companies").row(4).column("name")).getText();
        System.out.println(txt + " Added.");

        if (txt.equalsIgnoreCase("Test Company")) {
            System.out.println("New Company Added. Now remove it");
            driver.findElement(ByAngular.repeater("company in companies").row(4)).findElement(ByAngular.buttonText("Remove")).click();
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
