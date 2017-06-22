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

	log.info("VP: Account is created");
	
}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser(driver);
	}

private WebDriver driver;
private LoginPage loginPageObject;
private HomePage homePageObject;
private UsersPage usersPageObject;
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

}

