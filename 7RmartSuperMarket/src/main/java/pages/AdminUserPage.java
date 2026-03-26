package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUserPage {

	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class = 'btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement usertype;
	@FindBy(name = "Create")
	WebElement save;
	@FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
	WebElement alert;

	public AdminUserPage newButtonClick() {
		newButton.click();
		return this;
	}

	public AdminUserPage enterUsernameAndPassword(String uname, String psw) {
		username.sendKeys(uname);
		password.sendKeys(psw);
		return this;
	}

	public AdminUserPage selectUserType(String userType) {
		// Select dropdown = new Select(usertype);
		// dropdown.selectByValue("staff");
		PageUtilities pageUtilities = new PageUtilities();
		pageUtilities.selectByValueDropdown(usertype, userType);
		return this;
	}

	public AdminUserPage clickSave() {
		save.click();
		return this;
	}

	public boolean isAdminUserAddAlert() {
		return alert.isDisplayed();
	}

}
