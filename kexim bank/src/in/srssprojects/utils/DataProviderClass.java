package in.srssprojects.utils;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class DataProviderClass {
	
	static Excel excel = new Excel();
	public static String[][] getExcelContents(String fileName, String sheetName) {
		String[][] sheetData = null;
		try {
			excel.setExcelConnection(fileName, sheetName);
			int nor = excel.rowCount();
			int noc = excel.columnCount();
			sheetData = new String[nor - 1][noc];
			for (int r = 1; r < nor; r++) {
				for (int c = 0; c < noc; c++) {
					sheetData[r - 1][c] = excel.readData(r, c);
				}
			}
		} catch (Exception e) {

		}
		return sheetData;
	}

}
