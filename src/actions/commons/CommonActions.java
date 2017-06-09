package actions.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CommonActions {

	public static CommonActions getCommonObject(){
		if(commonObject==null){
			commonObject = new CommonActions();
		}
		return commonObject;
	}
	
	public void getAutomationCofiguration(){
		Constant.url = getConfiguration("url");
		Constant.username = getConfiguration("username");
		Constant.password = getConfiguration("password");
		//Constant.grid = getConfiguration("grid");
	}
	/**
	 * Get
	 * @param config
	 * @return value in a tag
	 */
	public String getConfiguration(String config) {
		Document document = null;
		String filePath = Constant.configFilePath;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			InputStream inStream = new FileInputStream(new File(filePath));
			document = (Document) builder.parse(inStream);
		} catch (Exception e) {
			System.out.println("Can't configure the XML parser." + e);
		}

		Node element = document.getElementsByTagName(config).item(0);
		String result = element.getTextContent();
		return result;
	}
	
	/**
	 * Load value from data file 
	 * @param modulename
	 * @param testname
	 * @return 
	 */
	public String getDataset(String modulename, String testname) {
		String returnValue = "";
		Document document = null;
		String filePath = Constant.dataFilePath;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			InputStream inStream = new FileInputStream(new File(filePath));
			document = (Document) builder.parse(inStream);
		} catch (Exception e) {
			System.out.println("Can't configure the XML parser." + e);
		}

		NodeList element = document.getElementsByTagName("testmodule");

		for (int i = 0; i < element.getLength(); i++) {
			Node node = element.item(i);
			if (node.hasAttributes()) {
				Attr attr = (Attr) node.getAttributes().getNamedItem("name");
				if (attr != null) {
					String attribute = attr.getValue();
					if (attribute.equals(modulename)) {
						Element eElement = (Element) node;
						Node node2 = eElement.getElementsByTagName(testname).item(0);
						returnValue = node2.getTextContent();
						break;
					}
				}
			}
		}
		return returnValue;
	}
	/**
	 * Create a datetime string 
	 * @return 
	 */
	public String getRandomString(){
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}
	
	/**
	 * take picture when TC fails
	 * @param driver
	 * @param imagename
	 */
	public void takeScreenShot(WebDriver driver,String imagename) {
		  String filePath = "test-output\\";
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(scrFile, new File(filePath + imagename+ ".png"));
		   System.out.println("Saved " + imagename + ".png" + " screenshot in " + filePath);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
	
	private static CommonActions commonObject;
}


