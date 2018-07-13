package com.cgi.openlayers.automated.json;

import com.cgi.openlayers.automated.util.JsonData;

public class Maps_OthersToggleJson extends JsonData {
   
    public static String username;
    public static String password;
    public static String testMethod;

    public static void getJSON() {
      
        username = JsonData.dict.get("username").toString();
        password = JsonData.dict.get("password").toString();
        testMethod = JsonData.dict.get("testMethod").toString();
    }
}
