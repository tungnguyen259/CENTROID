package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Check successful message display correctly
	/*
	 * return true/false
	 * @parameter display message
	 */
	public boolean checkSuccessfulMessage(String message)
	{
		return findDynamicControl(driver, Centroid.HomePage.successfulMessage, message).isDisplayed();
	}
	
	// Check successful message display correctly
	/*
	 * return true/false
	 * @parameter page to check
	 */
	
//	public boolean checkPageDisplay(String pages)
//	{
//		
//		return (findDynamicControl(driver, interfaces.HomePage.titleDashboardPage, pages)).isDisplayed();
//	}

	WebDriver driver;
}
