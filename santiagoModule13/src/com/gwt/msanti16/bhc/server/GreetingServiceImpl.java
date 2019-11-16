package com.gwt.msanti16.bhc.server;

import com.gwt.msanti16.bhc.client.GreetingService;
import com.gwt.msanti16.bhc.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.gwt.msanti16.bhc.services.GenerateCompletedReservationHtml;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(
			String nameToServer, 
			String startDateToServer,
			int durationToServer,
			int partySizeToServer,
			int hikeId			
			) throws IllegalArgumentException {
		if (!FieldVerifier.isValidName(nameToServer)) {
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}
		if (FieldVerifier.isValidDate(startDateToServer).length() != 0) {
			throw new IllegalArgumentException(FieldVerifier.isValidDate(startDateToServer));
		}
		if (FieldVerifier.isValidPartySize(""+partySizeToServer).length() != 0 ) {
			throw new IllegalArgumentException(FieldVerifier.isValidPartySize(""+partySizeToServer));
		}
		if (!FieldVerifier.isValidHikeId(hikeId) ) {
			throw new IllegalArgumentException("Invalid Hike Id");
		}
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		nameToServer = escapeHtml(nameToServer);
		startDateToServer = escapeHtml(startDateToServer);		
		userAgent = escapeHtml(userAgent);
		
		String[] parsedDate = startDateToServer.split("-");
    int year = Integer.parseInt(parsedDate[0]);
		int month = Integer.parseInt(parsedDate[1]);
    int day = Integer.parseInt(parsedDate[2]);
		
		GenerateCompletedReservationHtml completedReservationHtml 
		= new GenerateCompletedReservationHtml(
				"<title>Beartooth Hiking Company</title>",
				nameToServer,
				startDateToServer,
				"Tour Name My",
				"10",
				"5",
				"1234.56"
				);
		completedReservationHtml.generateHtml();
		return completedReservationHtml.toString();
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
