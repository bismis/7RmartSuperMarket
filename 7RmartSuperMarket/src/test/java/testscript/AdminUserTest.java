package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	FakerUtility faker = new FakerUtility();
	HomePage home;
	AdminUserPage admin;

	@Test(description = "Adding new user to the admin page")
	public void createUsernameandpassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String uname = ExcelUtility.getStringData(3, 0, "LoginPage");
		String psw = ExcelUtility.getStringData(3, 1, "LoginPage");

		String userType = ExcelUtility.getStringData(1, 2, "LoginPage");
		loginpage.enterUsernameAndPassword(uname, psw);

		home = loginpage.clickButton();
		admin = home.moreInfoClick();
		String username = faker.getFirstName();
		String password = faker.getPsw();
		admin.newButtonClick().enterUsernameAndPassword(username, password).selectUserType(userType).clickSave();

		boolean newAdminAlert = admin.isAdminUserAddAlert();
		Assert.assertTrue(newAdminAlert, constant.ADMINALERT);
	}
}
