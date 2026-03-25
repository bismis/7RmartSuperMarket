package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	
	FakerUtility faker = new FakerUtility();     //calling faker
	HomePage home;
	AdminUserPage admin;
	
  @Test(description = "Adding new user to the admin page")
  public void createUser() throws IOException
  {
	  LoginPage loginpage = new LoginPage(driver);
	  String uname = ExcelUtility.getStringData(3, 0,"LoginPage");
	  String psw = ExcelUtility.getStringData(3, 1,"LoginPage");
	  loginpage.enterUsernameAndPassword(uname,psw);
	  /*loginpage.clickButton();
	  
	  AdminUserPage adminUserPage = new AdminUserPage(driver);
	  adminUserPage.moreInfoClick();
	  adminUserPage.newButtonClick();
	  adminUserPage.enterUsernameAndPassword();
	  adminUserPage.selectUserType();
	  adminUserPage.clickSave();*/
	  
	  home = loginpage.clickButton();
	  admin = home.moreInfoClick();
	  String username = faker.getFirstName();
	  String password = faker.getPsw();
	  admin.newButtonClick().enterUsernameAndPassword(username,password).selectUserType().clickSave();
  }
}
