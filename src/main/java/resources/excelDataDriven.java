package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelDataDriven {

	@Test
	public ArrayList<String> getExcelData(String testCaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/ExcelDataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int size = workbook.getNumberOfSheets();
		for(int i=0; i<size; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Ecommerce"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row rows=row.next();
				Iterator<Cell> cell = rows.cellIterator();
				int k=0;
				int column=0;
				while(cell.hasNext())
				{
					Cell cells=cell.next();
					if(cells.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column = k;
					}
					
					k++;
				}
				
				while(row.hasNext())
				{
					Row rowss=row.next();
					if(rowss.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						Iterator<Cell>cel=rowss.cellIterator();
						while(cel.hasNext())
						{
							Cell ce = cel.next();
							if(ce.getCellTypeEnum()==CellType.STRING)
							{
								a.add(ce.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(ce.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
	return a;
	}
	
	
}
