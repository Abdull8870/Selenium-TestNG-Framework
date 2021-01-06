package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods{
	
	public FindLeadPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test; 
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(how=How.XPATH,using="(//div[@class=\"x-form-item x-tab-item\"]/child::div/child::input)[1]")
	private WebElement eleSearchLead;
	
	@FindBy(how=How.XPATH,using="//button[text()=\"Find Leads\"]")
	private WebElement eleFindBtn;
	
	public FindLeadPage searchWithLeadId(String leadId) {
		clearAndType(eleSearchLead, leadId);
		click(eleFindBtn);
		WebElement ele=locateElement("link", leadId);
		Boolean check=checkExistence(ele);
		if(check) {
			click(ele);
		}
		return this;
	}
	
	
	
	

}
