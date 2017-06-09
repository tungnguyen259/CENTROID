package actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAction {

	public WebElement findElement(WebDriver driver, By control) {
		return driver.findElement(control);
	}

	/**
	 * Check a control display
	 * @param driver
	 * @param control
	 * @return
	 */
	public boolean isControlDisplay(WebDriver driver, By control) {
		try {
			waitForControl(driver, control, Constant.shortWaitTime);
			WebElement element = findElement(driver, control);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Click on a control
	 * @param driver
	 * @param control
	 */
	public void click(WebDriver driver, By control) {
		waitForControl(driver, control, Constant.longWaitTime);
		findElement(driver, control).click();
	}

	/**
	 * Hover on a control
	 * @param driver
	 * @param control
	 */
	public void hover(WebDriver driver, By control) {
		waitForControl(driver, control, Constant.longWaitTime);
		Actions actions = new Actions(driver);
		WebElement element = findElement(driver, control);
		actions.moveToElement(element).perform();
	}

	/**
	 * Type into a textBox
	 * @param driver
	 * @param control
	 * @param text
	 */
	public void type(WebDriver driver, By control, String text) {
		waitForControl(driver, control, Constant.longWaitTime);
		WebElement element = driver.findElement(control);
		element.clear();
		element.sendKeys(text);
	}


	/**
	 * Select DropDown item form comboBox
	 * 
	 * @param driver
	 * @param control
	 * @param contentItem
	 * @param value
	 */

	public void selectDropdownItem(WebDriver driver, By control, String contentItem, String value) {
		click(driver, control);
		click(driver, By.xpath(String.format(contentItem, value)));
	}

	/**
	 * Check dynamic control display
	 * @param driver
	 * @param dynamicControl
	 * @param value
	 * @return true/false
	 */
	public boolean isDynamicControlDisplay(WebDriver driver, String dynamicControl, String value) {
		try {
			String realControl = String.format(dynamicControl, value);
			WebElement elememnt = driver.findElement(By.xpath(realControl));
			return elememnt.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Find dynamic control
	 * @param driver
	 * @param dynamicControl
	 * @param value
	 * @return dynamic control
	 */
	public WebElement findDynamicControl(WebDriver driver, String dynamicControl, String value) {
		String realControl = String.format(dynamicControl, value);
		return driver.findElement(By.xpath(realControl));
	}

	/**
	 * Switch driver to iFrame from defaultContent
	 * 
	 * @return driver
	 */
	public WebDriver switchToFrame(WebDriver driver, By controlName) {
		waitForControl(driver, controlName, Constant.longWaitTime);
		driver = driver.switchTo().frame(driver.findElement(controlName));
		return driver;
	}

	/**
	 * Switch driver to defaultContent from iFrame
	 * 
	 * @return driver
	 */
	public WebDriver switchDefaultContent(WebDriver driver) {
		driver.switchTo().parentFrame();
		return driver;
	}
	
	/**
	 * Wait for a control display
	 * @param driver
	 * @param waittime
	 */
	public void waitForControl(WebDriver driver, By control, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(control));
	}

	public void sleep(int time){
		try {
			Thread.sleep(1000*time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}