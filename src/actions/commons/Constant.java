package commons;

import org.openqa.selenium.WebDriver;

public class Constant 
{
	public static String url;
	public static String email;
	public static String password;
	public static String grid;
	public static final int longWaitTime = 8;
	public static final int shortWaitTime = 5;
	public static final String configFilePath = "src/configurations/configurations.xml";
	public static final String dataFilePath = "src/configurations/data.xml";
	public static final String urlMobile = "https://rainmakerlabs.outsystemscloud.com/PreviewInDevices/?IsMobilePreview=True&DeviceName=Smartphone&URL=/DaimlerMEXMobile/HomeScreen?_ts=636269020166138833";
	public static WebDriver driver = null; 
	
	//=================button============================================
	public static final String saveButton = "Save";
	public static final String saveNewButton = "Save&New";
	public static final String saveCloseButton = "Save&Close";
	public static final String deleteButton = "Delete";
	public static final String helpButton = "Help";
	public static final String cancelButton = "Cancel";
	
	
	//===================driver===============================================
	public static final String driverPath = "src//resources//";
	public static final String ieWebDriver= "webdriver.ie.driver";
	public static final String ieServerDriver= "IEDriverServer.exe";
	public static final String chromeWebDriver= "webdriver.chrome.driver";
	public static final String chromeServerDriver= "chromedriver.exe";
	
	//=================== Filter item: combobox and value =================================
	public static final String statusCombobox = "Select Status";
	public static final String statusPublished = "Published";
	public static final String statusUnpublished = "Unpublished";
	public static final String statusArchived = "Archived";
	public static final String statusTrashed = "Trashed";
	public static final String statusAll = "All";
	public static final String clientCombobox = "Select Client";
	public static final String accessCombobox = "Select Access";
	public static final String accessRegistered = "Registered";
	public static final String authorCombobox = "Select Author";
	public static final String categoryCombobox = "Select Category";
	public static final String languageCombobox= "Select Language";
	public static final String languageEnglish = "English (UK)";
	
	public static final String searchTxt = "div/div/input";
}
