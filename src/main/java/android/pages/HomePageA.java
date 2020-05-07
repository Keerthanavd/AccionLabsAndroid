package android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePageA extends BasePageA{

	@FindBy(xpath = "//android.widget.Button[@text='Open navigation menu']") WebElement txt_navigationmenu;
	@FindBy(xpath = "//android.view.MenuItem[@index='5']") WebElement drpdwn_loginas;
	@FindBy(xpath = "[@text='JD Account']") WebElement drpdwn_JDAccount;

	public HomePageA(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public void clickNavigationMenu() {
		click(txt_navigationmenu);
		click(drpdwn_loginas);
		click(drpdwn_JDAccount);
	}
}
