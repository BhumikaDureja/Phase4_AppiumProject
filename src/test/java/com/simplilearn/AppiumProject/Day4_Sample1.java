package com.simplilearn.AppiumProject;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Day4_Sample1 {

	private AndroidDriver<MobileElement> driver;
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

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

		touchAction = new TouchAction(driver); 

		System.out.println(driver.getSessionId());

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
		getTextViewByContentDesc("Controls").click();
		getTextViewByContentDesc("1. Light Theme").click();
		driver.findElementById("io.appium.android.apis:id/edit").sendKeys("Bhumika");
		driver.hideKeyboard();

		//Checkbox
		MobileElement checkbox = driver.findElementByXPath("//android.widget.CheckBox[@content-desc=\"Checkbox 1\"]");
		checkbox.click();
		String isChecked = checkbox.getAttribute("checked");
		System.out.println(checkbox.getAttribute("checked"));
		assertEquals(isChecked,"true");


		//RadioButton
		driver.findElementByClassName("android.widget.RadioButton").click();

		//Star
		MobileElement star = driver.findElementByXPath("//android.widget.CheckBox[@content-desc=\"Star\"]");
		star.click();

		//Toggle button
		//CTRL +2, L
		MobileElement TButton = driver.findElement(By.className("android.widget.ToggleButton"));
		System.out.println(TButton.getAttribute("text"));
		TButton.click();
		System.out.println(TButton.getAttribute("text"));



		//dropdown/ spinner
		MobileElement Dropdown = driver.findElementById("android:id/text1");
		String ExpDefText = "Mercury";
		String ActualDefText = Dropdown.getText();
		assertEquals(ExpDefText, ActualDefText);
		
		Dropdown.click();
		Thread.sleep(2000);
		MobileElement SelectDropdownVal = driver.findElementByXPath("//android.widget.CheckedTextView[@text='Jupiter']");
		Thread.sleep(2000);
		SelectDropdownVal.click();
		Thread.sleep(2000);
		String NewDropdownText = driver.findElementByXPath("//android.widget.TextView[@text='Jupiter']").getAttribute("text");
		System.out.println(NewDropdownText);
		assertEquals("Jupiter",NewDropdownText);
		
		

		for (int i = 0; i < 40; i++) {
			Thread.sleep(3000);
		}
	
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}


//CTRL +A, CTRL+I (for indentation)
