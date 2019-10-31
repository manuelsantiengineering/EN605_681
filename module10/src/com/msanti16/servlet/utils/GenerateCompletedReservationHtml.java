package com.msanti16.servlet.utils;

public class GenerateCompletedReservationHtml extends GenerateHtml {
	private String title;
	private String username;
	private String startDate;
	private String tourName;
	private String duration;
	private String partySize;
	private String createdAt;
	private String totalCost;
	
	public GenerateCompletedReservationHtml(
			String title, String username, String startDate, 
			String tourName, String duration, String partySize,
			String createdAt, String totalCost) {
		super();
		this.title = title;
		this.username = username;
		this.startDate = startDate;
		this.tourName = tourName;
		this.duration = duration;
		this.createdAt = createdAt;
		this.totalCost = totalCost;
		this.partySize = partySize;
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

	public String getPartySize() {
		return partySize;
	}

	public void setPartySize(String partySize) {
		this.partySize = partySize;
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
				"        <li><a href=\"./index.html\">Home</a></li>\r\n" + 
				"        <li><a href=\"./tours.html\">Tours</a></li>\r\n" + 
				"        <li class=\"active\"><a href=\"./tours.html\">Reservation</a></li>\r\n" + 
				"      </ul>\r\n" + 
				"    </div>\r\n" + 
				"  </nav>"
		;
		extraBody += 
			"<div class=\"container\">\r\n" + 
			"    <div class=\"row\">       \r\n" + 
			"      <div class=\"col-sm-12\">\r\n" + 
			"        <h1>Reservation Completed</h1>\r\n" + 
			"        <p>Get prepare for your next adventure!</p>\r\n" + 
			"        <button type=\"button\" class=\"btn btn-success btn-block\" data-toggle=\"collapse\" " + 
			"data-target=\"#reservation\">" + this.tourName +" Reservation</button>\r\n" + 
			"        <div id=\"reservation\" class=\"collapse\">\r\n" + 
			"          <table class=\"table table-hover\">\r\n" + 
			"            <tbody>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Reserved on: </td>\r\n" + 
			"                <td>"+ this.createdAt +"</td>\r\n" + 
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Name: </td>\r\n" + 
			"                <td>"+ this.username +"</td>\r\n" + 
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Party size: </td>\r\n" + 
			"                <td>"+ this.partySize +"</td>\r\n" +  
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Tour: </td>\r\n" + 
			"                <td>"+ this.tourName +"</td>\r\n" +  
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Start Date: </td>\r\n" + 
			"                <td>"+ this.startDate +"</td>\r\n" +  
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Duration: </td>\r\n" + 
			"                <td>"+ this.duration +"</td>\r\n" + 
			"              </tr>\r\n" + 
			"              <tr>\r\n" + 
			"                <td>Total Cost: </td>\r\n" + 
			"                <td>"+ this.totalCost +"</td>\r\n" + 
			"              </tr>\r\n" + 
			"            </tbody>\r\n" + 
			"          </table>\r\n" + 
			"            Please make sure to fill out and send the waiver before the tour date. \r\n" + 
			"      	</div>\r\n" + 
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </div>"
		;
		
		this.buildHtml(extraHead, extraBody);
	}
	
}
