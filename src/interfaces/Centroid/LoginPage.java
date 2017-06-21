package Centroid;

import org.openqa.selenium.By;

	public class LoginPage {
		public static By txtEmail = By.xpath("//input[@class='form-control' and @type='email']");
		public static By txtPassword = By.xpath("//input[@class='form-control' and @type='password']");
		public static By btnLogin = By.xpath("//button[text()='Sign in']");
		public static By chbRemember = By.xpath("//input[@id='remember_me']");
		public static By signinPage = By.xpath("//div[@class='header' and text()='Sign in']");
		
		//Dynamic control
		
		public static String errorLoginMessage = ("//div[@class='alert alert-danger' and contains(.,'%s')]");
	}


