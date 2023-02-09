package Vtiger_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider = "accessories")
	public void addProductToCartTest(String phone,int price,String model) 
	{
		System.out.println(phone+" "+price+" "+model);
	}
	
	@DataProvider(name = "accessories")
	public Object[][] getdata() 
	{
		Object[][] data=new Object[2][3];
		
		data[0][0] = "sumsung";
		data[0][1] = 1200;
		data[0][2] = "A18";
		
		data[1][0] = "sumsung";
		data[1][1] = 1500;
		data[1][2] = "s13";
		
		return data;
		
		
	}

}
