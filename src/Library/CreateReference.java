package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateReference {

	public static Map<String, String> t1 = new HashMap<String, String>();
	public static String strArray[] = new String[2];

	public static void createReference() throws IOException {
		// TODO Auto-generated method stub
	
		//String path=System.getProperty("user.dir")+"\\src\\DataLayer\\Data1.xls";
		String path=System.getProperty("user.dir")+"\\Data.xlsx";
		
		FileInputStream fs = new FileInputStream(path);
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Profile");
		
		int lastRow = sheet.getLastRowNum();
		for(int i=1;i<=lastRow;i++)
		{
			Row row = sheet.getRow(i);
			Cell valueCell = row.getCell(1);
			Cell keyCell = row.getCell(0);
			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();
			t1.put(key, value);
		}
		workbook.close();		
	}
	
	
	public static void outPut(String[][] text) throws IOException {
		// TODO Auto-generated method stub		
		String path=System.getProperty("user.dir")+"\\Result.xlsx";
		
		FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Sl.no");
        header.createCell(1).setCellValue("Functionality");
        header.createCell(2).setCellValue("Result Parameters");
        
        Object[][] resultData = text;

        int rowCount = sheet.getLastRowNum();

        for (Object[] aResult : resultData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
            cell.setCellValue(rowCount);
             
            for (Object field : aResult) {
                cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }
        
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(new File(path));
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();  
	}

}
