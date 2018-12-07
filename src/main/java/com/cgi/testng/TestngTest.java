package com.cgi.testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TestngTest {
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter;

    @BeforeClass
    public void setupBeforeClass(ITestContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd_hhmmss");
        String formattedDate = sdf.format(new Date());
        System.out.println(System.getProperty("user.dir") + "\\report" + formattedDate + ".html");
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\report" + formattedDate + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }

    public void testngXml() {

    }

    @DataProvider(name = "multipleParameters")
    public static Object[][] multipleParameters() {
        return new Object[][]{{1, "haha"}, {2, "hahaha"}};
    }

    @DataProvider(name = "testData")
    public static Iterator<Object[]> dataProvider() {
        Collection<Object[]> ret = new ArrayList<Object[]>();
        Object[] testData = {1, "test dataProvider"};
        ret.add(testData);
        //.......
        return ret.iterator();
    }

    @Test(dataProvider = "multipleParameters")
    public void dataProviderTest(int caseId, String testCase) {
        ExtentTest extentTest = extent.createTest("dataProviderTest");
        extentTest.log(Status.INFO, "going well");
    }

    @Test
    @Parameters({"userName", "password"})
    public void parameterTest(String userName, String password) {
        ExtentTest extentTest = extent.createTest("parameterTest");
        extentTest.log(Status.FAIL, "isn't going well");
        extentTest.error("error appears");
    }
}
