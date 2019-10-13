package com.msanti16.servlet.utils;

public class GenerateErrorHtml extends GenerateHtml {
	private String title;
	private String errorMessage;	

	public GenerateErrorHtml(String title, String errorMessage) {
		super();
		this.title = title;
		this.errorMessage = errorMessage;		
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
