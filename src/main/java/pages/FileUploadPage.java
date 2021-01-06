package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class FileUploadPage extends ProjectSpecificMethods{
	
	public FileUploadPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test; 
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="dropzoneInput-label")
	private  WebElement eleChooseFileBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()=\"Convert Now!\"]")
	private WebElement eleConvertBtn;
	
	
	public FileUploadPage clickChooseFile(String webSite,String fileName) throws InterruptedException {
		driver.navigate().to(webSite);
		click(eleChooseFileBtn);
		autoITExecutor(fileName);
		checkExistence(eleConvertBtn);
		click(eleConvertBtn);
		Thread.sleep(5000);
		return this;
	}

}
