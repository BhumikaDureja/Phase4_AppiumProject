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

	public class RadioButton_practice {

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
	  

	  MobileElement clickRadioButton(String RadioButtonDesc) {
	         
          return (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@content-desc=\""+RadioButtonDesc +"\"]");
	  		}
	 
	  public void SwipeUpLong() {
		  touchAction
               .press(PointOption.point(170,700))
               .moveTo(PointOption.point(170,295))  
               .release()
               .perform();
	  			}

	/*  public void SwipeUpSmall() {
	
          touchAction
               .press(PointOption.point(210,610))
               .moveTo(PointOption.point(210,430))  
               .release()
               .perform();
	  }  */
	  
	  @Test
	  public void clickRadioButton() throws Throwable {
		  

          
          getTextViewByContentDesc("Views").click();
          SwipeUpLong();
          SwipeUpLong();
     //     SwipeUpSmall();
          
          getTextViewByContentDesc("Radio Group").click();
          
          Thread.sleep(3000);
         
          clickRadioButton("Dinner").click();

		  
		  Thread.sleep(3000);
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}



