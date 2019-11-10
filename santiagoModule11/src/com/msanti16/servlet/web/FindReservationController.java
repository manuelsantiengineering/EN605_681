package com.msanti16.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msanti16.servlet.services.FindReservationService;

@WebServlet("/findReservation")
public class FindReservationController extends HttpServlet {
	private static final long serialVersionUID = -5133123431781182018L;
	
	private FindReservationService findReservationService = new FindReservationService();

		public FindReservationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String startDate = null;
		String findReservationServiceResponse = null;
		
		try {
			startDate = request.getParameter("startDate");
			if(startDate == null) {
				startDate = "<none entered>";
			}
			findReservationServiceResponse = findReservationService.findReservation(startDate);
			out.println(findReservationServiceResponse);
		}
		finally {
			out.close();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
