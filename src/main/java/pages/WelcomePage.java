package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods{
	
	public WelcomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	} 
	
	@FindBy(how=How.LINK_TEXT,using="CRM/SFA")
	private WebElement eleLink;
	
	public WelcomePage clickHomeLink() {
		click(eleLink);
		return this;
	}

}
