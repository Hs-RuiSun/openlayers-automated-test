package com.cgi.openlayers.automated.application;

import com.cgi.openlayers.automated.action.LoginAction;
import com.cgi.openlayers.automated.common.Commons;
import com.cgi.openlayers.automated.json.LoginPageJson;
import com.cgi.openlayers.automated.json.Maps_OthersToggleJson;
import com.cgi.openlayers.automated.util.JsonData;
import com.cgi.openlayers.automated.util.ScreenShot;
import com.cgi.openlayers.automated.xpath.PageIdentifier;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WebApp_LoginMain extends Commons {

    @Test

    public void testlogin() throws InterruptedException {

        ScreenShot.screenShot();
        TestResult = "";
        Assert.assertTrue(true);
        // changing loginpagejson to jsondata
        driver.get(JsonData.projectUrl);

        LoginAction.attemptLogin(Maps_OthersToggleJson.username, Maps_OthersToggleJson.password);
        System.out.println("Login successfull");

        System.out.println("LoginPageJson.expectedResult " + LoginPageJson.expectedResult);
        System.out.println("PageIdentifier.LOGIN.isCurrentPage() " + PageIdentifier.LOGIN.isCurrentPage());

        assertTrue(LoginPageJson.expectedResult, PageIdentifier.LOGIN.isCurrentPage());

    }

}
