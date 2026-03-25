package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	
	WaitUtility waitUtility = new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //local to global assigning of driver
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signin;
	
	//Locating DashBoard for assertion
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboard;
	
	public LoginPage enterUsernameAndPassword(String username,String password)
	{
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		return this; // to create connection with current method.
	}
	
	public HomePage clickButton()
	{
		//signin.click();
		
		waitUtility.waitElementToBeClicked(driver, signin);           //applied WaitUtility
		signin.click();
		return new HomePage(driver);     //here can't give return this,coz when button click it is going to a new page.
	}
	
	public boolean isDashboardDisplayed()
	{      
		
		return dashboard.isDisplayed();      //boolean return type always starts with isDisplayed return type.
		
	}
}
