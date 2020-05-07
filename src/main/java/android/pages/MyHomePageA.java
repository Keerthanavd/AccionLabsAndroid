package android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyHomePageA extends BasePageA{

	@FindBy(xpath = "//android.widget.Button[@text='My Home'][@index='1']") WebElement link_logout;
	
	public MyHomePageA(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public void verifyIfUserLoggedIn() {
		Assert.assertTrue(link_logout.isDisplayed(), "User is not logged in");
	}
}
