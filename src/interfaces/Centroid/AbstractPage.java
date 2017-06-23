package Centroid;
import org.openqa.selenium.By;

public class AbstractPage {
	
	public static By drdUser = By.xpath("//span[contains(.,'demo User')]");
	public static By btnLogout = By.xpath("//a[@class='btn btn-default btn-flat' and text()='Sign out']");
	
	//Dynamic control
	public static String menuItems = ("//a[@href='#']/span[text()='%s']");
	public static String subMenuItems = ("//a[contains(@href,'http')]/span[text()='%s']");
	public static String titlePage = ("//h1[contains(text(),'%s')]");
	public static String successfulMessage = ("//div[contains(@class,'alert') and contains(.,'%s')]");
}
