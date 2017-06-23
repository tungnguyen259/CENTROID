package Centroid;

import org.openqa.selenium.By;

public class UsersPage {

	public static By tabData = By.xpath("//a[text()='Data']");
	public static By tabRoles = By.xpath("//a[text()='Roles']");
	public static By tabGroups = By.xpath("//a[text()='Groups']");
	public static By txtFirstName = By.xpath("//input[@id='first_name']");
	public static By txtLastName = By.xpath("//input[@id='last_name']");
	public static By txtEmail = By.xpath("//input[@id='email']");
	public static By txtUserName = By.xpath("//input[@id='username']");
	public static By txtPassword = By.xpath("//input[@id='password']");
	public static By txtPasswordConfirmation = By.xpath("//input[@id='password_confirmation']");
	public static By txtPhone = By.xpath("//input[@id='phone_number']");
	public static By cbbCountry = By.xpath("//select[@id='country_id']");
	public static By cbbTimeZone = By.xpath("//select[@id='timezone_id']");
	public static By cbbStatus = By.xpath("//select[@id='status']");
	public static By roles = By.xpath("//select[@id='roles[]']");
	public static By txtSearch = By.xpath("//input[@class='form-control input-sm']");
	public static By tbUsers = By.xpath("//table[@id='dataTableBuilder']");
	public static By noRecordRow = By.xpath("//tbody/tr/td[@class='dataTables_empty' and text()='No matching records found']");
	
	//-------Button---------
	public static By btnCreate = By.xpath("//button[@class='btn btn-primary btn-flat' and text()='Create']");
	public static By btnReset = By.xpath("//button[@class='btn btn-default btn-flat' and text()='Reset']");
	public static By btnCancel = By.xpath("//a[@class='btn btn-danger pull-right btn-flat']");
	public static By btnNewUser = By.xpath("//a[text()='New User']");
	public static By btnDelete = By.xpath("//a[@class='btn btn-danger btn-flat']");
	public static By btnOk = By.xpath("//button[@class='btn btn-default' and text()='OK']");
	
	//---Dynamic Control--------------//
	public static String countryItem = ("//option[text()='%s']");
	public static String timeZoneItem = ("//option[text()='%s']");
	public static String statusItem = ("//option[text()='%s']");
	public static String rolesItem = ("//option[contains(text(),'%s')]");
	public static String tableCell = ("//tbody/tr[%2d]/td[%2d]");
	public static String rolesCell = ("//tbody/tr[%2d]/td[%2d]/ul/li[text()='%s']");
}
