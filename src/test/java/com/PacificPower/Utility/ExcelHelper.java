package com.PacificPower.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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
	HashMap<String, String> rowData = new HashMap<String, String>();
	String excelFileName = "";
	String rmidNo;
	ScreenshotHelper screenshotHelper = new ScreenshotHelper();
	int rowCount;

	public ExcelHelper(Pojo objPojo){
		this.objPojo= objPojo;
	}
	
	public Workbook loadExcelFile(String excelFileName) {
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
		this.rowCount= book.getSheet("Sheet1").getLastRowNum();
		return book;
	}



	public HashMap<String, String> loadTestData(String rmidNo) {
		for (int i = 0; i < this.rowCount; i++) {
			String obtainedRMIDNo = book.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			if (obtainedRMIDNo.equals(rmidNo)) {
				objPojo.setCurrentRMIDRowNo(i+1);
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
		Iterator<Entry<String, String>> itr = rowData.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
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
