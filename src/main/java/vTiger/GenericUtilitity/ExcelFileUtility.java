package vTiger.GenericUtilitity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileCacheImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/**
	 * This method will read data from excel sheet and return the value
	 * @param Sheet
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String name,int rownum,int cellnum) throws IOException
	{
		FileInputStream fil=new FileInputStream(IConstantsUtility.ExcelFilepath);
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sh = wb.getSheet(name);
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(cellnum);
		String value = c.getStringCellValue();
		return value;
		

	}
	/**
	 * This method will provide the row count when the specific sheet is provided
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
		
	}
	
	/**
	 * This method will write data into excelSheet
	 * @param sheet
	 * @param rowNo
	 * @param celNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int rowNo, int celNo, String Value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.createCell(celNo);
		ce.setCellValue(Value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilepath);
		wb.write(fos);
		wb.close();
		
	}
	
	public Object[][] readmultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
	 FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilepath);
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetName);
	 int lastRow = sh.getLastRowNum();
	 int lastCell = sh.getRow(0).getLastCellNum();
	 
	 Object[][] data=new Object[lastRow][lastCell];
	 for(int i=0;i<lastRow;i++)
	 {
		 for(int j=0;j<lastCell;j++)
		 {
			 data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
		 }
	 }
	 return data;
	 }
}
