package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class CreateAccountPage extends ProjectSpecificMethods{
	
	public CreateAccountPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test)
	{
		this.driver = driver;
		this.node = node;
		this.test = test; 
		PageFactory.initElements(driver,this);
	} 
	
	 @FindBy(how=How.ID,using="accountName")
	 private WebElement eleAccountName;
	
	 @FindBy(how=How.ID,using="currencyUomId")
	 private WebElement eleCuurencyDropDowm;
	 
	 @FindBy(how=How.NAME,using="industryEnumId")
	 private WebElement eleIndsutryType;
	 
	 @FindBy(how=How.ID,using="primaryPhoneNumber")
	 private WebElement elePhoneNumber;
	 
	 @FindBy(how=How.ID,using="primaryEmail")
	 private WebElement eleEmail;
	 
	 @FindBy(how=How.CLASS_NAME,using="smallSubmit")
	 private WebElement eleSubmit;
	 
	 @FindBy(how=How.CLASS_NAME,using="errorMessageHeader")
	 private WebElement eleErrorMsg;
	 
	 @FindBy(how=How.XPATH,using="//span[text()=\"Account Name\"]/../following-sibling::td[1]/child::span")
	 private WebElement eleAccountId;
	 
	 public CreateAccountPage enterAccountDetails(String accountNume,String currencyType,
			 String industryType,String poneNumber,String email) {
		   
		 clearAndType(eleAccountName, accountNume);
		 selectDropDownUsingValue(eleCuurencyDropDowm, currencyType);
		 selectDropDownUsingText(eleIndsutryType, industryType);
		 clearAndType(elePhoneNumber, poneNumber);
		 clearAndType(eleEmail, email);
		 click(eleSubmit);
		 storeExtractedText(eleAccountId, "AcoountId");
		 
//		 Boolean check=checkExistence(eleErrorMsg);
//		 if(check) {
//			 System.out.println("Account Name already exists");
//		 }
//		 else {
//			 storeExtractedText(eleAccountId, "AcoountId");
//		 }
		 
		 return this;
	 }
	
	 
}
