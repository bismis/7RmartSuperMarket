package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	HomePage home;
	ManageCategoryPage manageCateg;
  @Test(description = "Verify user can add a new category successfully using valid login credentials",
		  retryAnalyzer = retry.Retry.class)  //packagename.classname.classextension
  public void verifyUserCanManageCategory() throws IOException 
  {
	  LoginPage loginpage = new LoginPage(driver);
	  String uname = ExcelUtility.getStringData(3, 0,"LoginPage");
	  String psw = ExcelUtility.getStringData(3, 1,"LoginPage");
	  loginpage.enterUsernameAndPassword(uname,psw);
	
	  home = loginpage.clickButton();
	  manageCateg = home.clickManageCategory();

	  manageCateg.clickOnNewButton()
      .enterCategory()
      .clickOnDiscount()
      .chooseImageFileToUpload()
      .buttonYesTopMenu()
      .buttonYesShowHome()
      .clickSave();
	  
	  boolean  newAlert = manageCateg.isNewCategAddedAlert();
	  Assert.assertTrue(newAlert,"Category not added");
  }
  
  
}
