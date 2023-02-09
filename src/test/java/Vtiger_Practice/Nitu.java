package Vtiger_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Nitu {
	public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("Nitu Patle");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
    if( contactHeader.contains("Nitu Patle"))
    {
    	System.out.println(contactHeader);
		System.out.println("PASS");
	}
    else
    {
    	System.out.println("Fail");
    }
    WebElement Element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    Actions act = new Actions(driver);
    act.moveToElement(Element).perform();
    driver.findElement(By.linkText("Sign Out")).click();
	}    

}
