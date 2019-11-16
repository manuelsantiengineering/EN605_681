package com.rbevans.client;

import com.rbevans.shared.FieldVerifier;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtTest implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";
    private static final String[] TYPE = {"Staff", "Student",};

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Label instructionLbl = new Label("Please enter your name, gender and birthdate");
		final Label nameLbl = new Label("Name");
		final Label typeLbl = new Label("Type");
		final Label birthdayLbl = new Label("Birthday (YYYY month DD)");
		final Label errorLabel = new Label();
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		final ListBox typeLBox = new ListBox();
		final DateBox dateBox = new DateBox();
		final FlexTable grid = new FlexTable();
		nameField.setText("Your name here");
		DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.YEAR_MONTH_NUM_DAY);
		dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

		for (int i = 0; i < TYPE.length; i++) {
		      typeLBox.addItem(TYPE[i]);
		    }


		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		
		// now configure the Table
		grid.setWidget(0, 0, instructionLbl);
		grid.getFlexCellFormatter().setColSpan(0, 0, 3);
		grid.setWidget(1, 0, nameLbl);
		grid.setWidget(1, 1, typeLbl);
		grid.setWidget(1, 2, birthdayLbl);
		grid.setWidget(2, 0, nameField);
		grid.setWidget(2, 1, typeLBox);
		grid.setWidget(2, 2, dateBox);
		grid.setWidget(3,  0,  sendButton);
		grid.getFlexCellFormatter().setColSpan(3, 0, 3);
		grid.setWidget(4,  0,  errorLabel);
		grid.getFlexCellFormatter().setColSpan(4, 0, 3);
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(grid);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();
		
		typeLBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(typeLBox.getSelectedIndex() == 0) {
					nameField.setValue(typeLBox.getSelectedItemText());
				}else {
					nameField.setValue(typeLBox.getSelectedItemText());
				}				
			}
		});
		

		// Create an error handler popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Server Error");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
//		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
//		dialogVPanel.add(new HTML("<b>There was an error:</b>"));
//		dialogVPanel.add(textToServerLabel);
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

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendDataToServer();
			}
			
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendDataToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				int index = typeLBox.getSelectedIndex();
				boolean isMale = TYPE[0].equals(typeLBox.getItemText(index));
				Date date = dateBox.getValue();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				if (date == null) {
					errorLabel.setText("Please enter your birthday");
					return;
				} 
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
//				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						isMale,
						date,
						new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox
						.setText("Remote Procedure Call - Failure");
						serverResponseLabel
						.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}
					
					public void onSuccess(String result) {
						// I left this in to show another debugging option...
						System.out.println("Result = " + result);
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel
						.removeStyleName("serverResponseLabelError");
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
