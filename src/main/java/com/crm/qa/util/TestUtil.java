package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long PAGE_LOAD_TIMEOUT = 60;
public static long IMPLICIT_WAIT = 60;
private static XSSFWorkbook wb;
private static XSSFSheet sheet;




public void switchToFrame(String frameName)
{
	driver.switchTo().frame(frameName);
}



public static Object[][] getTestData(String sheetName)
{
	
	
	
	try{
		File src = new File("G:\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		
		}catch(Exception e){
			System.out.println("EXCEPTION............");
			System.out.println(e.getMessage());
		}
	
	int rows = wb.getSheet(sheetName).getLastRowNum();
	System.out.println("NUmber of rows: "+rows);
	
	
	Object[][] credentials = new Object[rows][4];
	
	for(int i=1;i<=rows;i++)
		for(int j=0;j<4;j++)
			credentials[i-1][j]=getData(sheetName,i, j);
		

	return credentials;
	
}


private static String getData(String sheetName,int row,int column)
{
	
	sheet=wb.getSheet(sheetName);
	String data = sheet.getRow(row).getCell(column).getStringCellValue();
	return data;
}

public static void takeScreenshotAtEndOfTest() throws IOException
{
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("G:\\workspace\\FreeCRMTest\\Screenshots\\"+System.currentTimeMillis()+".png");
    FileUtils.copyFile(SrcFile, DestFile);
}

}
