package com.gwt.msanti16.bhc.client;

import com.gwt.msanti16.bhc.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class SantiagoModule13 implements EntryPoint {	
	private static final String SERVER_ERROR = 
			"An error occurred while attempting to contact the server. Please check your network connection and try again.";

	private final String[]	TOURS 															= {"Gardiner Lake", "Hellroaring Plateau", "The Beaten Path"};
	private final String[]	DURATION_GARDINER_LAKE 							= {"3", "5"};
	private final String[]	DURATION_HELLROARING_PLATEAU   			= {"2", "3", "4"};
	private final String[]	DURATION_BEATEN_PATH             		= {"5", "7"};
	
	// Create a remote service proxy to talk to the server-side Greeting service.	 
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void onModuleLoad() {
			
		final Label usernameLbl = new Label("Name");
		final Label hikeLbl = new Label("Tour");
		final Label startDateLbl = new Label("Start Date (yyyy-mm-dd)");
		final Label numOfPeopleLbl = new Label("Party Size:");
		final Label durationLbl = new Label("Duration:");
		final Label errorLabel = new Label();
		
		final TextBox nameField = new TextBox();
		final ListBox hikeListBox = new ListBox();
		final DateBox startDateBox = new DateBox();
		final ListBox durationListBox = new ListBox();
		final TextBox numberOfPeopleBox = new TextBox();
		
		final Button sendButton = new Button("Reserve");
		final FlexTable grid = new FlexTable();		
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
	
		for (int i = 0; i < TOURS.length; i++) {
			hikeListBox.addItem(TOURS[i]);
    }
		for (int i = 0; i < DURATION_GARDINER_LAKE.length; i++) {
			durationListBox.addItem(DURATION_GARDINER_LAKE[i]);
    }

		DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.YEAR_MONTH_NUM_DAY);
		startDateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		numberOfPeopleBox.setValue("1");		
		
		grid.setWidget(0, 0, usernameLbl);
		grid.setWidget(0, 1, nameField);
		grid.setWidget(1, 0, hikeLbl);
		grid.setWidget(1, 1, hikeListBox);
		grid.setWidget(2, 0, numOfPeopleLbl);
		grid.setWidget(2, 1, numberOfPeopleBox);
		grid.setWidget(3, 0, startDateLbl);
		grid.setWidget(3, 1,  startDateBox);
		grid.setWidget(4, 0, durationLbl);
		grid.setWidget(4, 1,  durationListBox);
		grid.setWidget(5, 0, sendButton);
		grid.getFlexCellFormatter().setColSpan(5, 0, 2);		
		grid.setStyleName("reservationTable");
		sendButton.setStyleName("button");
		grid.setWidget(6,  0,  errorLabel);
		grid.getFlexCellFormatter().setColSpan(6, 0, 2);
		
		RootPanel.get("reservationContainer").add(grid);
		
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();
		
		hikeListBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {						
				int initialItemsCount = durationListBox.getItemCount();				
				for (int index = 0; index < initialItemsCount; index++) {
					durationListBox.removeItem(0);
				}
				switch(hikeListBox.getSelectedIndex()) {
					case 0:
						for (int i = 0; i < DURATION_GARDINER_LAKE.length; i++) {
							durationListBox.addItem(DURATION_GARDINER_LAKE[i]);
				    }		
						break;
					case 1:
						for (int i = 0; i < DURATION_HELLROARING_PLATEAU.length; i++) {
							durationListBox.addItem(DURATION_HELLROARING_PLATEAU[i]);
				    }
						break;
					case 2:
						for (int i = 0; i < DURATION_BEATEN_PATH.length; i++) {
							durationListBox.addItem(DURATION_BEATEN_PATH[i]);
				    }	
						break;
				}
			}
		});

		numberOfPeopleBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {				
				String validResponse = FieldVerifier.isValidPartySize(numberOfPeopleBox.getValue());
				errorLabel.setText(validResponse);				
			}
		});
		
		nameField.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {				
				String username = nameField.getText();
				if(username.length() < 1 || username.isEmpty()){
					errorLabel.setText("");
					return;
	      }
	      if(!username.matches("^[a-zA-Z]*$")){
	      	errorLabel.setText("Name must be all characters");
	      	return;
	      }
			}
		});
		
		startDateBox.getTextBox().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {										
				String validResponse = FieldVerifier.isValidDate(startDateBox.getTextBox().getText());				
				errorLabel.setText(validResponse);							
			}
		});
		
		//EVERYTHING IS VALIDATED SEND IT TO SERVER FOR PRICE CALCULATION
		
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		class MyHandler implements ClickHandler {			
			// Fired when the user clicks on the sendButton.			
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}			
			// Send the name from the nameField to the server and wait for a response.
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String nameToServer = nameField.getText();
				String partySizeStrToServer = numberOfPeopleBox.getText();
				String startDateToServer = startDateBox.getTextBox().getText();
				String durationStrToServer = durationListBox.getSelectedItemText();
				int hikeId = hikeListBox.getSelectedIndex();
				
				if (!FieldVerifier.isValidName(nameToServer)) {
					errorLabel.setText("Invalid name");
					return;
				}
				if (FieldVerifier.isValidDate(startDateToServer).length() != 0) {
					errorLabel.setText(FieldVerifier.isValidDate(startDateToServer));
					return;
				}
				if (FieldVerifier.isValidPartySize(partySizeStrToServer).length() != 0) {
					errorLabel.setText(FieldVerifier.isValidPartySize(partySizeStrToServer));
					return;
				}
				if (!FieldVerifier.isValidHikeId(hikeId)) {
					errorLabel.setText("Invalid Hike selection [" + hikeId + "]");
					return;
				}
				if (FieldVerifier.isValidDuration(durationStrToServer).length() != 0) {
					errorLabel.setText(FieldVerifier.isValidDuration(durationStrToServer));
					return;
				}

				int partySizeToServer = Integer.parseInt(partySizeStrToServer);
				int durationToServer = Integer.parseInt(durationStrToServer);
				
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(nameToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(
						nameToServer,
						startDateToServer,
						durationToServer,
						partySizeToServer,
						hikeId,
						new AsyncCallback<String>() {
							
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
	}
}
