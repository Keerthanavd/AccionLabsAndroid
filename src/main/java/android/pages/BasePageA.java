package android.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePageA {
	
	WebDriver driver;
	
	BasePageA(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		//initElements is used instead of driver.findElement
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement element) {
	    waitForElementToBeClickable(element);
	    try {
	        element.click();
	    } catch (Exception e) {
	        throw new TestException(String.format("The following element is not clickable: [%s]", element));
	    }
	}

	public void fillUtils(WebElement element, String value) {
	  //  WebElement element = getElement(selector);
	    clearField(element);
	    try {
	        element.sendKeys(value);
	    } catch (Exception e) {
	        throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, element.toString()));
	    }
	}
	    
	    public void clearField(WebElement element) {
	        try {
	            element.clear();
	        } catch (Exception e) {
	            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
	        }
	    }
}
