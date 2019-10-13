package com.msanti16.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msanti16.servlet.services.ReservationService;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = -9094172156258412636L;
	
	private ReservationService reservationService = new ReservationService();

	public ReservationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = null;
		String startDate = null;
		String tourName = null;
		String duration = null;
		String reservationServiceResponse = null;
		try {
			username = request.getParameter("username");
			if(username == null) {
				username = "<none entered>";
			}
			startDate = request.getParameter("startDate");
			if(startDate == null) {
				startDate = "<none entered>";
			}
			tourName = request.getParameter("tourName");
			if(tourName == null) {
				tourName = "<none entered>";
			}
			duration = request.getParameter("duration");
			if(duration == null) {
				duration = "<none entered>";
			}			
			
			reservationServiceResponse = 
					reservationService.createReservation(username, tourName, startDate, duration);
			
			System.out.println("End");
//			System.out.println(reservationServiceResponse);
			out.println(reservationServiceResponse);			
		} 
		finally {
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
