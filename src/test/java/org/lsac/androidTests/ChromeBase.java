package org.lsac.androidTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
@Listeners(android.utils.NGListeners.class)

public class ChromeBase {
	
	AndroidDriver<AndroidElement> driver=null;
	@BeforeTest
	
	public AndroidDriver<AndroidElement> setupCapabilities() throws InterruptedException {

		//Capabilities to open chrome app
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Galaxy_Nexus_API_25");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");


		//System.setProperty("webdriver.chrome.driver","E:\\Softwares\\Drivers\\ChromeDriver\\chromedriver_69\\chromedriver.exe");
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}		

		//Open URL in Chrome Browser
		driver.get("https://www.lsac.org");

		return driver;
	}

}

