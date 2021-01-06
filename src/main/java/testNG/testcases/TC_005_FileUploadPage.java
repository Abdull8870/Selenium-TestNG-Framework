package testNG.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FileUploadPage;
import pages.FindLeadPage;
import pages.HomePage;
import pages.MyLeadPage;
import pages.loginPage;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class TC_005_FileUploadPage extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Upload File";
		testDescription = "This test will upload file with the help of AutoIt";
		nodes = "Uploads";
		authors = "Abdul";
		category = "Example";
		dataSheetName = "";
	}
	
    @Parameters({"webSite","fileName"})
	@Test()
	public void uploadFile(String webSite,String fileName) throws InterruptedException, IOException {
    	
      new FileUploadPage(driver, node, test).clickChooseFile(webSite, fileName);
		
		
	}

}
