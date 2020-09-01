package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage {

	public WebDriver driver;
	//constructor to define driver
	public AboutPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	//Contactus Objects
	private By firstname = By.name("first_name");
	private By lastname = By.name("last_name");
	private By email = By.name("email");
	private By phone = By.name("phone");
	private By message = By.name("message");
	private By sendbutton = By.id("send-message");
	private By messagesentalert = By.xpath("/html/body/div[8]");
	
	
	
	public WebElement getFirstName()
	{
		return driver.findElement(firstname);
		
	}
	public WebElement getLastName()
	{
		return driver.findElement(lastname);
		
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	public WebElement getPhone()
	{
		return driver.findElement(phone);
		
	}
	public WebElement getMessage()
	{
		return driver.findElement(message);
		
	}
	public WebElement getSendButton()
	{
		return driver.findElement(sendbutton);
		
	}

	public WebElement getMessageAlert()
	{
		return driver.findElement(messagesentalert);
		
	}
	
	
}

