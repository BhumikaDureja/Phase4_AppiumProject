package com.simplilearn.AppiumProject;


import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
public class MessagingApp {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		desiredCapabilities.setCapability("appium:appPackage", "com.google.android.apps.messaging");
		desiredCapabilities.setCapability("appium:appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

		touchAction = new TouchAction(driver); 



	}


	


	@Test
	public void sendMessage() throws Throwable {

		MobileElement StartNewConvo = (MobileElement)driver.findElementById("com.google.android.apps.messaging:id/start_new_conversation_button");
		StartNewConvo.click();
		Thread.sleep(6000);
		MobileElement To = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view");
		To.sendKeys("5554");
		
		Thread.sleep(6000);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(6000);
		MobileElement msg = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/compose_message_text");
		msg.sendKeys("Hello");
		
		Thread.sleep(6000);
		MobileElement sendBtn = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/send_message_button");
		sendBtn.click();
		
		
		Thread.sleep(10000);
		MobileElement backBtn = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
		backBtn.click();
		Thread.sleep(3000);
		
		MobileElement text = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
		assertEquals(text.getAttribute("text"), "Hello");




	}




	@After
	public void tearDown() {
		driver.quit();
	}
}


//CTRL +A, CTRL+I (for indentation)
