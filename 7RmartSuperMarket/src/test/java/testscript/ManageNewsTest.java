package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	HomePage home;
	AdminUserPage admin;
	ManageNewsPage news;

	@Test(description = "Verify user can create and save news successfully after login")
	public void verifyenterNewsandSave() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);

		home = loginpage.clickButton();
		news = home.clickManageNewsInfo();
		news.clickOnNewButton().enterNews().clickSave();

		boolean newsAlert = news.isNewNewsAddedAlert();
		Assert.assertTrue(newsAlert, constant.NEWSALERT);
	}
}
