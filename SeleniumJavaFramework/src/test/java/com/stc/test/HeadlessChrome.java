package com.stc.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessChrome {
	WebDriver driver;
	String driverPath = System.getProperty("user.dir");
	String baseURL = null;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
	}

		@Test
		public void searhGoogle() {
			baseURL = "https://www.google.com/";
			driver.get(baseURL);
			System.out.println(driver.getTitle());
			driver.findElement(By.name("q")).sendKeys("Softman");
			driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
			System.out.println("Done");
		}


	}
