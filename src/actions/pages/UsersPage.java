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
		click(driver, Centroid.UsersPage.btnNewUser);
		enterNewUserData(firstName, lastName, email, userName, password, passWordConfirmation, phone, country, timeZone, status);
		selectNewUserRoles(roles);
		selectNewUserGroup(group);
		click(driver, Centroid.UsersPage.btnCreate);
	}
	
	/*
	 * Enter new user data
	 */
	
	public void enterNewUserData (String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String phone, String country, String timeZone, String status)
	{
		click(driver, Centroid.UsersPage.tabData);
		type(driver, Centroid.UsersPage.txtFirstName, firstName);
		type(driver, Centroid.UsersPage.txtLastName, lastName);
		type(driver, Centroid.UsersPage.txtEmail, email);
		type(driver, Centroid.UsersPage.txtUserName, userName);
		type(driver, Centroid.UsersPage.txtPassword, password);
		type(driver, Centroid.UsersPage.txtPasswordConfirmation, passwordConfirmation);
		type(driver, Centroid.UsersPage.txtPhone, phone);
		
		selectDropdownItem(driver, Centroid.UsersPage.cbbCountry, Centroid.UsersPage.countryItem, country);
		selectDropdownItem(driver, Centroid.UsersPage.cbbStatus, Centroid.UsersPage.statusItem, status);
		selectDropdownItem(driver, Centroid.UsersPage.cbbTimeZone, Centroid.UsersPage.timeZoneItem, timeZone);
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserRoles (String roles)
	{
		click(driver, Centroid.UsersPage.tabRoles);
		findDynamicControl(driver, Centroid.UsersPage.rolesItem, roles).click();
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserGroup (String group)
	{
		click(driver, Centroid.UsersPage.tabGroups);
		
	}
	
	private WebDriver driver;
}
