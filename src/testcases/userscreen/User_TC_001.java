package userscreen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import commons.AbstractTest;
import commons.CommonActions;
import commons.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;


@Listeners(configure.TestListeners.class)
public class User_TC_001 extends AbstractTest{

@Parameters({"browser"})
@BeforeClass(alwaysRun = true)  

  public void setup (String browser) {
	  driver = openBrowser(browser);  
	  firstName = CommonActions.getCommonObject().getDataset("TC_Users", "firstName");
	  lastName = CommonActions.getCommonObject().getDataset("TC_Users", "lastName");
	  email = CommonActions.getCommonObject().getDataset("TC_Users", "email");
	  userName = CommonActions.getCommonObject().getDataset("TC_Users", "userName");
	  password = CommonActions.getCommonObject().getDataset("TC_Users", "password");
	  passwordConfirmation = CommonActions.getCommonObject().getDataset("TC_Users", "passwordConfirmation");
	  phone = CommonActions.getCommonObject().getDataset("TC_Users", "phone");
	  country = CommonActions.getCommonObject().getDataset("TC_Users", "country");
	  timeZone = CommonActions.getCommonObject().getDataset("TC_Users", "timeZone");
	  status = CommonActions.getCommonObject().getDataset("TC_Users", "status");
	  roles = CommonActions.getCommonObject().getDataset("TC_Users", "roles");
	  group = CommonActions.getCommonObject().getDataset("TC_Users", "group");
	  createSuccessfulMessage = CommonActions.getCommonObject().getDataset("TC_Users", "createSuccessfulMessage");
	  searchData = CommonActions.getCommonObject().getDataset("TC_Users", "searchData");  
	  newFirstName = CommonActions.getCommonObject().getDataset("TC_Users", "newFirstName");
	  newLastName = CommonActions.getCommonObject().getDataset("TC_Users", "newLastName");
	  newEmail = CommonActions.getCommonObject().getDataset("TC_Users", "newEmail");
	  newUserName = CommonActions.getCommonObject().getDataset("TC_Users", "newUserName");
	  newPhone = CommonActions.getCommonObject().getDataset("TC_Users", "newPhone");
	  newCountry = CommonActions.getCommonObject().getDataset("TC_Users", "newCountry");
	  newTimeZone = CommonActions.getCommonObject().getDataset("TC_Users", "newTimeZone");
	  newStatus = CommonActions.getCommonObject().getDataset("TC_Users", "newStatus");
	  newRoles = CommonActions.getCommonObject().getDataset("TC_Users", "newRoles");
	  updateSuccessfulMessage = CommonActions.getCommonObject().getDataset("TC_Users", "updateSuccessfulMessage");
  }
  
  @Test (description = "Verify User is able to create new users")
public void TC_Users001 () { 
	loginPageObject = new LoginPage(driver);
	homePageObject = new HomePage(driver);
	usersPageObject = new UsersPage(driver);
	
	log.info("Step 1: Open Centroid Webside");
	navigateBrowser(driver, Constant.url);
	
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(Constant.email, Constant.password, "No");
	
	log.info("Step 4: Enter Users screen");
	homePageObject.selectMenuItem(driver, "Users", "Users");
	
	log.info("Step 5: Create new user with valid information");
	usersPageObject.createNewUser(firstName, lastName, email, userName, password, passwordConfirmation, phone, country, timeZone, status, roles, group);
	
	log.info("VP: Successful message displays");
	verifyTrue(	usersPageObject.checkSuccessfulMessage(driver, createSuccessfulMessage));
	
	log.info("VP: Check account is created");
	verifyTrue(	usersPageObject.checkUserData(firstName, lastName, email, status, roles));
}
  
  @Test (description = "Verify User is able to search with any information")
public void TC_Users002 () {  
	log.info("Step 1: Open Centroid Webside");
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");	
	log.info("Step 4: Enter Users screen");
	log.info("Step 5: Serach any user");	
	usersPageObject.searchUser(searchData);
	
	log.info("VP: Check user data displays correctly");
	verifyTrue(usersPageObject.checkSearchUser(searchData));
	
}
  
  @Test (description = "Verify User is able to edit user")
public void TC_Users003 () {	  
	log.info("Step 1: Open Centroid Webside");
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");	
	log.info("Step 4: Enter Users screen");
	log.info("Step 5: Edit any user");
	usersPageObject.editUser(newFirstName, newLastName, newUserName, newEmail, newPhone, newCountry, newTimeZone, newStatus, newRoles);
	
	log.info("VP: Check Successful Message");
	verifyTrue(usersPageObject.checkSuccessfulMessage(driver, updateSuccessfulMessage));	
	usersPageObject.selectEditPageButtons("Cancel");
	
	log.info("VP: Check user data after editing");
	verifyTrue(	usersPageObject.checkUserData(newFirstName, newLastName, newEmail, newStatus, newRoles));
}
  
  @Test (description = "Verify User is able to filter users")
public void TC_Users004 () {	  
	log.info("Step 1: Open Centroid Webside");
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");	
	log.info("Step 4: Enter Users screen");
	log.info("Step 5: Enter data into filter field and click on Filter");
	usersPageObject.selectFilter(newFirstName, newLastName, newEmail, newStatus, newRoles);
	
	log.info("VP: Check data filter correctly");
	verifyTrue(usersPageObject.checkFilterTable(newFirstName, newLastName, newEmail, newStatus, newRoles));	
}
  
  @Test (description = "Verify User is able to delete an user")
public void TC_Users005 () {	  
	log.info("Step 1: Open Centroid Webside");
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");	
	log.info("Step 4: Enter Users screen");
	log.info("Step 5: Delete any user");
	usersPageObject.deleteUser(newEmail);
	
	log.info("VP: Check user data is not exist in user table");
	verifyTrue(usersPageObject.checkUserIsNotExisted(newEmail));
	
	log.info("Post Condition: Logout");
	usersPageObject.logout(driver);
}
  
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser(driver);
	}

private WebDriver driver;
private LoginPage loginPageObject;
private HomePage homePageObject;
private UsersPage usersPageObject;
private String searchData;
private String createSuccessfulMessage;
private String firstName;
private String lastName;
private String email;
private String userName;
private String password;
private String passwordConfirmation;
private String phone;
private String country;
private String timeZone;
private String status;
private String roles;
private String group;
private String updateSuccessfulMessage;
private String newFirstName;
private String newLastName;
private String newEmail;
private String newUserName;
private String newPhone;
private String newCountry;
private String newTimeZone;
private String newStatus;
private String newRoles;
}

