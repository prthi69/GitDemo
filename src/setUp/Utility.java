package setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility extends Main{
	
	@SuppressWarnings("resource")
	public static void readDataFRomExcel(String testCaseName) throws IOException {
		// get the file from specified path
		System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir")+"//testData//TestData.xlsx";
			File file1=new File(path);
			
			FileInputStream excel=new FileInputStream(file1);
			
			// Apachi poi Library to manupulate Excel
			Workbook workbook1=new XSSFWorkbook(excel);
			// Opemimg the "TestCase" Sheet
			Sheet sheet1=workbook1.getSheet("TestCase");
			
			int numnerOfRows = sheet1.getLastRowNum();
			System.out.println("Number of rows in sheet is: " + numnerOfRows);
//			Iterating number of rows
			for(int i=0; i<=numnerOfRows; i++) {
				Row row=sheet1.getRow(i);
				int headerCols=row.getLastCellNum();
				for(int j=0;j<headerCols;j++) {
					String headerName=sheet1.getRow(i).getCell(j).getStringCellValue();
					if(headerName.equalsIgnoreCase(testCaseName)) {
						String PageTitle = sheet1.getRow(i).getCell(1).getStringCellValue();
						String Username = sheet1.getRow(i).getCell(2).getStringCellValue();
						String pwd = sheet1.getRow(i).getCell(2).getStringCellValue();
						System.out.println("Test case is: " + headerName);
						System.out.println("PageTitle is : " + PageTitle);
						System.out.println("Username is : " + Username);
						System.out.println("Password is: " + pwd);
						System.setProperty("PageTitle", PageTitle);
						System.setProperty("userName", Username);
						System.setProperty("Password", pwd);
						}
					} 
				}
		}
}
