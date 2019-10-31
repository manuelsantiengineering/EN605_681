package com.msanti16.servlet.domain;

import java.util.Date;

import com.msanti16.servlet.constants.*;
import com.msanti16.servlet.exceptions.BadBookingDateException;
import com.msanti16.servlet.exceptions.BadUserNameException;
import com.msanti16.servlet.exceptions.OutOfLimitsReservationException;

public class Reservation {
    private long            id = -1L;
    private String          username = "no name";
    private BookingDay      startDate;
    private int             tourId = 0;
    private int             duration = 0;
    private int             partySize = 0;
    private Date            createdAt;
    private Double          totalCost = 0.0;

    public Reservation() {
        super();
    }

    public Reservation(long id, String username, int tourId, BookingDay startDate, int duration, int partySize)
            throws BadUserNameException, OutOfLimitsReservationException {
        super();
        username = username.trim();
        if(username.length() < 1 || username.isEmpty()){
            throw new BadUserNameException("Username value is too short", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        if(partySize < 1 || partySize > 10) {
        	throw new OutOfLimitsReservationException("Party size must be between 1 and 10, size = ", partySize);
        }
        this.id = id;
        this.username = username;
        this.tourId = tourId;
        this.startDate = startDate;
        this.duration = duration;
        this.partySize = partySize;
    }

    public Reservation(long id, String username, int tourId, int startYear, int startMonth, 
    		int startDay, int duration , int partySize)
            throws BadUserNameException, BadBookingDateException, OutOfLimitsReservationException {
        super();
        username = username.trim();
        if(username.length() < 1 || username.isEmpty()){
            throw new BadUserNameException("Username value is too short", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        if(partySize < 1 || partySize > 10) {
        	throw new OutOfLimitsReservationException("Party size must be between 1 and 10, size = ", partySize);
        }
        this.id = id;
        this.username = username;
        this.tourId = tourId;
        this.duration = duration;
        this.startDate = new BookingDay(startYear, startMonth, startDay);
        this.partySize = partySize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username)  throws BadUserNameException {
        username = username.trim();
        if(username.length() < 1 || username.isEmpty()){
            throw new BadUserNameException("Username value is too short", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        this.username = username;
    }

    public BookingDay getStartDate() {
        return startDate;
    }

    public void setStartDate(BookingDay startDate) {
        this.startDate = startDate;
    }

    public int getStartYear(){ return this.startDate.getYear(); }

    public int getStartMonth(){ return this.startDate.getMonth(); }

    public int getStartDay(){ return this.startDate.getDayOfMonth(); }

    public String getTourName() {
        return ReservationConstants.TOURS[tourId];
    }

    public void setTourName(int tourId) {
        this.tourId = tourId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) throws OutOfLimitsReservationException {
		if(partySize < 1 || partySize > 10) {
        	throw new OutOfLimitsReservationException("Party size must be between 1 and 10, size = ", partySize);
        }
		this.partySize = partySize;
	}

	public Double getTotalCost() {
        return totalCost;
    }
    
    public String getTotalCostString() {
        return String.format("%.2f", this.totalCost);
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        strBld.append("Confirmation Num.: ").append(id);
        strBld.append("\nDate of Reservation: ").append(createdAt.toString());
        strBld.append("\nName: ").append(username);
        strBld.append("\nTour: ").append(this.getTourName());
        strBld.append("\nParty size: ").append(this.getPartySize());
        strBld.append("\nStart Date: ").append(startDate);
        strBld.append("\nDuration: ").append(duration).append(" days");
        strBld.append("\nTotal Cost: $").append(String.format("%.2f", totalCost));
        return  strBld.toString();
    }
}
