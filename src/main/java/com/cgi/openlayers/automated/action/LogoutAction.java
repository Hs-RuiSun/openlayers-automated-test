package com.cgi.openlayers.automated.action;

import com.cgi.openlayers.automated.common.Click;
import com.cgi.openlayers.automated.xpath.LogoutXpath;
import com.cgi.openlayers.automated.xpath.PageIdentifier;

public class LogoutAction {
    public static void attemptLogout() {
        if (!PageIdentifier.LOGOUT.isCurrentPage()) {
            try {
                throw new Exception();
            }
            catch (Exception e) {

                e.printStackTrace();
            }
        }
        Click.XPATH(LogoutXpath.USER_DROPDOWN);
        Click.XPATH(LogoutXpath.LOGOUT_BUTTON);
    }
}
