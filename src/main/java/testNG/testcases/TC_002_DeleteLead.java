package testNG.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.HomePage;
import pages.MyLeadPage;
import pages.ViewLeadPage;
import pages.loginPage;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class TC_002_DeleteLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete Lead";
		testDescription = "This test will delete the last created lead";
		nodes = "Leads";
		authors = "Abdul";
		category = "Functional";
		dataSheetName = "";
	}
	
    @Parameters({"UserName","PassWord"})
	@Test()
	public void deleteLead(String UserName,String PassWord) throws InterruptedException, IOException {
    	
    	System.out.println(UserName+" "+PassWord);
    	
		loginPage login=new loginPage(driver, node, test);
		login.loginUser(UserName, PassWord).clickHomeLink();
		HomePage home=new HomePage(driver, node, test);
		home.clickLeadTab();
		MyLeadPage myLead=new MyLeadPage(driver, node, test);
		myLead.clickOnTheCreatedLead().clickDelete();
		
		
	}
   


}
