package com.msanti16.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Java EE: Programming Servlets");
		
	}

}
