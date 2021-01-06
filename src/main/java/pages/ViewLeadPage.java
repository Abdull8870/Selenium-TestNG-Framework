package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {
	
	public ViewLeadPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test)
	{
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="viewLead_companyName_sp")
	private WebElement eleCompanyName;
	
	public ViewLeadPage storeLeadId() {
		System.out.println("Inside store lead ID");
		storeExtractedText(eleCompanyName,"leadId");
		return this;
		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Delete")
	private WebElement eleDelete;
	
	public MyLeadPage clickDelete() {
		Boolean check=checkExistence(eleDelete);
		if(check) {
		click(eleDelete);
		}
		return new MyLeadPage(driver, node, test);
	}
	
	
}
