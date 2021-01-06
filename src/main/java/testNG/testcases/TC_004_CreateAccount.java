package testNG.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.CreateLeadPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.ViewLeadPage;
import pages.loginPage;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class TC_004_CreateAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Leads";
		testDescription = "Login with the DemosalesManager credentials and create Account by using data in the dataprovider";
		nodes = "Leads";
		authors = "Abdul";
		category = "Functional";
		dataSheetName = "CreateAccount";
	}
	
    @Parameters({"UserName","PassWord"})
	@Test()
	public void loginUser(String UserName,String PassWord) throws InterruptedException, IOException {
    	
 
    	
		loginPage login=new loginPage(driver, node, test);
		login.loginUser(UserName, PassWord).clickHomeLink();
		new HomePage(driver, node, test).clickAccountTab();
		
	}
   

   @Test(dependsOnMethods = {"loginUser"},dataProvider="fetchData")
   public void creatLead(String accountName,String currencyType,String industryType,String ContactNumber,
		   String email) throws InterruptedException {
	   
		new MyAccountPage(driver, node, test).clickCreateAccount();
		new CreateAccountPage(driver, node, test).enterAccountDetails(accountName, currencyType, 
				industryType, ContactNumber, email);
	   
	  
   }

}
