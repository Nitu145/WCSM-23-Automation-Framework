package vtigerOrganizationTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilitity.ExcelFileUtility;
import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.WebDriverUtility;
import vTiger.GenericUtilitity.javaUtility;

public class CreateOrganizationWithIndustryWithDDtTest {
	@Test
	public void creatORGWithIndustryTest() throws IOException
	{
		// Step 1:create the object of necessary utility
          javaUtility jUtil = new javaUtility();
          WebDriverUtility wUtil= new WebDriverUtility();
          PropertyFileUtility pUtil = new PropertyFileUtility();
         ExcelFileUtility eUtil = new ExcelFileUtility();
         
         //Step 2: read the data from propertyFile
           String Browser = pUtil.readDataFromPropertyFile("browser");
           String URl = pUtil.readDataFromPropertyFile("url");
           String USERNAME = pUtil.readDataFromPropertyFile("username");
           String Password = pUtil.readDataFromPropertyFile("password");
           
           String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2)+jUtil.getRandomNumber();
           String INDUSTRY = eUtil.readDataFromExcelFile("Organizations", 4, 3);
           
          // Step 3: Login to the Browser
           WebDriver driver=null;
           if(Browser.equalsIgnoreCase("chrome"))
           {
        	   WebDriverManager.chromedriver().setup();
        	   driver=new ChromeDriver();
        	  
           }
           else if(Browser.equalsIgnoreCase("Firefox"))
           {
        	   WebDriverManager.chromedriver().setup();
        	  driver=new FirefoxDriver();
           }
           else {
        	   System.out.println("Invalid browser name");
           }
          wUtil.maximizeWindow(driver);
          wUtil.waitForPageLoad(driver);
          driver.get(URl);
           // step 4:Login the application
           driver.findElement(By.name("user_name")).sendKeys(USERNAME);
   		driver.findElement(By.name("user_password")).sendKeys(Password);
   		driver.findElement(By.id("submitButton")).click();
   		
   		//Step 5: Navigate to Organizations Link
   		driver.findElement(By.linkText("Organizations")).click();
   		
   		//Step 6: Click on Organizations look up image
   		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
   		
   		//Step 7: Create new organization and save
   		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
   		//Step 8: select "helthcare" in industry dropdown
   		WebElement element = driver.findElement(By.name("industry"));
   		wUtil.handleDropDown(element, INDUSTRY);
		//Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step 8: validate
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader+" pass");
		}
		else {
			System.out.println(orgHeader+" Fail");
		}
		// Step 8: log out application
		WebElement Element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, Element);
     	driver.findElement(By.linkText("Sign Out")).click();
		
}
}
