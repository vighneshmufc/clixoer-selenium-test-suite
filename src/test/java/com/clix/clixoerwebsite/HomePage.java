package com.clix.clixoerwebsite;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public LandingPage landingpage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void bringup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));
		log.info("URL is Fetched");

	}

	@Test

	public void basePageNavigation() throws IOException {

		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);

	}

	@Test

	public void countLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//a")); // Identify the number of Link on webpage and
																		// assign into Webelement List

		int linkCount = links.size(); // Count the total Link list on Web Page

		System.out.println("Total Number of link count on webpage by one class = " + linkCount); // Print the total
																									// count of links on
																									// webpage
		log.info("The number of links is" + linkCount);
	}

	@Test
	public void verifyEnglishmodulesinEnglishcheckbox()

	{

		if (landingpage.getEnglishcheckbox().isDisplayed()) {
			log.info("Check Box Exists since its visible" + landingpage.getEnglishcheckbox().isDisplayed());

		}

	}

	@Test
	public void checkEnglishContentChecked() {
		landingpage.getEnglishcheckbox().click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)"),
				"Communicative"));
		System.out.println("Content Checked" + driver
				.findElement(By.cssSelector(
						"#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)"))
				.getText());
		String eb1text = landingpage.getEb1().getText();
		eb1text.trim().replace("\r", "").replace("\n", "");
		Assert.assertTrue(landingpage.getEb1().isDisplayed());
		Assert.assertEquals(eb1text, "Communicative English: Level I");

		String eb2text = landingpage.getEb2().getText();
		eb2text.trim().replace("\r", "").replace("\n", "");
		Assert.assertTrue(landingpage.getEb2().isDisplayed());
		Assert.assertEquals(eb2text, "Communicative English: Level II");

		log.info("English Modules exists in English Language");
		log.error("All English Modules doesnt exists here its an error");

	}

	@Test
	public void countEnglishModules() {
		landingpage.getEnglishcheckbox().click();
		List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"module_module\"]/div/span/img")); // Identify
																												// the
																												// number
																												// of
																												// Link
																												// on
																												// webpage
																												// and
																												// assign
																												// into
																												// Webelement
																												// List

		int linkCount = links.size(); // Count the total Link list on Web Page

		System.out.println("Total Number of English module count on webpage = " + linkCount); // Print the total count
																								// of links on webpage

		System.out.println("The number of English modules is" + linkCount);
		log.info("The number of modules is" + linkCount);
		assertEquals(linkCount, 2);
		log.info("English Modules Checked");

	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
