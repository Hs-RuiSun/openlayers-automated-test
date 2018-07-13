package com.cgi.openlayers.automated.json;

import com.cgi.openlayers.automated.util.JsonData;

public class LoginPageJson extends JsonData {
    public static String projecturl;
    public static String username;
    public static String password;
    public static String expectedResult;

    public static void getJSON() {

        username = JsonData.dict.get("username").toString();
        password = JsonData.dict.get("password").toString();
        expectedResult = JsonData.dict.get("expectedResult").toString();

    }
}
