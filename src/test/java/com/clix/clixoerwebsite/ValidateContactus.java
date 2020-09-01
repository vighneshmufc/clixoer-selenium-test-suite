package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AboutPage;
import pageObjects.LandingPage;
import resources.base;

public class ValidateContactus extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bringup() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String firstname,String lastname,String email,String phone,String message) throws IOException
	{
		
		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		LandingPage landingpage = new LandingPage(driver);
		
		driver.get(prop.getProperty("url"));

		landingpage.getAbout().click();
		driver.manage().window().fullscreen();
		
		AboutPage aboutpage = new AboutPage(driver);
		aboutpage.getFirstName().sendKeys(firstname);
		aboutpage.getLastName().sendKeys(lastname);
		aboutpage.getEmail().sendKeys(email);
		aboutpage.getPhone().sendKeys(phone);
		aboutpage.getMessage().sendKeys(message);
		aboutpage.getSendButton().click();
		System.out.println(aboutpage.getMessageAlert().getText());
		String s = aboutpage.getMessageAlert().getText().trim().replace("\r","").replace("\n","");
		System.out.println(s);
		
		Assert.assertEquals(aboutpage.getMessageAlert().getText().trim().replace("\r","").replace("\n",""),"×Your feedback sent successfully!");		
		//System.out.println();
		//driver.close();
		//driver.quit();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][5];
		data[0][0]="Vighnesh";
		data[0][1]="Nair";
		data[0][2]="Vighnesh@gmail.com";
		data[0][3]="9987838143";
		data[0][4]="Correct";
		
		data[1][0]="Brett";
		data[1][1]="Lee";
		data[1][2]="notvighnesh";
		data[1][3]="66565";
		data[1][4]="inCorrect";
		
		return data;
		
	}
	@AfterTest

	public void teardown()
	{
		driver.close();
	}
	

}
