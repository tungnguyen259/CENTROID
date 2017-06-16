package LoginScreen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.CommonActions;
import commons.Constant;
import pages.HomePage;
import pages.LoginPage;

@Listeners(configure.TestListeners.class)
public class Login extends AbstractTest{

@Parameters({"browser"})
@BeforeClass(alwaysRun = true)  
  public void setup (String browser) {
	  driver = openBrowser(browser);  
	  dashboardPage = CommonActions.getCommonObject().getDataset("TC_Login", "pageName");
	  loginSuccessfulMessage = CommonActions.getCommonObject().getDataset("TC_Login", "loginSuccessfulMessage");
	  
  }
  
  @Test (description = "Verify user is albe to login with valid information")
public void TC_Login001 () {
	  
	loginPageObject = new LoginPage(driver);
	homePageObject = new HomePage(driver);
	  
	log.info("Step 1: Open Centroid Webside");
	navigateBrowser(driver, Constant.url);
	
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(Constant.email, Constant.password, "No");
	
	log.info("VP: User is able to login successfully");
	verifyTrue(homePageObject.checkPageDisplay(driver, dashboardPage));
	log.info("VP: Successful Message displays");
	verifyTrue(homePageObject.checkSuccessfulMessage(loginSuccessfulMessage));
	
}
  
  @Test (description = "Verify user is unalbe to login with invalid information")
public void TC_Login002 () {
	    
	log.info("Step 1: Open Centroid Webside");
	navigateBrowser(driver, Constant.url);
	
	log.info("Step 2: Enter valid email and password");
	log.info("Step 3: Click on 'Sign In' button");
	loginPageObject.login(Constant.email, Constant.password, "No");
	
	log.info("VP: User is able to login successfully");
	verifyTrue(homePageObject.checkPageDisplay(driver, dashboardPage));
	
	log.info("VP: Successful Message displays");
	verifyTrue(homePageObject.checkSuccessfulMessage(loginSuccessfulMessage));
	
}
  
  private WebDriver driver;
  private LoginPage loginPageObject;
  private HomePage homePageObject;
  private String dashboardPage;
  private String loginSuccessfulMessage;
}
