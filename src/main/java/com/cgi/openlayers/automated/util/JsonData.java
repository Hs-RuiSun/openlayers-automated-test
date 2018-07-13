package com.cgi.openlayers.automated.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import com.cgi.openlayers.automated.common.Commons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

public class JsonData extends Commons {
    /** JSON Connection */
    public static JSONParser jsonParser = null;
    public static JSONObject jsonObject = null;
    public static JSONObject dict = null;
    public static JSONArray scenarioList = null;
    public static JSONArray testArray = null;
    public static JSONParser testParser = null;
    public static JSONObject testObject = null;

    /** Browser which will be used for testing -- Json Value */
    public static String Browser;

    /** Test Scenario -- Json Value */
    public static String Scenario;

    /** Test Run ID - TestRail */
    public static int runID;

    /** N-Tracking Project Url */
    public static String projectUrl;
    /** Project ID from test management tool */
    public static int projectID;

    /** SpiraTest UserName */
    public static String spiraUser;

    /** SpiraTest PassWord */
    public static String spiraPass;

    /** Version number of PBS System */
    public static String version;

    /** Case ID from Spira Test Management Tool */
    public static int caseID;

    /** Test Case title from Spira Test Management Tool */
    public static String title;

    /** Release Number */
    public static String release;

    public static void jsonScenario() {
        try {
            /* Gets JSON Test Data path */
            File testFile = FileHelper.fileHelper("/TestData/Scenarios.json");
            String filePath = testFile.getAbsolutePath();
            /* Reads Test Data */
            FileReader reader = new FileReader(filePath);
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
            scenarioList = (JSONArray) jsonObject.get("Scenarios");

            Browser = (String) jsonObject.get("Browser");
            projectUrl = (String) jsonObject.get("projectUrl");
         
            projectID = (int) (long) jsonObject.get("projectID");
            spiraUser = (String) jsonObject.get("spiraUser");
            spiraPass = (String) jsonObject.get("spiraPass");
            runID = (int) (long) jsonObject.get("runID");
            version = (String) jsonObject.get("version");
        }
        catch (Exception e) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            e.printStackTrace(ps);
            ps.close();
            System.out.println(baos.toString());
            Assert.assertFalse(true);
        }
    }

    public static void jsonTest() {
        try {
            File testFile = FileHelper.fileHelper("/TestData/" + Scenario + ".json");
            String testFilePath = testFile.getAbsolutePath();
            FileReader testReader = new FileReader(testFilePath);
            testParser = new JSONParser();
            testObject = (JSONObject) testParser.parse(testReader);
            testArray = (JSONArray) testObject.get(Scenario);
        }
        catch (Exception e) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            e.printStackTrace(ps);
            ps.close();
            // Assert.assertFalse(true);
        }
    }
}
