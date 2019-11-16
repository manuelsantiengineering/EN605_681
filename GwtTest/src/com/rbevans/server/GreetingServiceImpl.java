package com.rbevans.server;

import com.rbevans.client.GreetingService;
import com.rbevans.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	DateFormatter formatter = new DateFormatter(new SimpleDateFormat("EEE, MMM d, yyyy"));
	
	public String greetServer(String input, boolean isStaff, Date birthday) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"You must provide a name");
		}
		
		if (birthday == null) {
			throw new IllegalArgumentException(
					"You must provide a birthday");
		}
		
		String preface = "Instructor ";
		if (!isStaff) {
			preface = "Student ";
		}
		return "Hello, " + preface + input + "!<br>" +
		"I hope you have a nice birthday on " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(birthday) +
		"<br>";
	}
}
