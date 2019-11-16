package com.gwt.msanti16.bhc.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(
			String nameToServer, 
			String startDateToServer,
			int durationToServer,
			int partySizeToServer,
			int hikeId, 
			AsyncCallback<String> callback
			) throws IllegalArgumentException;
}
