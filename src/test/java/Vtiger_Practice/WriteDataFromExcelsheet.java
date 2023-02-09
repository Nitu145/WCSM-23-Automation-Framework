package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcelsheet {
	public static void main(String[] args) throws IOException {
		
	
	//Step 1: Load or specify the xcel file path into File input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ExcelTestData.xlsx");
	// Step 2: Open the Exel or Create the workBook
		Workbook wb = WorkbookFactory.create(fis);
	// Step 3: Specify the sheet name or Navigate to the sheet
		Sheet sh = wb.getSheet("Products");
	// Step 4: Specify the row number or navigate to the required row
		Row rh = sh.createRow(0);
	// Step 5: Specify the cell number or Navigate to the required cell
		Cell ch = rh.createCell(2);
	// Step 6: write the data
		ch.setCellValue("Qsoider");
	// Step 7: write into the using File output stream
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ExcelTestData.xlsx");
	// In workbook we have a method write and provide argument i.e. fos
		wb.write(fos);
		System.out.println("data is added");
		
	}
}
