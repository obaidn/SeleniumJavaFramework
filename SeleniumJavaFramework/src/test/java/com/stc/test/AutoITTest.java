package com.stc.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutoITTest {
	
	WebDriver driver;
	String driverPath = System.getProperty("user.dir");
	String baseURL = null;
	
	@BeforeTest
	public void setUp() {
	
			System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
	}
	
	@Test
	public void searhGoogle() throws Exception {
		baseURL = "http://www.tinyupload.com/";
		driver.get(baseURL);
		driver.findElement(By.name("uploaded_file")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\Syed.Rahman\\Documents\\AutoITScript.exe");
		
		Thread.sleep(3000);
		System.out.println("Done");
	}

}
