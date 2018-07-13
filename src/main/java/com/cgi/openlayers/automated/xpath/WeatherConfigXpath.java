package com.cgi.openlayers.automated.xpath;

public class WeatherConfigXpath {
    public static String WEATHER_BUTTON = "//*[@id=\"main-content\"]/section[2]/div[2]/div[2]/div/button/span";

    public static String SE_WEATHER = "//*[@id=\"main-content\"]/section[2]/div[2]/div[2]/div/ul/li/ul/li[3]/a";
    // public static String SE_WEATHER = "//input[starts-with(@id,'main-content')";

    public static String BASIC_NWS_BULLETINS_TOGGLE = "//*[@id=\"map-layers__seWeather\"]/li[3]/span/label/label";
 //   public static String BASIC_NWS_BULLETINS_TOGGLE = "/html/body/div[1]/div/div/section[2]/div[2]/div[2]/div/ul/div/div[1]/div/div[3]/li[3]/span/label/label";

   // public static String BASIC_EUMETNET_TOGGLE = "//*[@id=\"map-layers__seWeather\"]/li[4]/span/label/label";
    public static String BASIC_EUMETNET_TOGGLE = "/html/body/div[1]/div/div/section[2]/div[2]/div[2]/div/ul/div/div[1]/div/div[3]/li[4]/span/label/label";
    
  //  public static String BASIC_INFRARED_TOGGLE = "//*[@id=\"map-layers__seWeather\"]/li[5]/span/label/label";
    public static String BASIC_INFRARED_TOGGLE = "/html/body/div[1]/div/div/section[2]/div[2]/div[2]/div/ul/div/div[1]/div/div[3]/li[5]/span/label/label";
    
    public static String BASIC_TFRs = "//*[@id=\\\"map-layers__seWeather\\\"]/li[8]/span/label/label";
   // public static String BASIC_TFRs = "/html/body/div[1]/div/div/section[2]/div[2]/div[2]/div/ul/div/div[1]/div/div[3]/li[8]/span/label/label";
    
    public static String SE_AVIATION = "//*[@id=\"main-content\"]/section[2]/div[2]/div[2]/div/ul/li/ul/li[4]/a";
    public static String BASIC_AIRMENTS = "//*[@id=\"map-layers__seWeatherAviation\"]/li[1]/span/label/label";
    public static String BASIC_SIGMENTS = "//*[@id=\"map-layers__seWeatherAviation\"]/li[2]/span/label/label";
    public static String BASIC_METAR = "//*[@id=\"map-layers__seWeatherAviation\"]/li[3]/span/label/label";
    public static String BASIC_TAF = "//*[@id=\"map-layers__seWeatherAviation\"]/li[4]/span/label/label";

    public static String ADVANCED_LIGHTNING = "//*[@id=\"map-layers__seWeather\"]/li[1]/span/label/label";
    public static String LIGHTNING_CLOUDSTROKES =
            "//*[@id=\"map-layers__seWeather\"]/li[1]/form/fieldset/div/div[1]/span[1]/label/label";
    public static String LIGHTNING_GROUNDSTROKES =
            "//*[@id=\"map-layers__seWeather\"]/li[1]/form/fieldset/div/div[1]/span[2]/label/label";
    public static String LIGHTNING_DENSITY =
            "//*[@id=\"map-layers__seWeather\"]/li[1]/form/fieldset/div/div[1]/span[3]/label/label";

    public static String RADAR_US =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[1]/label/label";
    public static String RADAR_EU =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[2]/label/label";
    public static String RADAR_CN =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[3]/label/label";
    public static String RADAR_AU =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[4]/label/label";
    public static String RADAR_JA =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[5]/label/label";
    public static String RADAR_COVERAGE_AREAS =
            "//*[@id=\"map-layers__seWeather\"]/li[2]/form/fieldset/div/div[1]/span[6]/label/label";

    public static String ADVANCED_RADARS = "//*[@id=\"map-layers__seWeather\"]/li[2]/span/label/label";
    public static String ADVANCED_TROPICAL = "//*[@id=\"map-layers__seWeather\"]/li[6]/span/label/label";
    public static String ADVANCED_GLOBALOZONE = "//*[@id=\"map-layers__seWeather\"]/li[7]/span/label/label";
    public static String ADVANCED_PIREPS = "//*[@id=\"map-layers__seWeatherAviation\"]/li[5]/span/label/label";
    public static String ADVANCED_EDR_TURBULENCE = "//*[@id=\"map-layers__seWeatherAviation\"]/li[6]/span/label/label";
    /*
     * public static String public static String public static String public static String public static String public
     * static String
     */

}
// *[@id="map-layers__seWeatherAviation"]/li[1]/span/label/label
// *[@id="map-layers__seWeatherAviation"]/li[2]/span/label/label
// *[@id="map-layers__seWeatherAviation"]/li[3]/span/label/label
// *[@id="map-layers__seWeatherAviation"]/li[4]/span/label/label