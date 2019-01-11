package com.stc.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGReportBuilder {


	static WebDriver driver;
	static ExtentTest test1;
	static String baseURL;
	ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ThreadLocal parentTest = new ThreadLocal();
	private static ThreadLocal test = new ThreadLocal();

	@BeforeSuite
	public void beforeSuite() {
		//extent = ExtentManager.createInstance("extent.html");

		htmlReporter = new ExtentHtmlReporter("extent1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {

		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.google.com/";
	}
	@Test
	public static void googleSearch() throws Exception {
		test1 = extent.createTest("Testing Google Search 1...", "Google search validation");

		test1.log(Status.INFO, "Starting test...");
		driver.get(baseURL);
		test1.pass("Google search opens");
		driver.findElement(By.name("q")).sendKeys("Softman");
		test1.pass("Entered search text");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Entered");
		
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");
		test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");

		System.out.println("Done");
	}
	
	@Test
	public void googleSearch2() throws Exception {
		test1 = extent.createTest("Testing Google Search2...", "Google search2 validation");

		
		test1.fail("Entered");
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");
		test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");

		System.out.println("Done");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@AfterSuite
	public synchronized void afterMethod(ITestResult result) {
		/*if (result.getStatus() == ITestResult.FAILURE)
			((ExtentTest) test.get()).fail(result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			((ExtentTest) test.get()).skip(result.getThrowable());
		else
			((ExtentTest) test.get()).pass("Test passed");*/

		extent.flush();
	}
}
