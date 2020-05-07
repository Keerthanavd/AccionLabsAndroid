package android.utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.lsac.tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NGListeners implements ITestListener{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS,result.getName());
	}

	public void onTestFailure(ITestResult result) {
		logger=extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.FAIL,result.getName());
		String methodName=result.getName().toString().trim();
		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("webDriver");		
		System.out.println(driver.getCurrentUrl());
		try {
			captureScreen(driver,methodName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File f = new File(screenshotPath); 

		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	String repName;
	public void onStart(ITestContext context) {
		// Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
		// I used (.) in path where represent the current working directory
		String  timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter("./Reports/"+repName);

		// Create object of ExtentReports class- This is main class which will create report
		extent = new ExtentReports();
		
		// attach the reporter which we created in Step 1
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Keerthana");

		htmlReporter.config().setDocumentTitle("Selenium automation");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);	

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	//This method is used to Capture the screen when called.
	//Arguments are driver and methodname
	//Captured screenshot is placed in screenshot folder of the project
	public void captureScreen(WebDriver driver, String methodname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + methodname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
