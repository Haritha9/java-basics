package in.srssprojects.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {
	/**
	 * Excel related operations
	 */

	private static Workbook book;
	private static Sheet sh;
	private static WritableWorkbook wbook;
	private static WritableSheet wsh;

	/**
	 * to set an excel file to read the data
	 * 
	 * @param fileName
	 * @param sheetName
	 */
	public void setExcelConnection(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * will read the data from a cell and stores that data in a string
	 * 
	 * @param int
	 *            rownumber
	 * @param int
	 *            columnNumber
	 * @return String
	 */
	public String readData(int rnum, int cnum) {
		return sh.getCell(cnum, rnum).getContents();
	}

	/**
	 * create an excel connection to read and write the data
	 * 
	 * @param String inputExcel file
	 * @param String outputExcel file
	 * @param String sheetName
	 */
	public void setOutputExcelConnection(String iFileName, String oFileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(iFileName);
			book = Workbook.getWorkbook(fis);
			FileOutputStream fos = new FileOutputStream(oFileName);
			wbook = Workbook.createWorkbook(fos, book);
			wsh = wbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * count the no of rows
	 * 
	 * @return int
	 */
	public int rowCount() {
		return sh.getRows();
	}

	/**
	 * count no of columns
	 * 
	 * @return int
	 */
	public int columnCount() {
		return sh.getColumns();
	}

	/**
	 * write data into excel cell
	 * 
	 * @param rowNum
	 * @param columnNum
	 * @param data
	 */
	public void writeData(int rnum, int cnum, String data){
		try {
			wsh.addCell(new Label(cnum, rnum, data));
		} catch (Exception e) {

		}
	}
	
	/**
	 * save the workbook
	 */
	public void saveWorkBook(){
		try {
			wbook.write();
			wbook.close();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
