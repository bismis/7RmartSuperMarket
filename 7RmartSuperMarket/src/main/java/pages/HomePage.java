package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminuser;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href, 'list-admin')]")
	WebElement moreInfo;

	@FindBy(xpath = "//a[contains(@href ,'/admin/list-category')]")
	WebElement manageCategInfo;
	@FindBy(xpath = "//a[contains(@href,'admin/list-news')]")
	WebElement manageNewsInfo;

	public ManageNewsPage clickManageNewsInfo() {
		manageNewsInfo.click();
		return new ManageNewsPage(driver);
	}

	public HomePage adminUser() {
		adminuser.click();
		return this;
	}

	public HomePage LogOut() {
		logout.click();
		return this;
	}

	public AdminUserPage moreInfoClick() {
		moreInfo.click();
		return new AdminUserPage(driver);
	}

	public ManageCategoryPage clickManageCategory() {
		manageCategInfo.click();
		return new ManageCategoryPage(driver);
	}
}
