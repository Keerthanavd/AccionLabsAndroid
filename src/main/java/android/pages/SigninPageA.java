package android.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SigninPageA extends BasePageA{

	@FindBy(css = "#logonIdentifier") WebElement txtfield_username;
	@FindBy(css = "#password") WebElement txtfield_password;
	@FindBy(css = "#next") WebElement btn_signin;

	
	
	public SigninPageA(AndroidDriver<AndroidElement> driver) {
		super(driver);
		}
	
	/*Method to enter username and password to sign in. 
	Data for arguments is taken from excel, testdata.xlx
	present in the project*/
	public void signin(String Username,String Password){
		waitForElementToBeClickable(btn_signin);
		fillUtils(txtfield_username,Username);
		fillUtils(txtfield_password,Password);
		click(btn_signin);
	}

}
