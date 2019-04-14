package com.PacificPower.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.PacificPower.generic.Pojo;

public class ExcelHelper {

	Pojo objPojo;
	FileInputStream fileInputStream;
	Workbook book;
	HashMap<String, String> dataPool = new HashMap<String, String>();
	HashMap<String, String> rowData = new HashMap<String, String>();
	String excelFileName = "";
	String rmidNo;
	ScreenshotHelper screenshotHelper = new ScreenshotHelper();

	public ExcelHelper(Pojo objPojo){
		this.objPojo= objPojo;
	}
	public void loadExcelFile(String excelFileName) {
		this.excelFileName = excelFileName;
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "//test-Data" + "//" + excelFileName + ".xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("creating workbook");
			book = WorkbookFactory.create(fileInputStream);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTotalRowsCount() {
		this.loadExcelFile(excelFileName);
		return book.getSheet("Sheet1").getLastRowNum();
	}

	public HashMap<String, String> loadTestData(String rmidNo) {
		this.loadExcelFile(excelFileName);
		int rows = this.getTotalRowsCount();
		for (int i = 0; i < rows; i++) {

			String obtainedRMIDNo = book.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			if (obtainedRMIDNo.equals(rmidNo)) {
				Iterator<Cell> cellCountKeys = book.getSheet("Sheet1").getRow(i).cellIterator();
				for (int j = 0; j < book.getSheet("Sheet1").getRow(i).getLastCellNum(); j++) {

					int cellNo = 0;
					while (cellCountKeys.hasNext() && cellNo != book.getSheet("Sheet1").getRow(i).getLastCellNum()) {
						rowData.put(book.getSheet("Sheet1").getRow(i - 1).getCell(cellNo).getStringCellValue(),
								book.getSheet("Sheet1").getRow(i).getCell(cellNo).getStringCellValue());
						cellNo++;

					}
				}
			}

		}
		objPojo.setRowData(rowData);
		return this.rowData = rowData;

	}

	public String dpString(String keyName) {
		System.out.println(objPojo);
		System.out.println("rowData inside dpString"+objPojo.getRowData());
		return objPojo.getRowData().get(keyName);
		
	}

	public void setExcelName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	
	

}
