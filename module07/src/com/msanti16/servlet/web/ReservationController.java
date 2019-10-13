package com.msanti16.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Reservation Completed</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Reservation Completed</h1>");
			out.println("<p>Name: " + username + "</p>");
			out.println("<p>Start Date: " + startDate + "</p>");
			out.println("<p>Tour: " + tourName + "</p>");
			out.println("<p>Duration: " + duration + "</p>");
			out.println("</body>");
			out.println("</html>");
			
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
