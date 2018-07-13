package com.cgi.openlayers.automated.json;

import com.cgi.openlayers.automated.util.JsonData;

public class WeatherConfigJson {
    public static String username;
    public static String password;
    public static String weather_testmethod;

    public static void getJSON() {
        username = JsonData.dict.get("username").toString();
        password = JsonData.dict.get("password").toString();
        weather_testmethod = JsonData.dict.get("weather_testmethod").toString();
    }
}
