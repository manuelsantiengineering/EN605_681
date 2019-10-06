package com.msanti16.net.services;

import com.msanti16.net.exceptions.OutOfSeasonException;
import com.msanti16.net.exceptions.UnableToGetQuoteException;

public class ResponseMessage {
    private String response;
    private Double quote = -0.01;
    private String message = "No Response";

    public ResponseMessage(String response) throws UnableToGetQuoteException {
        super();
        this.response = response;
        if(this.response.isEmpty()){
            throw new UnableToGetQuoteException("Unable to receive response from server", this.response);
        }
    }

    public void parseQuote()
            throws OutOfSeasonException, NumberFormatException, NullPointerException, UnableToGetQuoteException {
        String[] parsedMessage = this.response.split(":");
        this.quote = Double.parseDouble(parsedMessage[0]);
        this.message = parsedMessage[1].trim();
        if(this.quote == -0.01){
            throw new UnableToGetQuoteException("Unable to receive response from server", this.response);
        }
        if(this.message.equals("begin or end date was out of season") == true ){
            throw new OutOfSeasonException("Selected dates are out of the season");
        }
    }

    public Double getQuote() {
        return quote;
    }

    public String getMessage() {
        return message;
    }

}
