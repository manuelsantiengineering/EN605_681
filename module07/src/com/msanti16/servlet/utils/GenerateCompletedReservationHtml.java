package com.msanti16.servlet.utils;

public class GenerateCompletedReservationHtml extends GenerateHtml {
	private String title;
	private String username;
	private String startDate;
	private String tourName;
	private String duration;
	private String createdAt;
	private String totalCost;
	
	public GenerateCompletedReservationHtml(
			String title, String username, String startDate, 
			String tourName, String duration, String createdAt, 
			String totalCost) {
		super();
		this.title = title;
		this.username = username;
		this.startDate = startDate;
		this.tourName = tourName;
		this.duration = duration;
		this.createdAt = createdAt;
		this.totalCost = totalCost;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getTourName() {
		return tourName;
	}
	
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public void generateHtml() {				
		String extraHead = new String();
		String extraBody = new String();
		extraHead += this.title;
		extraBody = 
			"<nav class=\"navbar navbar-default\">\r\n" + 
			"    <div class=\"container-fluid\">\r\n" + 
			"      <div class=\"navbar-header\">\r\n" + 
			"        <a class=\"navbar-brand\" href=\"./index.html\">Beartooth Hiking Company</a>\r\n" + 
			"      </div>\r\n" + 
			"      <ul class=\"nav navbar-nav\">\r\n" + 
			"        <li class=\"active\"><a href=\"./index.html\">Home</a></li>\r\n" + 
			"        <li><a href=\"./tours.html\">Tours</a></li>\r\n" + 
			"      </ul>\r\n" + 
			"    </div>\r\n" + 
			"  </nav>"
		;
		extraBody += 
			"<div class=\"container\">\r\n" + 
			"    <div class=\"row\"> \r\n" + 
			"      <div class=\"alert alert-danger\">\r\n" + 
			"        <strong>Error: </strong>" + this.errorMessage + "\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </div>"
		;
		
		this.buildHtml(extraHead, extraBody);
	}
	
}
