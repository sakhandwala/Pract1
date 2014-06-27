package Pract1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelValidation {

	public static void main(String args[])
	{
		try {
			FileInputStream fis = new FileInputStream(new File("C:/Users/skhandwala/Desktop/work.xlsx"));
			
			//FileOutputStream fos = new FileOutputStream(new File("C:/Users/skhandwala/Desktop/cleaned.xlsx"));
			
			  XSSFWorkbook workbook = new XSSFWorkbook(fis);
			  
			 // XSSFWorkbook workbook2 = new XSSFWorkbook();
			  
			  XSSFSheet sheet = workbook.getSheetAt(0);
			  
			 // XSSFSheet sheet2 = workbook.createSheet("CleanedData");
			  
			 // Map<String, Object[]> data = new TreeMap<String, Object[]>();
			  
			  Iterator<Row> rowIterator = sheet.iterator();
			  while(rowIterator.hasNext())
			  {
				  Row row = rowIterator.next();
				  
				  Iterator<Cell> cellIterator = row.cellIterator();
				  
				  while(cellIterator.hasNext())
				  {
					  
					  Cell cell = cellIterator.next();
				     
					  {
					  
					  switch(cell.getCellType())
					  {
					  case Cell.CELL_TYPE_BOOLEAN:
					      System.out.print(cell.getBooleanCellValue() + "\t");
					  break;
					  case Cell.CELL_TYPE_NUMERIC:
						  System.out.print(cell.getNumericCellValue() + "\t");
					  break;	  
					  case Cell.CELL_TYPE_STRING:
						  System.out.print(cell.getStringCellValue() + "\t");
				      break;
					  }
					  }
				  }
				  
				  System.out.println("");
			  }
			  
			  fis.close();
			  
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
