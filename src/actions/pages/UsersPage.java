package pages;

import org.openqa.selenium.WebDriver;

public class UsersPage extends AbstractPage{
	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Create new user
	 */
	
	public void createNewUser (String firstName, String lastName, String email, String userName, String password, String passWordConfirmation, String phone, String country, String timeZone, String status, String roles, String group)
	{	
		click(driver, Centroid.UsersScreen.btnNewUser);
		enterNewUserData(firstName, lastName, email, userName, password, passWordConfirmation, phone, country, timeZone, status);
		selectNewUserRoles(roles);
		selectNewUserGroup(group);
		click(driver, Centroid.UsersScreen.btnCreate);
	}
	
	/*
	 * Enter new user data
	 */
	
	public void enterNewUserData (String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String phone, String country, String timeZone, String status)
	{
		click(driver, Centroid.UsersScreen.tabData);
		type(driver, Centroid.UsersScreen.txtFirstName, firstName);
		type(driver, Centroid.UsersScreen.txtLastName, lastName);
		type(driver, Centroid.UsersScreen.txtEmail, email);
		type(driver, Centroid.UsersScreen.txtUserName, userName);
		type(driver, Centroid.UsersScreen.txtPassword, password);
		type(driver, Centroid.UsersScreen.txtPasswordConfirmation, passwordConfirmation);
		type(driver, Centroid.UsersScreen.txtPhone, phone);
		
		selectDropdownItem(driver, Centroid.UsersScreen.cbbCountry, Centroid.UsersScreen.countryItem, country);
		selectDropdownItem(driver, Centroid.UsersScreen.cbbStatus, Centroid.UsersScreen.statusItem, status);
		selectDropdownItem(driver, Centroid.UsersScreen.cbbTimeZone, Centroid.UsersScreen.timeZoneItem, timeZone);
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserRoles (String roles)
	{
		click(driver, Centroid.UsersScreen.tabRoles);
		findDynamicControl(driver, Centroid.UsersScreen.rolesItem, roles).click();
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserGroup (String group)
	{
		click(driver, Centroid.UsersScreen.tabGroups);
		
	}
	
	private WebDriver driver;
}
