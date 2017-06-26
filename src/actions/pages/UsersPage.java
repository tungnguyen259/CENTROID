package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		if (password!=null) type(driver, Centroid.UsersPage.txtPassword, password);
		if (passwordConfirmation!=null) type(driver, Centroid.UsersPage.txtPasswordConfirmation, passwordConfirmation);
		type(driver, Centroid.UsersPage.txtPhone, phone);
		
		//selectDropdownItem(driver, Centroid.UsersPage.cbbCountry, Centroid.UsersPage.countryItem, country);
		selectDropdownItem(driver, Centroid.UsersPage.cbbStatus, Centroid.UsersPage.statusItem, status);
		selectDropdownItem(driver, Centroid.UsersPage.cbbTimeZone, Centroid.UsersPage.timeZoneItem, timeZone);
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserRoles (String roles)
	{
		click(driver, Centroid.UsersPage.tabRoles);
		//findDynamicControl(driver, Centroid.UsersPage.rolesItem, "Guest").click();
		findDynamicControl(driver, Centroid.UsersPage.rolesItem, roles).click();
	}
	
	/*
	 * Select roles for new user 
	 */
	
	public void selectNewUserGroup (String group)
	{
		click(driver, Centroid.UsersPage.tabGroups);
		
	}
	
	/*
	 * Check user has just created
	 */
	
	public boolean checkUserData (String firstName, String lastName, String email, String status, String roles)
	{
			boolean a = false, b = false, c = false, d = false, e = false;
			searchUser(email);
			WebElement tableElement = findElement(driver, Centroid.UsersPage.tbUsers);
			List <WebElement> rows = tableElement.findElements(By.xpath("tbody/tr")); 
			List <WebElement> colums = tableElement.findElements(By.xpath("thead/tr/th"));
			for (int i=1; i<=rows.size(); i++)
			{
				for (int j=3; j<colums.size()-1;j++)
				{
					if(j==3) a = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().equals(firstName);
					if(j==4) b = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().equals(lastName);
					if(j==5) c = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().equals(email);
					if(j==6) d = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().equals(status);
					if(j==7) e = findElement(driver, By.xpath(String.format(Centroid.UsersPage.rolesCell, i, j, roles))).isDisplayed();
				//if (rows.get(i).getText().contains(firstName)) break;
				}
				if ((a && b && c && d && e)==true) break;
			}
		
		return (a && b && c && d && e);
	}
	
	
	/*
	 * Enter field to search
	 */
	
	public void searchUser(String searchData)
	{
		type(driver, Centroid.UsersPage.txtSearch, searchData);
		sleep(2);
	}
	
	/*
	 * Enter field to search
	 * Check data search exist in lastname or firstname or email
	 */
	
	public boolean checkSearchUser(String searchData)
	{
		boolean a = true, b = true, c = true;
		int i, j;
		searchUser(searchData);
		WebElement tableElement = findElement(driver, Centroid.UsersPage.tbUsers);
		List <WebElement> rows = tableElement.findElements(By.xpath("tbody/tr")); 
		List <WebElement> colums = tableElement.findElements(By.xpath("thead/tr/th"));
		for (i=1; i<=rows.size(); i++)
		{
			for (j=3; j<=colums.size()-3;j++)
			{
				if(j==3) 
				{
					a = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(searchData);
					if (a==true) break;
				}
				if(j==4) 
				{
					b = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(searchData);
					if (b==true) break;
				}
				if(j==5) 
				{
					c = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(searchData);
					if (c==true) break;
					else return c;
				}
			}
			if (c==false) break;	
			else c=true;
		}
		return c;
	}
	
	
	/*
	 * Enter email to delete
	 * 
	 */
	public void deleteUser(String email)
	{
		searchUser(email);
		click(driver, Centroid.UsersPage.btnDelete);
		click(driver, Centroid.UsersPage.btnOk);
		sleep(2);
	}
	
	/*
	 * Record is removed
	 * No record table displays
	 */
	public boolean checkUserIsNotExisted(String email)
	{
		searchUser(email);
		return findElement(driver, Centroid.UsersPage.noRecordRow).isDisplayed();
	}
	
	/*
	 * enter infor and select filter 
	 * No record table displays
	 */
	public void selectFilter(String firstName, String lastName, String email, String status, String roles)
	{
		if (firstName!= null) type(driver, Centroid.UsersPage.txtFirstNameFilter, firstName);
		if (lastName!= null) type(driver, Centroid.UsersPage.txtLastNameFilter, lastName);
		if (email!= null) type(driver, Centroid.UsersPage.txtEmailFilter, email);
		if (status!= null) selectDropdownItem(driver, Centroid.UsersPage.cbbStatusFilter, Centroid.UsersPage.statusFilterItem, status);
		if (roles!= null) selectDropdownItem(driver, Centroid.UsersPage.cbbRolesFilter, Centroid.UsersPage.rolesFilterItem, roles);
		click(driver, Centroid.UsersPage.btnFilter);
	}
	
	
	/*
	 * Check user has just created
	 */
	
	public boolean checkFilterTable (String firstName, String lastName, String email, String status, String roles)
	{
			boolean a = false, b = false, c = false, d = false, e = false;
			searchUser(email);
			WebElement tableElement = findElement(driver, Centroid.UsersPage.tbUsers);
			List <WebElement> rows = tableElement.findElements(By.xpath("tbody/tr")); 
			List <WebElement> colums = tableElement.findElements(By.xpath("thead/tr/th"));
			for (int i=1; i<=rows.size(); i++)
			{
				for (int j=3; j<colums.size()-1;j++)
				{
					if(j==3) a = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(firstName);
					if(j==4) b = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(lastName);
					if(j==5) c = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(email);
					if(j==6) d = findElement(driver, By.xpath(String.format(Centroid.UsersPage.tableCell, i, j))).getText().contains(status);
					if(j==7) e = findElement(driver, By.xpath(String.format(Centroid.UsersPage.rolesCell, i, j, roles))).isDisplayed();
				//if (rows.get(i).getText().contains(firstName)) break;
				}
				if ((a && b && c && d && e)==true) break;
			}
		
		return (a && b && c && d && e);
	}
	
	/*
	 * Edit user
	 */
	
	public void editUser(String firstName, String lastName, String userName, String email, String phone, String country, String timeZone, String status, String roles)
	{
	click(driver, Centroid.UsersPage.btnEdit);
	selectEditPageButtons("Data");
	type(driver, Centroid.UsersPage.txtFirstName, firstName);
	type(driver, Centroid.UsersPage.txtLastName, lastName);
	type(driver, Centroid.UsersPage.txtEmail, email);
	type(driver, Centroid.UsersPage.txtUserName, userName);
	type(driver, Centroid.UsersPage.txtPhone, phone);

	selectDropdownItem(driver, Centroid.UsersPage.cbbEditStatus, Centroid.UsersPage.editStatusItem, status);
	//selectDropdownItem(driver, Centroid.UsersPage.cbbCountry, Centroid.UsersPage.countryItem, country);
	//selectDropdownItem(driver, Centroid.UsersPage.cbbTimeZone, Centroid.UsersPage.timeZoneItem, timeZone);
	selectNewUserRoles(roles);
	click(driver, Centroid.UsersPage.btnUpdate);
	}
	
	/*
	 * Edit user
	 */
	
	public void selectEditPageButtons(String button)
	{
		if (button.equals("Update")) click(driver, Centroid.UsersPage.btnUpdate);
		if (button.equals("Cancel")) click(driver, Centroid.UsersPage.btnCancel);
		if (button.equals("Reset")) click(driver, Centroid.UsersPage.btnReset);
		if (button.equals("Data")) click(driver, Centroid.UsersPage.tabData);
		if (button.equals("Roles")) click(driver, Centroid.UsersPage.tabRoles);
	}
	
	private WebDriver driver;
}
