package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropDownWithVisibleText(WebElement element, String visibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleText);
	}

	public void clickOnElement(WebElement element) {
	    element.click();
	}
	
	public void enterText(WebElement element, String text) {
	    element.clear();
	    element.sendKeys(text);
	}
	
	public void pressEnterKey(WebElement element) {
	    element.sendKeys(Keys.ENTER);
	}
	
	public void clearTextField(WebElement element) {
	    element.clear();
	}
	
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element).perform();
	}

}
