package com.inflectra.spiratest.addons.junitextension.commons;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenShot extends Commons {
    /** Screenshot File */
    public static byte[] scrFile;

    public static byte[] screenShot() {
	try {
	    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    Thread.sleep(2000);
	    BufferedImage capture = new Robot().createScreenCapture(screenRect);
	    ImageIO.write(capture, "jpg", new File(System.getProperty("java.io.tmpdir") + JsonData.title + ".jpg"));
	    ByteArrayOutputStream b = new ByteArrayOutputStream();
	    ImageIO.write(capture, "jpg", b);
	    b.flush();
	    scrFile = b.toByteArray();
	    b.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return scrFile;
    }
}
