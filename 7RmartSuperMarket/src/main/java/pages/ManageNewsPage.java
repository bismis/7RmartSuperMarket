package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.constant;

public class ManageNewsPage {

	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "news")
	WebElement enterNewsField;
	@FindBy(name = "create")
	WebElement save;

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement newNewsAddedAlert;

	public ManageNewsPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNews() {
		enterNewsField.sendKeys(constant.NEWS);
		return this;
	}

	public ManageNewsPage clickSave() {
		save.click();
		return this;

	}

	public boolean isNewNewsAddedAlert() {
		return newNewsAddedAlert.isDisplayed();
	}
}
