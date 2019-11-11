package com.msanti16.servlet.utils;

import java.util.ArrayList;

import com.msanti16.servlet.domain.Reservation;

public class GenerateFoundReservationHtml extends GenerateHtml {
	private String 					title;
	ArrayList<Reservation> 	reservationList;
	
	public GenerateFoundReservationHtml(
			String title, ArrayList<Reservation> reservationList) {
		super();
		this.title = title;
		this.reservationList = reservationList;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(ArrayList<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public String getReservationListTableData() {
		StringBuilder strBld = new StringBuilder();
		for(int i = 0; i < this.reservationList.size(); i++) {
			strBld.append("<tr>");
			strBld.append("<td>");
			strBld.append(this.reservationList.get(i).getStartDayString());
			strBld.append("</td>");
			strBld.append("<td>");
			strBld.append(this.reservationList.get(i).getFirst() + " " + this.reservationList.get(i).getLast());
			strBld.append("</td>");
			strBld.append("<td>");
			strBld.append(this.reservationList.get(i).getLocation());
			strBld.append("</td>");
			strBld.append("<td>");
			strBld.append(this.reservationList.get(i).getGuide());
			strBld.append("</td>");
			strBld.append("<td>");
			strBld.append(this.reservationList.get(i).getNumberOfDays());
			strBld.append("</td>");
			strBld.append("</tr>");
		}
		return strBld.toString();
	}
	
	public void generateHtml() {				
		String extraHead = new String();
		String extraBody = new String();
		extraHead += this.title;
		extraBody = 
				"<nav class=\"navbar navbar-default\">\r\n" + 
				"    <div class=\"container-fluid\">\r\n" + 
				"      <div class=\"navbar-header\">\r\n" + 
				"        <a class=\"navbar-brand\" href=\"./index.jsp\">Beartooth Hiking Company</a>\r\n" + 
				"      </div>\r\n" + 
				"      <ul class=\"nav navbar-nav\">\r\n" + 
				"        <li><a href=\"./index.jsp\">Reservations</a></li>\r\n" + 
				"        <li class=\"active\"><a href=\"./tours.jsp\">Results</a></li>\r\n" + 
				"      </ul>\r\n" + 
				"    </div>\r\n" + 
				"  </nav>"
		;
		
		if(this.reservationList.size() == 0) {
			extraBody += "<div class=\"alert alert-warning\" role=\"alert\">\r\n" + 
					"  <h4 class=\"alert-heading\">We've hit a snag!</h4>\r\n" + 
					"  <p>There are no reservations for this date.</p>\r\n" + 
					"  <hr>\r\n" + 
					"  <p class=\"mb-0\">Please go back to the main menu to make a new query.</p>\r\n" + 
					"</div>";
		}
		extraBody += 
			"<div class=\"container\">\r\n" + 
			"    <div class=\"row\">       \r\n" + 
			"      <div class=\"col-sm-12\">\r\n" + 
			"        <h1>Reservations</h1>\r\n" + 
			"					<table class=\"table\">\r\n" + 
			"  					<thead>\r\n" + 
			"    					<tr>\r\n" + 
			"      					<th scope=\"col\">Date</th>\r\n" + 
			"      					<th scope=\"col\">Customer</th>\r\n" + 
			"      					<th scope=\"col\">Location</th>\r\n" + 
			"      					<th scope=\"col\">Guide</th>\r\n" +
			"      					<th scope=\"col\">Num. of Days</th>\r\n" + 
			"    					</tr>\r\n" + 
			"  					</thead>\r\n" + 
			"  					<tbody>\r\n";
		extraBody += this.getReservationListTableData();
		extraBody += "</tbody>\r\n" + 
			"					</table>\r\n" +
			"      </div>\r\n" + 
			"    </div>\r\n" + 
			"  </div>"
		;
		
		this.buildHtml(extraHead, extraBody);
	}
	
}
