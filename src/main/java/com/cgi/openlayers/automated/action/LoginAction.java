package com.cgi.openlayers.automated.action;

import com.cgi.openlayers.automated.common.Click;
import com.cgi.openlayers.automated.common.Displayed;
import com.cgi.openlayers.automated.common.SendKeys;
import com.cgi.openlayers.automated.xpath.LoginXpath;
import com.cgi.openlayers.automated.xpath.PageIdentifier;

public class LoginAction {
    public  static void attemptLogin(String username, String password) {
        if (!PageIdentifier.LOGIN.isCurrentPage()) {
             try {
                 throw new Exception();
             }
             catch (Exception e) {
                 e.printStackTrace();
             }
         }
         
         if(Displayed.XPATH(LoginXpath.USERNAME) 
                 && Displayed.XPATH(LoginXpath.PASSWORD) 
                 && Displayed.XPATH(LoginXpath.SIGNIN_BUTTON)) {
             SendKeys.XPATH(LoginXpath.USERNAME, username);
             SendKeys.XPATH(LoginXpath.PASSWORD, password);
             Click.XPATH(LoginXpath.SIGNIN_BUTTON);
         }
     }
}
