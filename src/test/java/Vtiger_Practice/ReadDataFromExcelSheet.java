package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: Load the file into file Input stream- Java readable formate
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ExcelTestData.xlsx");
		//step 2: Creat a workBook
		Workbook wb = WorkbookFactory.create(fis);
		// Step 3: Get hold of sheet-Navigate to the required sheet
		Sheet sh = wb.getSheet("Organizations");
		// Step 4: Navigate to the required row
		Row rw = sh.getRow(4);
		//Step 5: Navigate to the required cell
		Cell c = rw.getCell(2);
		Cell cel = rw.getCell(3);
		// Step 6: Capture the data present inside the cell
		String value = c.getStringCellValue();
		
		System.out.println(value);
		System.out.println(cel.getStringCellValue());
		
		
	}

}
