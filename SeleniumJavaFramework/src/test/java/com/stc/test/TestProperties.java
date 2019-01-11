package com.stc.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.stc.config.PropertiesFile;

public class TestProperties {
	WebDriver driver;
	public static String browserName;
	String driverPath = System.getProperty("user.dir");
	String baseURL;
	@BeforeTest
	public void setUp() throws Exception {
		PropertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", driverPath+"/drivers/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

	}

	@Test
	public void searchGoogle() throws Exception {
		
		//ExtentTestNGReportBuilder.googleSearch();
		baseURL = "https://www.google.com/";
		driver.get(baseURL);
		driver.findElement(By.name("q")).sendKeys("Softman");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println("Done");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
