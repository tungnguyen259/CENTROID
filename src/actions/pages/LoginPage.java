package pages;

import org.openqa.selenium.WebDriver;
import pages.AbstractPage;;

	public class LoginPage extends AbstractPage {	
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		
		 /*
		 * @param username
		 * @param password
		 */
		public void login(String email, String password, String checkRemember) {
			type(driver, Centroid.LoginPage.txtEmail, email);
			type(driver, Centroid.LoginPage.txtPassword, password);
			if (checkRemember=="Yes")
			{
				if(!findElement(driver, Centroid.LoginPage.chbRemember).isSelected())
				click(driver, Centroid.LoginPage.chbRemember);
			}
			click(driver, Centroid.LoginPage.btnLogin);
		}
		
		/*
		 * @param message
		 * return true/false
		 */
		public boolean checkErrorLoginMessage(String message)
		{
			return findDynamicControl(driver, Centroid.LoginPage.errorLoginMessage, message).isDisplayed();
		}
		
		/*
		 *
		 * return true/false
		 */
		public boolean checkSigninPageDisplay()
		{
			return findElement(driver, Centroid.LoginPage.signinPage).isDisplayed();
		}
		
	WebDriver driver;
}
