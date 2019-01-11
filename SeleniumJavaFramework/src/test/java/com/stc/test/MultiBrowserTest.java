package com.stc.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class MultiBrowserTest {
	
	WebDriver driver;
	String driverPath = System.getProperty("user.dir");
	String baseURL = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		
		System.out.println("Current Browser is : "+browserName);
		System.out.println("Thread ID is : "+Thread.currentThread().getId());
		
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
	public void searhGoogle() {
		baseURL = "https://www.google.com/";
		driver.get(baseURL);
		driver.findElement(By.name("q")).sendKeys("Softman");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println("Done");
	}

}
