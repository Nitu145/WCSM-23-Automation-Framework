package vTiger.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
	 // rule 1: create a pom class for every web page
    // rule 2: Class name should be the title of page and ending with page
{
//Rule 3: Identify the webelements using @FindBY, @FindAll, @FindBys annotation
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//rule 4:  Create a constructor to initialise the variables/web elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		
	///Rule 5: Provide getters to access the web elements
		public WebElement getUserNameEdt() {
			return UserNameEdt;
		}
        public WebElement getpasswordEdt() {
        	return passwordEdt;
        	
        }		
		public WebElement getsubmitBtn() {
			return submitBtn;
		}
		////Business Library - Generic Methods - for this application
		/**
		 * This method will Login to application
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void LoginToApp(String USERNAME,String PASSWORD) {
			UserNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			submitBtn.click();
		}

		public void loginToApp(String uSERNAME, String pASSWORD) {
			// TODO Auto-generated method stub
			
		}  
	
}
		
	
		
	