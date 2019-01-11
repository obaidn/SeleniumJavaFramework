package com.stc.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.stc.test.TestProperties;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class PropertiesFile {
	
	
	public static void main(String[] args) throws Exception {
		getProperties();
	}
	
public static void getProperties() throws Exception {
	
	String filePath = System.getProperty("user.dir");
	Properties prop = new Properties();
	InputStream input = new FileInputStream(filePath+"\\src\\test\\java\\com\\stc\\config\\config.properties");
		prop.load(input);
		String browser = prop.getProperty("browser");
		TestProperties.browserName = browser;
		System.out.println(browser);
		
}
	
}