package testNG.testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.HomePage;
import pages.ViewLeadPage;
import pages.WelcomePage;
import pages.loginPage;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class TC_001_CreateLeads extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Leads";
		testDescription = "Login with the DemosalesManager credentials and create leads by using data in the dataprovider";
		nodes = "Leads";
		authors = "Abdul";
		category = "Functional";
		dataSheetName = "CreateLead";
	}
	
    @Parameters({"UserName","PassWord"})
	@Test()
	public void loginUser(String UserName,String PassWord) throws InterruptedException, IOException {
    	
    	System.out.println(UserName+" "+PassWord);
    	
		loginPage login=new loginPage(driver, node, test);
		login.loginUser(UserName, PassWord).clickHomeLink();
		
	}
   

   @Test(dependsOnMethods = {"loginUser"},dataProvider="fetchData")
   public void creatLead(String companyName,String FirstName,String LastName,String ContactNumber,
		   String email) throws InterruptedException {
	   
		new HomePage(driver, node, test).clickCreateLead();
		new CreateLeadPage(driver, node, test).enterLeadDetails(companyName, FirstName, LastName,
				ContactNumber,email).clickSubmit();
		
	    new ViewLeadPage(driver, node, test).storeLeadId();
	   
	  
   }



}
