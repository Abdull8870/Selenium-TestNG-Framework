package testNG.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.HomePage;
import pages.MyLeadPage;
import pages.loginPage;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class TC_003_FindLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete Lead";
		testDescription = "This test will delete the last created lead";
		nodes = "Leads";
		authors = "Abdul";
		category = "Functional";
		dataSheetName = "";
	}
	
    @Parameters({"UserName","PassWord","leadId"})
	@Test()
	public void findLead(String UserName,String PassWord,String leadId) throws InterruptedException, IOException {
    	
    	System.out.println(UserName+" "+PassWord);
    	
		loginPage login=new loginPage(driver, node, test);
		login.loginUser(UserName, PassWord).clickHomeLink();
		HomePage home=new HomePage(driver, node, test);
		home.clickLeadTab();
		MyLeadPage myLead=new MyLeadPage(driver, node, test);
		myLead.clickFindLead();
		FindLeadPage findLead=new FindLeadPage (driver, node, test);
		findLead.searchWithLeadId(leadId);
		
		
	}
   

}
