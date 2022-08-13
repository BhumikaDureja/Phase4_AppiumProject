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

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Day5_Sample {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		//desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
		  desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

		touchAction = new TouchAction(driver); 

	//	System.out.println(driver.getSessionId());

	}


	public MobileElement getTextViewByContentDesc(String contentDesc) {

		return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc +"\"]");
	}




	/*    public void SwipeUpLong() {
		  touchAction
               .press(PointOption.point(170,700))
               .moveTo(PointOption.point(170,295))  
               .release()
               .perform();
	  			} */

	/*  public void SwipeUpSmall() {

          touchAction
               .press(PointOption.point(210,610))
               .moveTo(PointOption.point(210,430))  
               .release()
               .perform();
	  }  */

	@Test
	public void navigation() throws Throwable {



		getTextViewByContentDesc("Views").click();
		getTextViewByContentDesc("Drag and Drop").click();
		
		MobileElement SRC = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		MobileElement TGT = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		Point pntSRC = SRC.getCenter();
		Point pntTGT = TGT.getCenter();
		
		Thread.sleep(2000);
		touchAction
			.longPress(PointOption.point(pntSRC))
			.moveTo(PointOption.point(pntTGT))  
			.release()
			.perform();

	/*	for (int i = 0; i < 40; i++) {
			Thread.sleep(3000);
		} */


	}

	
	@Test
	public void yearSelector_ScrollUp() throws Throwable {

		getTextViewByContentDesc("Views").click();
		getTextViewByContentDesc("Date Widgets").click(); 
		getTextViewByContentDesc("1. Dialog").click();
		
//      io.appium.android.apis:id/pickDate
      driver.findElement(By.id("io.appium.android.apis:id/pickDate")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("android:id/date_picker_header_year")).click();
      MobileElement MEYear = driver.findElement(By.id("android:id/date_picker_header_year"));
      Thread.sleep(2000);
      String strCrYear = MEYear.getAttribute("text");
      int crYear = Integer.parseInt(strCrYear);
      String strReqYear = "2028";
      int reqYear = Integer.parseInt(strReqYear);
      
      if (reqYear > crYear) {
//			Scroll Up
//			PRINT THE VALES -> TOP LEFT
			
			
			Boolean flgFound = false;
			
			while (!flgFound) {
				List<MobileElement> allYYears = driver.findElements(By.xpath("//android.widget.TextView"));
				for (MobileElement year : allYYears) {
					System.out.println(year.getAttribute("text"));
				}
				
				List<MobileElement> lstReqYr = driver.findElements(By.xpath("//android.widget.TextView[@text='2030']"));
				if (lstReqYr.size()>0) {
					flgFound = true;
					break;
				}
				ScrollUPYear();
				
				
				
			}
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
			
			Thread.sleep(5000);
			
			 
			 
			 
			
		}
		
		else{
//			scrollDown
			
		}
		
      
      

		
		
		
	}
	
	
	
	public void ScrollUPYear() {
		MobileElement MEListYEAR = driver.findElement(By.id("android:id/date_picker_year_picker"));
		int x = MEListYEAR.getLocation().getX();
		int y = MEListYEAR.getLocation().getY();
//		PRINT H AND W
		
		int H = MEListYEAR.getSize().getHeight();
		int W = MEListYEAR.getSize().getWidth();
		
		 int strtX = (int) (x+ (W*0.5));
		  int startY = (int) (y + H*0.9);
		 
		 int endX = strtX;
		 int endY = (int) (y + H*0.1);
		 
		 TouchAction action = new TouchAction(driver);
		
		 action
	      .longPress(PointOption.point(strtX,startY))
	      .moveTo(PointOption.point(endX,endY))
	      .release()
	      .perform();
		 
		 
		
		 
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}


//CTRL +A, CTRL+I (for indentation)
