package actions.commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserManage {

	public WebDriver openBrowser(String browser) {
		WebDriver driver;
		if (browser.equals("IE")) {
			System.setProperty(Constant.ieWebDriver, Constant.driverPath + Constant.ieServerDriver);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("enablePersistentHover", true);
			driver = new InternetExplorerDriver(ieCapabilities);
		} else if (browser.equals("Chrome")) {
			System.setProperty(Constant.chromeWebDriver, Constant.driverPath + Constant.chromeServerDriver);
			driver = new ChromeDriver();
		} else{
		      // Path to geckodriver executable
	        System.setProperty("webdriver.gecko.driver", "D:\\CENTROID\\CENTROID\\libs\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public void navigateBrowser(WebDriver driver, String url) {
		driver.get(url);
	}

	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
