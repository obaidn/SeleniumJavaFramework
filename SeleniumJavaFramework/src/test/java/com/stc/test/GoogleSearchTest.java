package com.stc.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.stc.config.PropertiesTest;

public class GoogleSearchTest {
	WebDriver driver;
	public static String browserName = null;
	String driverPath = System.getProperty("user.dir");

	@BeforeTest
	public void setUP() throws Exception {
		PropertiesTest.getProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();}
		else if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", driverPath+"/drivers/gecko.exe");
			driver = new FirefoxDriver();}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


	}
	@Test
	public void googleSearch() {

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Softman");
		//driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println("Done");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
