/**
 * 
 */
package com.excel.excelGenerator.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author DESEKAR
 *
 */
public class ExcelSheet {
	
	public String sheetName;
	
	public List<Map<String, String>> header;
	
	public List<List<String>> rows;

	/**
	 * @return the header
	 */
	public List<Map<String, String>> getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(List<Map<String, String>> header) {
		this.header = header;
	}

	/**
	 * @return the rows
	 */
	public List<List<String>> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}

	/**
	 * @return the sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 * @param sheetName the sheetName to set
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
}
