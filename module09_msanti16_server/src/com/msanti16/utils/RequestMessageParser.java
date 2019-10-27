package com.msanti16.utils;

import com.msanti16.domain.BookingDay;
import com.msanti16.domain.Rates;
import com.msanti16.exceptions.BadBookingDateException;
import com.msanti16.exceptions.OutOfSeasonException;
import com.msanti16.exceptions.UnableToGetQuoteException;

//TODO Request looks like: hike_id:begin_year:begin_month:begin_day:duration (e.g: 1:2008:7:1:3)
//TODO Hike Mapping: 0=Gardiner, 1=Hellroaring, 2=Beaten

public class RequestMessageParser {
    private String request;
    private Integer hikeId      = -1;
    private Integer year        = -1;
    private Integer month       = -1;
    private Integer day         = -1;
    private Integer duration    = -1;
    private Double quote        = -0.01;

    public RequestMessageParser() {
        super();
    }

    public RequestMessageParser(String request) throws UnableToGetQuoteException {
        super();
        if(request == null || request.isEmpty()){
            throw new UnableToGetQuoteException("Empty request string", request);
        }
        this.request = request;
    }

    public void parseRequest()
            throws OutOfSeasonException, NumberFormatException,
            NullPointerException, UnableToGetQuoteException,
            BadBookingDateException {

        String[] parsedRequest = this.request.split(":");

        if(parsedRequest == null || parsedRequest.length != 5){
            throw new UnableToGetQuoteException("Unable to parse request format", request);
        }
        for(int i = 0; i < parsedRequest.length; i++){
            if(parsedRequest[i].isEmpty()){
                throw new UnableToGetQuoteException("Request parameters can't be empty", request);
            }
        }

        this.hikeId = Integer.parseInt(parsedRequest[0]);
        if(this.hikeId < 0 || this.hikeId > 2){
            throw new UnableToGetQuoteException("Invalid hike id", request);
        }

        this.year = Integer.parseInt(parsedRequest[1]);
        this.month = Integer.parseInt(parsedRequest[2]);
        this.day = Integer.parseInt(parsedRequest[3]);
        this.duration = Integer.parseInt(parsedRequest[4]);

        BookingDay startDate = new BookingDay(this.year, this.month, this.day);
        Rates rates;
        //TODO Hike Mapping: 0=Gardiner, 1=Hellroaring, 2=Beaten
        switch(this.hikeId){
            case 1:
                rates = new Rates(Rates.HIKE.HELLROARING);
                break;
            case 2:
                rates = new Rates(Rates.HIKE.BEATEN);
                break;
            case 0:
            default:
                rates = new Rates(Rates.HIKE.GARDINER);
                break;
        }
        rates.setBeginDate(startDate);
        rates.setDuration(this.duration);

        //TODO throw out of season exception if rate.isValidDates() == false
        //TODO return "-0.01:begin or end date was out of season"
        if(!rates.isValidDates()){
            throw new OutOfSeasonException("begin or end date was out of season");
        }
        this.quote = rates.getCost();
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String request) throws UnableToGetQuoteException {
        if(request == null || request.isEmpty()){
            throw new UnableToGetQuoteException("Empty request string", request);
        }
        this.request = request;
    }

    public Integer getHikeId() {
        return hikeId;
    }

    public void setHikeId(Integer hikeId) {
        this.hikeId = hikeId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getQuote() {
        return quote;
    }

    public void setQuote(Double quote) {
        this.quote = quote;
    }
}
