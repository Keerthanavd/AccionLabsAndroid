package android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelConnect {

	@DataProvider(name="Login")
	public static Object[][] readExcel() throws IOException {
		
		//specify the excel file containing test data
		File src=new File("E:\\DataDrivenTest\\testdata.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook getSheetAt(0) gets the first sheet
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum()+1;
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		int j;
		for(int i=0;i<rowCount;i++) {
			for(j=0;j<colCount;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
