package android.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AccountAccessPageA extends BasePageA {


	@FindBy(id = "ctl00_OS2ContentPlaceHolder_LogIn") WebElement btn_login;

	//constructor to call basepage constructor
	//And to verify if on the right page
	public AccountAccessPageA(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public void clickLogInToYourAccount() {
		click(btn_login);
	}
	

}