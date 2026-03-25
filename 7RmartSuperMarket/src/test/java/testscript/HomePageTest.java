package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	HomePage home;
  @Test(description = "Verify user can login with valid credentials and successfully logout")
  public void verifyUserCanSignIn() throws IOException  
  {
	  LoginPage loginpage = new LoginPage(driver);
	  
	  String uname = ExcelUtility.getStringData(3, 0,"LoginPage");
	  String psw = ExcelUtility.getStringData(3, 1,"LoginPage");
	  loginpage.enterUsernameAndPassword(uname,psw);
	  
	  home = loginpage.clickButton();
	  home.adminUser().LogOut();
	  
	  //Assertion : checking title is displayed after logout using equal
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected,constant.TITLEERROR);
	  /*loginpage.clickButton();
	                                            //chaining of methods-here we used to drivers,but only one driver is preferred.
	  HomePage homepage = new HomePage(driver);
	  homepage.adminUser();
	  homepage.LogOut();*/
  }
}
