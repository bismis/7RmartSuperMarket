package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.constant;
import utilities.FileUploadUtility;

public class ManageCategoryPage {

	WebDriver driver;

	FileUploadUtility fileUpload = new FileUploadUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonClick;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement enterCateg;
	@FindBy(xpath = "//li[contains(@class,'ms-elem-selectable')]")
	WebElement selectGroup_discount;
	@FindBy(id = "main_img")
	WebElement chooseFile;
	@FindBy(xpath = "//input[contains(@name,'top_menu') and @value='yes']")
	WebElement radioButton_yes_topMenu;
	@FindBy(xpath = "//input[contains(@value,'yes') and contains(@name,'show_home')]")
	WebElement radioButton_yes_showHome;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement newCategoryAlert;

	public ManageCategoryPage clickOnNewButton() {
		newButtonClick.click();
		return this;
	}

	public ManageCategoryPage enterCategory() {
		enterCateg.sendKeys("dogs");
		return this;
	}

	public ManageCategoryPage clickOnDiscount() {
		selectGroup_discount.click();
		return this;
	}

	public ManageCategoryPage chooseImageFileToUpload() {
		fileUpload.sendKeysForUpload(chooseFile, constant.IMAGEFILE);
		return this;
	}

	public ManageCategoryPage buttonYesTopMenu() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radioButton_yes_topMenu);
		return this;
	}

	public ManageCategoryPage buttonYesShowHome() {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", radioButton_yes_showHome); return
		 * this;
		 */

		save.click(); // the comment one is right way..but to check Screenshot utility ,used this to
						// make the method fails.
		return this;
	}

	public ManageCategoryPage clickSave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", save);
		js.executeScript("arguments[0].click();", save);
		return this;
	}

	public boolean isNewCategAddedAlert() {
		return newCategoryAlert.isDisplayed();
	}

}
