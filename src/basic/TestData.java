package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestData {
	
	//
	static String  path = "D:\\NOAH\\testdata\\testdata.xlsx";
	static HashMap<String, String> testdata = new HashMap<String, String>();

	
	@SuppressWarnings("resource")
	public static HashMap<String, String> getTestData(String testName)
	{
		// Read data from Excel using Apache POI
		FileInputStream driverExcel = null;
		XSSFWorkbook workbook = null;
		try {
			driverExcel = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(driverExcel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		XSSFSheet sheet = workbook.getSheet(testName);
		Iterator<Row> rowIterator = sheet.iterator();
		
		// Selenium and misc parameters passed through TestNG xml		
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			testdata.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		}
		
		return testdata;
		
	}

	
	@Test
	public void searchTest()
	{
		getTestData("ËÑË÷");
		
		Set<Entry<String, String>> data = testdata.entrySet();
		for(Entry<String, String> d: data)
		{
			System.out.println(d.getKey());
			System.out.println(d.getValue());
		}
		
	}
}
