package com.gwt.msanti16.bhc.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(
			String nameToServer, 
			String startDateToServer,
			int durationToServer,
			int partySizeToServer,
			int hikeId
			) 
			throws IllegalArgumentException;
}
