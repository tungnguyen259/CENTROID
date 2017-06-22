package userscreen;

package loginscreen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import commons.AbstractTest;
import commons.CommonActions;
import commons.Constant;
import pages.HomePage;
import pages.LoginPage;

@Listeners(configure.TestListeners.class)
public class User_TC_001 extends AbstractTest{

@Parameters({"browser"})
@BeforeClass(alwaysRun = true)  

  public void setup (String browser) {
	  driver = openBrowser(browser);  
	  dashboardPage = CommonActions.getCommonObject().getDataset("TC_Users", "dashboardPage");
	  loginSuccessfulMessage = CommonActions.getCommonObject().getDataset("TC_Users", "loginSuccessfulMessage");
	  invalidUsername = CommonActions.getCommonObject().getDataset("TC_Users", "invalidUsername");
	  invalidPassword = CommonActions.getCommonObject().getDataset("TC_Users", "invalidPassword");
	  loginErrorMessage = CommonActions.getCommonObject().getDataset("TC_Users", "loginErrorMessage");
  }
  
  @Test (description = "Verify User is able to create new users")
public void TC_Users001 () {
	  
	loginPageObject = new LoginPage(driver);
	homePageObject = new HomePage(driver);
	  
	log.info("Step 1: Open Centroid Webside");
	navigateBrowser(driver, Constant.url);
	
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(Constant.email, Constant.password, "No");
	
	log.info("Step 4: Enter Users screen");
	homePageObject.selectMenuItem(driver, "Users", "Users");
	
	log.info("Step 5: Create new user with valid information");
	homePageObject.selectMenuItem(driver, "Users", "Users");
	
	log.info("VP: Error Message displays");
	verifyTrue(loginPageObject.checkErrorLoginMessage(loginErrorMessage));
	
}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser(driver);
	}

private WebDriver driver;
private LoginPage loginPageObject;
private HomePage homePageObject;
private String dashboardPage;
private String loginSuccessfulMessage;
private String invalidUsername;
private String invalidPassword;
private String loginErrorMessage;

}

