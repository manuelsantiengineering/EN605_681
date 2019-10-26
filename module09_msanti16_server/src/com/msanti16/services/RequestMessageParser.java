package com.msanti16.services;

import com.msanti16.exceptions.OutOfSeasonException;
import com.msanti16.exceptions.UnableToGetQuoteException;

public class RequestMessageParser {
    private String request;
    private Integer hikeId      = 0;
    private Integer year        = 2019;
    private Integer month       = 1;
    private Integer day         = 1;
    private Integer duration    = 1;

    public RequestMessageParser(String request) throws UnableToGetQuoteException {
        super();
        if(request.isEmpty()){
            throw new UnableToGetQuoteException("Empty request string", request);
        }
        this.request = request;
    }

    public void parseRequest()
            throws OutOfSeasonException, NumberFormatException, NullPointerException, UnableToGetQuoteException {
        String[] parsedRequest = this.request.split(":");
        //TODO Add verifier to make sure there are enough arguments HikeId:Year:Month:Day:Duration
        //TODO Throw error if values are not integers
        //TODO throw errors if date values are incorrect
        this.hikeId = Integer.parseInt(parsedRequest[0]);
        this.year = Integer.parseInt(parsedRequest[1]);
        this.month = Integer.parseInt(parsedRequest[2]);
        this.day = Integer.parseInt(parsedRequest[3]);
        this.duration = Integer.parseInt(parsedRequest[4]);

//        if(this.message.equals("begin or end date was out of season") == true ){
//            throw new OutOfSeasonException("Selected dates are out of the season");
//        }
//        if(this.quote == -0.01){
//            throw new UnableToGetQuoteException("Unable to receive response from server", this.parsedRequest);
//        }
    }

    public String getRequest() {
        return this.request;
    }


}
