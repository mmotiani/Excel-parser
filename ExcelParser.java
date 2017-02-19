import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ExcelParser{
	
	public static void main(String args[]) throws IOException{
		FileInputStream fis = new FileInputStream(new File("SampleXLSFile_19kb.xls"));
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet hs = wb.getSheetAt(0);
		
		FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator();
		
		for(Row row : hs)
		{
			for(Cell cell : row)
			{
				switch(fe.evaluateInCell(cell).getCellType())
				{
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue()+"\t\t\t\t\t\t\t\t\t\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue()+"\t\t\t\t\t\t\t\t\t\t");
						break;
				}
			}
			System.out.println();
		}
		
	}
}
