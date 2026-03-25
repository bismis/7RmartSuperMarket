package testscript;

import org.testng.annotations.Test;

import constants.constant;
import utilities.ScreenShotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {

	WebDriver driver;
	public Properties properties;
	FileInputStream fis;

	@Parameters("Browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(constant.CONFIGFILE);
			properties.load(fis);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}                                                               
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser");
		}
		//driver = new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itResult) throws IOException {
		if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility sc = new ScreenShotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}

		if (driver != null) {
			driver.quit();
		}

		// driver.quit();
	}

}
