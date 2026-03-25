package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void sendKeysForUpload(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	
	public void robotClassForFileUpload(WebElement element,String path) throws AWTException
	{
		StringSelection selection = new StringSelection(path);   //StringSelection is a class used to specify the path 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); //to copy to Clip board.Here selection is where we copy from and null ,where to paste
		
		Robot robot = new Robot();
		robot.delay(2000);   //in some cases Chrome don't support multiple sites.already a site opened in above method.so used delay.
		robot.keyPress(KeyEvent.VK_ENTER);  //VK-vitual keys
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
	}
	
}
