package loginscreen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.CommonActions;
import commons.Constant;
import pages.HomePage;
import pages.LoginPage;

@Listeners(configure.TestListeners.class)
public class Login_TC_001 extends AbstractTest{

@Parameters({"browser"})
@BeforeClass(alwaysRun = true)  

  public void setup (String browser) {
	  driver = openBrowser(browser);  
	  dashboardPage = CommonActions.getCommonObject().getDataset("TC_Login", "dashboardPage");
	  loginSuccessfulMessage = CommonActions.getCommonObject().getDataset("TC_Login", "loginSuccessfulMessage");
	  invalidUsername = CommonActions.getCommonObject().getDataset("TC_Login", "invalidUsername");
	  invalidPassword = CommonActions.getCommonObject().getDataset("TC_Login", "invalidPassword");
	  loginErrorMessage = CommonActions.getCommonObject().getDataset("TC_Login", "loginErrorMessage");
  }
  
  @Test (description = "Verify user is unable to login with invalid information")
public void TC_Login001 () {	  
	loginPageObject = new LoginPage(driver);
	homePageObject = new HomePage(driver);
	  
	log.info("Step 1: Open Centroid Webside");
	navigateBrowser(driver, Constant.url);
	
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(invalidUsername, invalidPassword, "No");
	
	log.info("VP: User is still on Signin Page");
	verifyTrue(loginPageObject.checkSigninPageDisplay());
	
	log.info("VP: Error Message displays");
	verifyTrue(loginPageObject.checkErrorLoginMessage(loginErrorMessage));	
}
  
  @Test (description = "Verify user is able to login with valid information")
public void TC_Login002 () {	    
	log.info("Step 1: Open Centroid Webside");
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(Constant.email, Constant.password, "No");
	
	log.info("VP: User is able to login successfully");
	verifyTrue(homePageObject.checkPageDisplay(driver, dashboardPage));
	
	log.info("VP: Successful Message displays");
	verifyTrue(homePageObject.checkSuccessfulMessage(loginSuccessfulMessage));
}
  
  @Test (description = "Verify user is able to logout")
public void TC_Login003 () {	  
		log.info("Step 1: Open Centroid Webside");
		log.info("Step 2: Sign in to system by valid email and password");
		log.info("Step 3: Sign Out");
		homePageObject.logout(driver);
		
		log.info("VP: Verify Sign in screen displays");
		verifyTrue(loginPageObject.checkSigninPageDisplay());	
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
