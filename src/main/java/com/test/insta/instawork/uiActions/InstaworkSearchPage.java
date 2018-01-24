package com.test.insta.instawork.uiActions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.insta.instawork.testBase.TestBase;

public class InstaworkSearchPage extends TestBase{
	WebDriver driver;
	public static final Logger log = Logger.getLogger(InstaworkSearchPage.class.getName());
	
	//page object and their paths 	
	@FindBy(css = "//*[@class='btn btn-default spin-up']")
	WebElement addAdults;
	
	@FindBy(css="input[name='q']")
	WebElement googleInputBox;
	
	@FindBy(css="input[name='btnK']")
	WebElement googleSearchButton;
	
	@FindBy(css="h3.r > a")
	WebElement searchList;
	
	@FindBy(xpath="//a[@id='pnnext']")
	WebElement  nextPage;  
	
	// Add a constructor
		public InstaworkSearchPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);// Initialize all webElements
		}
		
		public void getUrl(String url) {
	    log.info("Navigating to : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
		
		public void searchInstaworkGoogle(String searchword) {
			googleInputBox.sendKeys(searchword);
			log.info("Entered the input in Search TextBox and object is:- " + googleInputBox.toString());
			googleSearchButton.click();	
			log.info("Clicked on Google Search button and object is:- " + googleSearchButton.toString());
		}
		
		public void checkResultPosition(String matchInUrl){
			String link = searchList.getAttribute("href");	
			log.info("URl to be matched - " +matchInUrl);
		       if(link.equals(matchInUrl))
		       { 	  
//		     	 System.out.println("URL is matching in first position");
//		     	 System.out.println("URL found in first position is - " +link);
		     	log.info("URL is matching in first position");
		     	log.info("URL found in first position is - " +link);
		       }
		       else
		       {
		     	  System.out.println("url is not matching in first position"); 	  
		       int pageNumber= 0;
		       boolean foundMatch=false;
		       while(!foundMatch){	
		    	   List<WebElement> resultEntries = driver.findElements(By.cssSelector("h3.r > a"));
		    	   for(WebElement element : resultEntries){
		    	    	pageNumber++;
		    	   String href = element.getAttribute("href");
		    	   System.out.println(href); 
		    	   if(href.equals(matchInUrl)){ 
		    	 	  System.out.println("****FOUND MATCH*** on position " + pageNumber);
		    	    	  foundMatch=true;   
		    	    }     
		    	    }
		    	   WebDriverWait wait = new WebDriverWait(driver, 10);
		    	   JavascriptExecutor js = (JavascriptExecutor)driver;
		    	   js.executeScript("arguments[0].click();", nextPage);
		    	   try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	    
		    	      }
		    	      }
		    		}
}
