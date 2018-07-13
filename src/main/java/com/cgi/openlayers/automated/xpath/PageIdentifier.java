package com.cgi.openlayers.automated.xpath;

import com.cgi.openlayers.automated.common.Displayed;
import java.util.ArrayList;
import java.util.List;

public enum PageIdentifier {
    LOGIN(LoginXpath.USERNAME, LoginXpath.PASSWORD, LoginXpath.SIGNIN_BUTTON),

    LOGOUT(LogoutXpath.LOGOUT_BUTTON, LogoutXpath.LOGOUT_SUCCESS_MESSAGE),
    
    MAPS(MapsXpath.MAPS_PAGE, MapsXpath.OTHERS_TOGGLE_OFF),

    MAPSTOGGLEON(MapsXpath.MAPS_PAGE, MapsXpath.OTHERS_TOGGLE_ON),

    REPLAY(ReplayXpath.REPLAYTAB, ReplayXpath.REPLAY_FLIGHTS_PAGE),
    
    WEATHER_SEWEATHER_BASIC(WeatherConfigXpath.WEATHER_BUTTON, WeatherConfigXpath.SE_WEATHER,
            WeatherConfigXpath.BASIC_NWS_BULLETINS_TOGGLE, WeatherConfigXpath.BASIC_EUMETNET_TOGGLE,
            WeatherConfigXpath.BASIC_INFRARED_TOGGLE, WeatherConfigXpath.BASIC_TFRs),

    WEATHER_SEAVIATION_BASIC(WeatherConfigXpath.SE_AVIATION, WeatherConfigXpath.BASIC_AIRMENTS,
            WeatherConfigXpath.BASIC_SIGMENTS, WeatherConfigXpath.BASIC_METAR, WeatherConfigXpath.BASIC_TAF)
    ;

    private List<String> requiredXpathSet = new ArrayList<String>();

    private PageIdentifier(String...xpaths) {
        for (String xpath : xpaths) {
            requiredXpathSet.add(xpath);
        }
    }

    public boolean isCurrentPage() {
        for (String xpath : requiredXpathSet) {;
            if (!Displayed.XPATH(xpath)) {
                return false;
            }
        }
        return true;
    }
}
