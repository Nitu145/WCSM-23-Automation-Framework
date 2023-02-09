package Vtiger_Practice;

import java.io.IOException;

import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.javaUtility;

public class GenericUtilityMethodsPractice {
	public static void main(String[] args) throws IOException
	{
		javaUtility jUtil = new javaUtility();
		int number = jUtil.getRandomNumber();
		System.out.println(number);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
		String d = jUtil.getSystemDateInFormate();
		System.out.println(d);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("browser");
		System.out.println(value);
		System.out.println(pUtil.readDataFromPropertyFile("url"));
	}

}

