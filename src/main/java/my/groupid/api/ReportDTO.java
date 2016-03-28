package my.groupid.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Report" )
public class ReportDTO {
	
	private String report_id;	
	private String category_id;
	private String report_Name;
	
	
	@ApiModelProperty(value = "Report ID")
	@JsonProperty("reportId")
	public String getReportId() {
		return report_id;
	}
	public void setReportId(String report_id) {
		this.report_id = report_id;
	}
	
	@ApiModelProperty(value = "Category ID")
	@JsonProperty("categoryId")
	public String getCategoryId() {
		return category_id;
	}
	public void setCategoryId(String category_id) {
		this.category_id = category_id;
	}
	
	@ApiModelProperty(value = "Report Name")
	@JsonProperty("reportName")
	public String getReportName() {
		return report_Name;
	}
	public void setReportName(String report_Name) {
		this.report_Name = report_Name;
	}
	

}
