package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class loginPage extends ProjectSpecificMethods{

	public loginPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	
	public WelcomePage loginUser(String userName,String passWord) {
		
		clearAndType(eleUserName, userName);
		clearAndType(elePassword, passWord);
		click(eleLogin);
		return new WelcomePage(driver, node, test);
	}
	 
}
