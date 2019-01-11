package com.stc.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.stc.test.GoogleSearchTest;

public class PropertiesTest {
	
	static Properties prop = new Properties();
	static String filePath = System.getProperty("user.dir");

	public static void main(String[] args) throws Exception {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() throws Exception {
		try {
			InputStream input = new FileInputStream(filePath+"/src/test/java/com/stc/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			GoogleSearchTest.browserName = browser;
			System.out.println(browser);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() throws Exception {
		
		try {
			OutputStream out = new FileOutputStream(filePath+"/src/test/java/com/stc/config/config.properties");
			prop.setProperty("browser", "ie");
			prop.store(out, null);
			//System.out.println(browser);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}


