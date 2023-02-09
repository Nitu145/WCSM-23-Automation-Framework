package vtigerOrganizationTestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOraganizationWithDDtTest {
	@Test
	 public void CreateorgwithTest() throws IOException
	 {
		Random ran = new Random();
		int randoom = ran.nextInt(1000);
		// Step 1: Read all the data/read the data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browser = pobj.getProperty("browser");
		String url=pobj.getProperty("url");
		String username = pobj.getProperty("username");
		Object password = pobj.get("password");
		/*Read the data from excel sheet*/
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\ExcelTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String orgname = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+ randoom;		
		WebDriver driver=null;
		// Step 2: Launch the browser
		if (browser.equalsIgnoreCase("Chrome"))
          {
			driver= new ChromeDriver();
		 }
          else if( browser.equalsIgnoreCase("firefox")) {
        	  driver=new FirefoxDriver();
          }
          else
          {
        	  System.out.println("fail");
          }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(url);
		// Step 3: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// step 4: click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		// Step 5: Click on create organization lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		// Step 6: create organization with mandatory  details
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step 8: validate
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(orgHeader.contains(orgname))
		{
			System.out.println(orgHeader+" pass");
		}
		else {
			System.out.println(orgHeader+" Fail");
		}
		// Step 8: log out application
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
