package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends commons.AutomationAction {
	
	/*
	 * select menu item
	 * @param item1 --> item2
	 */
	
	public void selectMenuItem (WebDriver driver, String item, String subItem)
	{
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
//		sleep(3);
//		click(driver, By.xpath(String.format(interfaces.AbstractPage.menuItems, "item")));
		sleep(2);
		click(driver, By.xpath(String.format(Centroid.AbstractPage.menuItems, item)));
		sleep(2);
			} else
		click(driver, By.xpath(String.format(Centroid.AbstractPage.menuItems, subItem)));
		}
	}	
	
	
	// Check successful message display correctly
	/*
	 * return true/false
	 * @parameter page to check
	 */
	
	public boolean checkPageDisplay(WebDriver driver, String pages)
	{
		
		return (findDynamicControl(driver, Centroid.AbstractPage.titlePage, pages)).isDisplayed();
	}
	
	/*
	 * Logout
	 */
	public void logout (WebDriver driver)
	{	
		click(driver, Centroid.AbstractPage.drdUser);
		sleep (2);
		click(driver, Centroid.AbstractPage.btnLogout);
	}	

}
