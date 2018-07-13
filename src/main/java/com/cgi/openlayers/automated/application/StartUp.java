package com.cgi.openlayers.automated.application;

import com.cgi.openlayers.automated.common.Commons;
import com.cgi.openlayers.automated.json.LoginPageJson;
import com.cgi.openlayers.automated.json.Maps_OthersToggleJson;
import com.cgi.openlayers.automated.json.WeatherConfigJson;
import com.cgi.openlayers.automated.util.Driver;
import com.cgi.openlayers.automated.util.JsonData;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import org.sikuli.script.ImagePath;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUp extends Commons{
    public static void main(String[] args) throws Exception {

        try {
            startTime = System.currentTimeMillis();
            ImagePath.add("testRun.NTrackingMain/images");
            // Read the values from *.json files
            JsonData.jsonScenario();
            for (int i = 0; i < JsonData.scenarioList.size(); i++) {
                JsonData.dict = (JSONObject) JsonData.scenarioList.get(i);
                JsonData.Scenario = JsonData.dict.get("Scenario").toString();

                /* Get Test values from *.json */
                JsonData.jsonTest();
                // Open Browser which will be used
                Driver.openBrowser();
                System.out.println(JsonData.Scenario);

                for (int j = 0; j < JsonData.testArray.size(); j++) {
                    startTime_case = System.currentTimeMillis();
                    // Creates dictionary for test Json file
                    JsonData.dict = (JSONObject) JsonData.testArray.get(j);
                    // Gets the Array values from *.json file
                    JsonData.title = JsonData.dict.get("title").toString();
                    JsonData.caseID = (int) (long) (JsonData.dict.get("caseID"));
                    System.out.println(JsonData.title); 

                    if (JsonData.Scenario.equals("LoginTest")) {
                        LoginPageJson.getJSON();
                        result = core.run(WebApp_LoginMain.class);
                    }  
                    if (JsonData.Scenario.equals("Maps_OthersToggle")) {
                        Maps_OthersToggleJson.getJSON();
                        result = core.run(Maps_OthersToggleMain.class);
                    }
                    if (JsonData.Scenario.equals("weatherConfigTab")) {
                        WeatherConfigJson.getJSON();
                        result = core.run(Weather_ConfigMain.class);
                    }

                    endTime_case = System.currentTimeMillis();
                    totalTime = endTime_case - startTime_case;
                    System.out.println(String.format("Test Execution time: %d min, %d sec ",
                            TimeUnit.MILLISECONDS.toMinutes(totalTime), TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))));

                    // Send results to Test Management Tool
                    //TestResults.testResults();
                }
                endTime = System.currentTimeMillis();
                totalTime = endTime - startTime;
                System.out.println(String.format("\nTotal Time: %d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(totalTime), TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))));

            }
        }
        catch (Exception e) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            e.printStackTrace(ps);
            ps.close();
            System.out.println(baos.toString());
            TestResult = baos.toString();
        }

    }
}
