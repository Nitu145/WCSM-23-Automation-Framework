package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		//step 1: read file in java readable
		//Step 1: read the file in java readable format using file input stream
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				
				//Step 2: Create object of Properties Class from Java.util
				Properties pObj = new Properties();
				
				//Step 3: load the file input stream
			    pObj.load(fis);
				
				//Step 4: provide the Key and read the value
			    String URL = pObj.getProperty("url");
			    System.out.println(URL);
			    
			    String BROWSER = pObj.getProperty("browser");
			    System.out.println(BROWSER);
		}
			
	}


