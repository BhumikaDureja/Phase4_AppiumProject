package com.simplilearn.AppiumProject;

	
	import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

	public class Day2Sample5_SeekBar {

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
	  

	
	 
	  public void SwipeUpLong() {
		  touchAction
               .press(PointOption.point(170,700))
               .moveTo(PointOption.point(170,295))  
               .release()
               .perform();
	  			}

	  public void SwipeUpSmall() {
	
          touchAction
               .press(PointOption.point(210,610))
               .moveTo(PointOption.point(210,430))  
               .release()
               .perform();
	  }  
	  
	  @Test
	  public void SeekBarTest () throws Throwable {
		  
		  getTextViewByContentDesc("Views").click();
		  SwipeUpLong();
		  SwipeUpLong();
		  SwipeUpSmall();
		  getTextViewByContentDesc("Seek Bar").click();

		  MobileElement seekBar = (MobileElement) driver.findElementById("io.appium.android.apis:id/seek");

		  int startXPos = seekBar.getLocation().getX();
		  int yPos = seekBar.getLocation().getY();
		  int lastXPos = startXPos + seekBar.getSize().getWidth();
		  int centerXPos = seekBar.getCenter().getX();
		  System.out.println("startXPos= "+startXPos);
		  System.out.println("yPos= "+yPos);
		  System.out.println("lastXPos= "+lastXPos);
		  System.out.println("centerXPos= "+centerXPos);


		  //move to start position =0
		  touchAction.press(ElementOption.element(seekBar))
		  .moveTo(PointOption.point(startXPos,yPos))
		  .release()
		  .perform();

		  Thread.sleep(1000);

		  //move to last position
		  touchAction.press(ElementOption.element(seekBar))
		  .moveTo(PointOption.point(lastXPos,yPos))
		  .release()
		  .perform();

		  // want to move to to 30th position
		  int delta= 40;
		  int point30 = 30* (startXPos+ seekBar.getSize().getWidth() / 100)+delta;

		  touchAction.press(ElementOption.element(seekBar))
		  .moveTo(PointOption.point(point30,yPos))
		  .release()
		  .perform();



		  int point70 = 70* (startXPos+ seekBar.getSize().getWidth() / 100)+delta;

		  touchAction.press(ElementOption.element(seekBar))
		  .moveTo(PointOption.point(point70,yPos))
		  .release()
		  .perform();
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}



