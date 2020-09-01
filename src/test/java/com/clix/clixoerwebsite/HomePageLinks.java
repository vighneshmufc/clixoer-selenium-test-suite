package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class HomePageLinks extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
public void bringup() throws IOException
{
	driver = initializeDriver();
	log.info("Driver is Initialized");

	driver.get(prop.getProperty("url"));
	log.info("URL is Fetched");

}
	@Test
	
	public void countLinkss()
	{
		 List<WebElement> links = driver.findElements(By.xpath("//a"));    //Identify the number of Link on webpage and assign into Webelement List 
         
         int linkCount = links.size();     // Count the total Link list on Web Page
         
         System.out.println("Total Number of link count on webpage = "  + linkCount);    //Print the total count of links on webpage

	      System.out.println("The number of links is" + linkCount);
	    log.info("The number of links is" + linkCount);
	}

@AfterTest

public void teardown()
{
	driver.close();
}
	
}
