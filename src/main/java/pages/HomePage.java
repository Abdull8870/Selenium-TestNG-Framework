package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.LINK_TEXT,using="Create Lead")
	private WebElement eleCreateLead;
	
	@FindBy(how=How.LINK_TEXT,using="Accounts")
	private WebElement eleAccounTab;
	
	@FindBy(how=How.LINK_TEXT,using="Create Contact")
	private WebElement eleCreateContact;
	
	@FindBy(how=How.LINK_TEXT,using="Leads")
	private WebElement eleLeads;
	
	public HomePage clickCreateLead() {
		click(eleCreateLead);
		return this;
	}
	
	public HomePage clickAccountTab() {
		click(eleAccounTab);
		return this;
	}
	
	public HomePage clickCreateContact() {
		click(eleCreateContact);
		return this;
	}
	
	public HomePage clickLeadTab() {
		click(eleLeads);
		return this;
	}
	
	public HomePage clickCreateAccountTab() {
		click(eleAccounTab);
		return this;
	}
}


