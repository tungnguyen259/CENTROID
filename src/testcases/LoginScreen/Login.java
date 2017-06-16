package LoginScreen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.Constant;
import pages.HomePage;
import pages.LoginPage;

@Listeners(configure.TestListeners.class)
public class Login extends AbstractTest{

@Parameters({"browser"})
@BeforeClass(alwaysRun = true)  
  public void f (String browser) {
	  driver = openBrowser(browser);  
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
	verifyTrue(homePageObject.checkPageDisplay(driver, pages));
	log.info("VP: Successful Message displays");
	verifyTrue(homePageObject.checkSuccessfulMessage(message));
	
}
  
  private WebDriver driver;
  private LoginPage loginPageObject;
  private HomePage homePageObject;
  private String pages = "Dashboard";
  private String message ="Successfully logged in";
}
