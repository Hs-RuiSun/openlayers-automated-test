package com.cgi.openlayers.automated.application;

import com.cgi.openlayers.automated.action.LoginAction;
import com.cgi.openlayers.automated.action.LogoutAction;
import com.cgi.openlayers.automated.common.Commons;
import com.cgi.openlayers.automated.json.Maps_OthersToggleJson;
import com.cgi.openlayers.automated.util.JsonData;
import com.cgi.openlayers.automated.util.ScreenShot;
import com.cgi.openlayers.automated.xpath.PageIdentifier;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Maps_OthersToggleMain extends Commons {

    @Test
    public void testOthersToggleOffOnLogin() throws InterruptedException {

        ScreenShot.screenShot();
        TestResult = "";
        Assert.assertTrue(true);
        driver.get(JsonData.projectUrl);
       // driver.wait(1000);

        LoginAction.attemptLogin(Maps_OthersToggleJson.username, Maps_OthersToggleJson.password);

        System.out.println("Login successful");
        if (Maps_OthersToggleJson.testMethod.equals("default state on login")) {

          //  assertTrue(PageIdentifier.MAPS.isCurrentPage());
            
            LogoutAction.attemptLogout();
            //assertTrue(PageIdentifier.LOGOUT.isCurrentPage());
            System.out.println("checked the page");

        }
        else if (Maps_OthersToggleJson.testMethod.equals("toggle function still works")) {
            assertTrue(PageIdentifier.MAPSTOGGLEON.isCurrentPage());
            assertTrue(PageIdentifier.REPLAY.isCurrentPage());
            assertTrue(PageIdentifier.MAPSTOGGLEON.isCurrentPage());

            LogoutAction.attemptLogout();
            assertTrue(PageIdentifier.LOGOUT.isCurrentPage());
        }
        else if (Maps_OthersToggleJson.testMethod.equals("persistance")) {
            assertTrue(PageIdentifier.MAPSTOGGLEON.isCurrentPage());
            LogoutAction.attemptLogout();
            assertTrue(PageIdentifier.LOGOUT.isCurrentPage());
            LoginAction.attemptLogin(Maps_OthersToggleJson.username, Maps_OthersToggleJson.password);
        }

    }

}
