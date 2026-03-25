package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	
	HomePage home;
	AdminUserPage admin;
	ManageNewsPage news;
  @Test(description = "Verify user can create and save news successfully after login")
  public void enterNewsandSave() 
  {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  /*loginpage.clickButton();
	  
	  ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
	  manageNewsPage.clickManageNewsInfo();
	  manageNewsPage.clickOnNewButton();
	  manageNewsPage.enterNews();
	  manageNewsPage.clickSave();*/
	  
	  home = loginpage.clickButton();
	  admin=home.moreInfoClick();
	  admin.newButtonClick().enterUsernameAndPassword("admin","admin").selectUserType().clickSave();
	  
	  news = new ManageNewsPage(driver);
	  news.clickManageNewsInfo().clickOnNewButton().enterNews().clickSave();
	  
	  boolean  newsAlert = news.isNewNewsAddedAlert();
	  Assert.assertTrue(newsAlert,"News not added");
  }
}
