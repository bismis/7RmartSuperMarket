package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	HomePage home;

	@Test(description = "This class validates login functionality using different credential combinations", groups = "smoketest")
	@Parameters({ "username", "password" })
	public void verifyUserCanSignIn(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
		home = loginpage.clickButton();

		boolean dashboardIsDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardIsDisplayed, constant.ERRORMSGFORLOGIN);// 1st arg for true condition & 2nd for login
																			// error.
	}

	@Test(groups = "smoketest")
	public void LoginIncorrectUsernameAndCorrectPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String user = ExcelUtility.getStringData(2, 0, "LoginPage");
		String pswd = ExcelUtility.getStringData(2, 1, "LoginPage");

		loginpage.enterUsernameAndPassword(user, pswd);
		loginpage.clickButton();
	}

	@Test
	public void LoginCorrectUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
		loginpage.clickButton();
	}

	@Test(dataProvider = "Credentials")
	public void LoginIncorrectUsernameAndIncorrectPassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
		loginpage.clickButton();
	}

	@DataProvider(name = "Credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "adm", "admin" }, { "admin", "admi" }, { "adm", "adm" } };
		return data;
	}
}
