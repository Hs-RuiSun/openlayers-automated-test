package com.cgi.openlayers.automated.application;

import com.cgi.openlayers.automated.action.LoginAction;
import com.cgi.openlayers.automated.action.WeatherConfigActions;
import com.cgi.openlayers.automated.common.Commons;
import com.cgi.openlayers.automated.common.Displayed;
import com.cgi.openlayers.automated.json.WeatherConfigJson;
import com.cgi.openlayers.automated.util.JsonData;
import com.cgi.openlayers.automated.util.ScreenShot;
import com.cgi.openlayers.automated.xpath.WeatherConfigXpath;
import org.junit.Assert;
import org.junit.Test;

public class Weather_ConfigMain extends Commons {
    @Test

    public void testWeather() throws InterruptedException {

        ScreenShot.screenShot();
        TestResult = "";
        Assert.assertTrue(true);

        driver.get(JsonData.projectUrl);
        if (WeatherConfigJson.weather_testmethod.equals("see all basic weather fields")) {
            LoginAction.attemptLogin(WeatherConfigJson.username, WeatherConfigJson.password);
            System.out.println("Login successful");
            // assertTrue(PageIdentifier.MAPS.isCurrentPage());
            if (Displayed.XPATH(WeatherConfigXpath.WEATHER_BUTTON)) {
                WeatherConfigActions.checkBasicWeatherFields();
                Thread.sleep(1000);
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_NWS_BULLETINS_TOGGLE));
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_EUMETNET_TOGGLE));
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_INFRARED_TOGGLE));
                
                WeatherConfigActions.toggleBasicSEWeatherFields();
                // Assert.assertTrue(Displayed.XPATH("//*[@id=\"map-layers__seWeather\"]/li[8]/span/label/label"));

                System.out.println("Weather if");
                
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.SE_AVIATION));
                
                WeatherConfigActions.checkBasicSEAviationFields();
                Thread.sleep(1000);
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_AIRMENTS));
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_SIGMENTS));
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_METAR));
                Assert.assertTrue(Displayed.XPATH(WeatherConfigXpath.BASIC_TAF));
                
                WeatherConfigActions.toggleBasicSEAviationFields();
                
                System.out.println("Aviation if");

            }

        }
        System.out.println("checked the page");

    }

}
