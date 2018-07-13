package com.cgi.openlayers.automated.util;

import com.cgi.openlayers.automated.common.Commons;

public class Windows extends Commons {
    public static String mainWindow;

    public static String currentWindow;

    public static void NEW() throws InterruptedException {
	try {
	    currentWindow = null;
	    Thread.sleep(1000);
	    for (String winHandle : driver.getWindowHandles()) {
		if (!winHandle.equals(mainWindow) && !winHandle.equals(currentWindow)) {
		    driver.switchTo().window(winHandle);
		    currentWindow = winHandle;
		    Thread.sleep(1000);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void MAIN() throws InterruptedException {
	driver.switchTo().window(mainWindow);
    }

}
