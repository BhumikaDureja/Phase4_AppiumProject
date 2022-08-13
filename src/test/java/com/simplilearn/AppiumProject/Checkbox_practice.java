package com.simplilearn.AppiumProject;

	
	import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

	public class Checkbox_practice {

	  private AndroidDriver driver;
	  TouchAction touchAction;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
	    desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    
	    touchAction = new TouchAction(driver); 
		 
	  }

	  
	  public MobileElement getTextViewByContentDesc(String contentDesc) {
          
          return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc +"\"]");
	  		}
	  

	
	  @Test
	  public void checkbox_practice() throws Throwable {
		  
		  getTextViewByContentDesc("Animation").click();
          getTextViewByContentDesc("Layout Animations").click();
          
          driver.findElementByAccessibilityId("Custom Animations").click();
          
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}



