package com.simplilearn.AppiumProject;

	
	import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

	public class Day2Sample {

	  private AndroidDriver driver;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
	   // desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
	    // Specifying appPackage & appActivity for existing apps instead of the apk path
	    desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
		   MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_8");
		    el1.click();
		    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		    el3.click();
		    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("equals");
		    el4.click();
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}



