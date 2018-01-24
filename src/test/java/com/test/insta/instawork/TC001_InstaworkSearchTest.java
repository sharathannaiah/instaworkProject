package com.test.insta.instawork;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.insta.instawork.testBase.TestBase;
import com.test.insta.instawork.uiActions.InstaworkSearchPage;

public class TC001_InstaworkSearchTest extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC001_InstaworkSearchTest.class.getName());
		 
	 String baseURL = "http://www.google.com/";
	 String searchword="instawork"; // 
	 String matchInUrl="https://in.linkedin.com/company/instawork";  //- 4th position 
    //String matchInUrl="https://www.instawork.com/"; //- 1st position
   //String matchInUrl="https://www.instagram.com/explore/tags/instawork/"; // - 12th position
       
     WebDriver driver;
     InstaworkSearchPage instaworkSearchPage;
     
     @Parameters("browser")
	 @BeforeTest
    	 public void	 openBrowser(String browser) throws IOException {
    	 init();
    			try {
    				if (browser.equalsIgnoreCase("chrome")) {
    					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
    					log.info("Creating object of " + browser);
    					driver = new ChromeDriver();}
    					else if (browser.equalsIgnoreCase("Firefox")){		
    					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
    					log.info("Creating object of " + browser);
    					driver = new FirefoxDriver();} 
    			} catch (WebDriverException e) {
    				System.out.println(e.getMessage());
    			}
    		}
		
	
	@Test
	public void instaworkSearchTest() {	
		log.info("==============Starting InstaworkGoogleSearch Test ===========");
		instaworkSearchPage = new InstaworkSearchPage(driver);
		instaworkSearchPage.getUrl(baseURL);
		instaworkSearchPage.searchInstaworkGoogle(searchword);
		instaworkSearchPage.checkResultPosition(matchInUrl);
		log.info("==============Finishing InstaworkGoogleSearch Test ===========");
	}
	
	@AfterTest
	public void endTest() {
		driver.close();
	}

}
