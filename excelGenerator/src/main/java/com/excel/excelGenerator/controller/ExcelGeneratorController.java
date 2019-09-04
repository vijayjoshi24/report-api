/**
 * 
 */
package com.excel.excelGenerator.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.excel.excelGenerator.pojo.ExcelFile;
import com.excel.excelGenerator.util.ExcelUtil;

/**
 * @author DESEKAR
 *
 */
@RestController
@RequestMapping("/excelGenerator")
public class ExcelGeneratorController {

	@RequestMapping(method = RequestMethod.GET, value="/testService", headers="Accept=*/*")
	public @ResponseBody String testService() {
		return "Successfully Created";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/excelGen", headers="Accept=*/*")
	public @ResponseBody void testService(@RequestBody ExcelFile excelFile, HttpServletResponse response) {
		byte[] output =  ExcelUtil.generateExcel(excelFile);
		OutputStream out = null;
		try {
		    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		    out = response.getOutputStream();
		    out.write(output);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
