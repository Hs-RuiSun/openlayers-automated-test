package com.cgi.openlayers.automated.action;

import com.cgi.openlayers.automated.common.Click;
import com.cgi.openlayers.automated.common.Commons;
import com.cgi.openlayers.automated.xpath.WeatherConfigXpath;

public class WeatherConfigActions extends Commons {
    public static void checkBasicWeatherFields() {
        Click.XPATH(WeatherConfigXpath.WEATHER_BUTTON);
        Click.XPATH(WeatherConfigXpath.SE_WEATHER);
    }

    public static void checkBasicSEAviationFields() {
        Click.XPATH(WeatherConfigXpath.SE_AVIATION);
    }

    public static void toggleBasicSEWeatherFields() throws InterruptedException {
        Click.XPATH("//*[@id=\"map-layers__seWeather\"]/li[8]/span/label/label");
        // Click.XPATH(WeatherConfigXpath.BASIC_TFRs);
        Click.XPATH(WeatherConfigXpath.BASIC_NWS_BULLETINS_TOGGLE);
        Click.XPATH(WeatherConfigXpath.BASIC_EUMETNET_TOGGLE);
        Click.XPATH(WeatherConfigXpath.BASIC_INFRARED_TOGGLE);
    }

    public static void toggleBasicSEAviationFields() {
        Click.XPATH(WeatherConfigXpath.BASIC_AIRMENTS);
        Click.XPATH(WeatherConfigXpath.BASIC_SIGMENTS);
        Click.XPATH(WeatherConfigXpath.BASIC_METAR);
        Click.XPATH(WeatherConfigXpath.BASIC_TAF);
    }

}
