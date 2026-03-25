package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	public void selectByValueDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleTextDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectByIndexDropdown(WebElement element, int value) {

		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public void selectByContainsVisibleTextDropdown(WebElement element, String value) {
		
		Select select = new Select(element);
		// select.selectByContainsVisibleText(value);
	}
	
	public String getSelectedOptionText(WebElement element) {

	    Select select = new Select(element);
	    return select.getFirstSelectedOption().getText();
	}

}