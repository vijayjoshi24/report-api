/**
 * 
 */
package com.excel.excelGenerator.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.excelGenerator.pojo.ExcelFile;
import com.excel.excelGenerator.pojo.ExcelSheet;

/**
 * @author DESEKAR
 *
 */
public class ExcelUtil {

	public static byte[] generateExcel(ExcelFile excelJson) {
		 //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        /**Start of styles*/
        XSSFCellStyle style = workbook.createCellStyle();
        byte[] rgb = new byte[3];
        rgb[0] = (byte) 242; // red
        rgb[1] = (byte) 220; // green
        rgb[2] = (byte) 219; // blue
        style.setFillBackgroundColor(new XSSFColor(java.awt.Color.red));
        /**End of styles*/
        /**
         *	Step 1: Iterating through excel Sheets.
         *	Step 2: Reading Header and writing 
         *	Step 3: Reading rows and writing 
         * 
         */
        ExcelSheet excelSheet = new ExcelSheet();
        if(null != excelJson.getExcelSheets() && excelJson.getExcelSheets().size() > 0) {
        	for (int sheetNo = 0; sheetNo < excelJson.getExcelSheets().size(); sheetNo++) {
        		
        		/** Step 1: Creating Sheet and assigning name from request*/
        		String sheetName = "Book " + sheetNo;
        		if(null != excelJson.getExcelSheets().get(sheetNo) && null != excelJson.getExcelSheets().get(sheetNo).getSheetName() && excelJson.getExcelSheets().get(sheetNo).getSheetName().length() > 0) {
        			sheetName = excelJson.getExcelSheets().get(sheetNo).getSheetName();
        		}
        		XSSFSheet xssfWorkSheet = workbook.createSheet(sheetName);
        		excelSheet = excelJson.getExcelSheets().get(sheetNo);        		
        		/**End of Sheet creation and name assignment*/
        		
        		XSSFCellStyle headerStyle = workbook.createCellStyle();
        		XSSFFont headerFont = workbook.createFont();
        	    headerFont.setFontHeightInPoints((short) 14);
        	    headerFont.setBold(true);
        	    headerFont.setColor(new XSSFColor(java.awt.Color.BLACK));
        	    headerFont.setFamily(FontFamily.ROMAN);
        	    headerStyle.setBorderBottom(BorderStyle.THIN);
        	    headerStyle.setBorderLeft(BorderStyle.THIN);
        	    headerStyle.setBorderRight(BorderStyle.THIN);
        	    headerStyle.setBorderTop(BorderStyle.THIN);
        	    headerStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.LIGHT_GRAY));
        	    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        	    headerStyle.setFont(headerFont);
        	      
        		/**Step 2: Creating Headers**/
        		Row header = xssfWorkSheet.createRow(0);
        		header.setRowStyle(style);
        		if(null != excelSheet.getHeader() && excelSheet.getHeader().size() > 0) {
        			for(int hrCol = 0; hrCol < excelSheet.getHeader().size(); hrCol ++) {
        				Map<String, String> headerColumns = excelSheet.getHeader().get(hrCol);
        				for (Map.Entry<String, String> headerColumn : headerColumns.entrySet()) {
        					System.out.println(headerColumn.getKey() + "    ------     "+headerColumn.getValue());
        				}
        				Cell cell = header.createCell(hrCol);
        				cell.setCellValue(headerColumns.get("name"));
              	      	cell.setCellStyle(headerStyle);
        			}
        		}
        		/**End of header creation*/
        		
        		/**Start of data row creation*/
        		if(null != excelSheet.getRows() && excelSheet.getRows().size() > 0) {
        			Row dataDetail = null;
        			for(int dataRows = 0; dataRows < excelSheet.getRows().size(); dataRows++) {
        				if(null != excelSheet.getRows().get(dataRows)) {
        					dataDetail = xssfWorkSheet.createRow(xssfWorkSheet.getLastRowNum() + 1);
        					for(int dataRow = 0; dataRow < excelSheet.getRows().get(dataRows).size(); dataRow ++) {
        						dataDetail.createCell(dataRow).setCellValue(excelSheet.getRows().get(dataRows).get(dataRow));
            				}        					
        				}
        			}
        			
        		}
        		/**End of data row creation*/	
        		
            }        	
        }
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            bos.close();
            workbook.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        byte[] bytes = bos.toByteArray();
        return bytes;
	}

	private XSSFCellStyle getXSSFCellStyle(XSSFWorkbook workbook, BorderStyle borderStyle, FontFamily fontFamily, java.awt.Color fontColor, java.awt.Color foreGroundColor, FillPatternType patternType) {
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		XSSFFont headerFont = workbook.createFont();
	    headerFont.setFontHeightInPoints((short) 14);
	    headerFont.setBold(true);
	    headerFont.setColor(new XSSFColor(fontColor));
	    headerFont.setFamily(fontFamily);
	    headerStyle.setBorderBottom(borderStyle);
	    headerStyle.setBorderLeft(borderStyle);
	    headerStyle.setBorderRight(borderStyle);
	    headerStyle.setBorderTop(borderStyle);
	    headerStyle.setFillForegroundColor(new XSSFColor(foreGroundColor));
	    headerStyle.setFillPattern(patternType);
	    headerStyle.setFont(headerFont);
		return headerStyle;
	}
}
