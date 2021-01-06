package selenium.projectSpecificMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import selenium.base.SeleniumBase;
import utils.DataLibrary;


public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;	
	public Properties prop;
	

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	
	

    
	@BeforeClass
	public void beforeClass() throws IOException {
		
		File f = new File("./reports/AutomationScreenshots/" + testCaseName + ".docx");
        if(f.exists()) {
        	f.delete();
        	System.out.println("Old screenshots deleted");
        }
	    prop=new Properties();
		FileInputStream file= new FileInputStream(propertyFile);
		prop.load(file);
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		driver = startApp(browser,url);
		node = test.createNode(testCaseName);
		FileOutputStream fos=new FileOutputStream(propertyFile);
		prop.store(fos, null);
		

	}

	@AfterClass
	public void afterClass() {
		softAssert.assertAll();
		close();
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
//		  File directory =new File("./reports/images");
//		  FileUtils.cleanDirectory(directory);
		
	}
	
	
	













}
