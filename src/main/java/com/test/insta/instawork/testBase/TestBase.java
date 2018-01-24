package com.test.insta.instawork.testBase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class TestBase {

	public static WebDriver driver; // Available for all classes
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public void init()  throws IOException {
		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		}
	
	
	}
