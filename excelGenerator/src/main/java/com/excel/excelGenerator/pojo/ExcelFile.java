/**
 * 
 */
package com.excel.excelGenerator.pojo;

import java.util.List;

/**
 * @author DESEKAR
 *
 */
public class ExcelFile {

	public String appId;
	public String reportType;
	public String reportName;
	public String nameWithDate;
	public String nameWithDateTime;
	public String objectType;
	public String httpType;
	public String httpRequest;
	public String httpSecurityCredential;
	public List<ExcelSheet> excelSheets;
	
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the reportType
	 */
	public String getReportType() {
		return reportType;
	}
	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	/**
	 * @return the nameWithDate
	 */
	public String getNameWithDate() {
		return nameWithDate;
	}
	/**
	 * @param nameWithDate the nameWithDate to set
	 */
	public void setNameWithDate(String nameWithDate) {
		this.nameWithDate = nameWithDate;
	}
	/**
	 * @return the nameWithDateTime
	 */
	public String getNameWithDateTime() {
		return nameWithDateTime;
	}
	/**
	 * @param nameWithDateTime the nameWithDateTime to set
	 */
	public void setNameWithDateTime(String nameWithDateTime) {
		this.nameWithDateTime = nameWithDateTime;
	}
	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * @return the httpType
	 */
	public String getHttpType() {
		return httpType;
	}
	/**
	 * @param httpType the httpType to set
	 */
	public void setHttpType(String httpType) {
		this.httpType = httpType;
	}
	/**
	 * @return the httpRequest
	 */
	public String getHttpRequest() {
		return httpRequest;
	}
	/**
	 * @param httpRequest the httpRequest to set
	 */
	public void setHttpRequest(String httpRequest) {
		this.httpRequest = httpRequest;
	}
	/**
	 * @return the httpSecurityCredential
	 */
	public String getHttpSecurityCredential() {
		return httpSecurityCredential;
	}
	/**
	 * @param httpSecurityCredential the httpSecurityCredential to set
	 */
	public void setHttpSecurityCredential(String httpSecurityCredential) {
		this.httpSecurityCredential = httpSecurityCredential;
	}
	/**
	 * @return the excelSheets
	 */
	public List<ExcelSheet> getExcelSheets() {
		return excelSheets;
	}
	/**
	 * @param excelSheets the excelSheets to set
	 */
	public void setExcelSheets(List<ExcelSheet> excelSheets) {
		this.excelSheets = excelSheets;
	}
}
