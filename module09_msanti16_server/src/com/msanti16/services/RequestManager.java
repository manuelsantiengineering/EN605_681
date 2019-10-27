package com.msanti16.services;

import com.msanti16.exceptions.BadBookingDateException;
import com.msanti16.exceptions.OutOfSeasonException;
import com.msanti16.exceptions.UnableToGetQuoteException;
import com.msanti16.utils.RequestMessageParser;

public class RequestManager {

    public RequestManager() {
        super();
    }

    public final synchronized String getQuote(String request){
        Double quote = -0.01;
        String responseMessage;
        try{
            RequestMessageParser requestMessageParser = new RequestMessageParser(request);
            requestMessageParser.parseRequest();
            quote = requestMessageParser.getQuote();
            responseMessage = "Quoted Rate";
        }catch (OutOfSeasonException exception){
            System.err.println("Error: " + exception.getMessage());
            responseMessage = exception.getMessage();
        }catch (UnableToGetQuoteException exception){
            System.err.println("Error: " + exception.getMessage());
            responseMessage = exception.getMessage();
        }catch (NumberFormatException exception){
            System.err.println("Error: " + exception.getMessage());
            responseMessage = exception.getMessage();
        }catch (BadBookingDateException exception){
            System.err.println("Error: " + exception.getMessage());
            responseMessage = exception.getMessage();
        }catch (NullPointerException exception){
            System.err.println("Error: " + exception.getMessage());
            responseMessage = exception.getMessage();
        }
        return String.format("%.2f", quote) + ":" + responseMessage;
    }
}
