package com.msanti16.servlet.domain;

import java.util.Date;

import com.msanti16.servlet.exceptions.BadBookingDateException;
import com.msanti16.servlet.exceptions.BadUserNameException;

public class Reservation {
    private final String[]  TOURS = {"Gardiner Lake", "Hellroaring Plateau", "The Beaten Path"};

    private long            id = -1L;
    private String          username = "no name";
    private BookingDay      startDate;
    private int             tourId = 0;
    private int             duration = 0;
    private Date            createdAt;
    private Double          totalCost = 0.0;

    public Reservation() {
        super();
    }

    public Reservation(long id, String username, int tourId, BookingDay startDate, int duration)
            throws BadUserNameException {
        super();
        username = username.trim();
        if(username.length() < 1 || username.isEmpty()){
            throw new BadUserNameException("Username value is too short", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        this.id = id;
        this.username = username;
        this.tourId = tourId;
        this.startDate = startDate;
        this.duration = duration;
    }

    public Reservation(long id, String username, int tourId, int startYear, int startMonth, int startDay, int duration)
            throws BadUserNameException, BadBookingDateException {
        super();
        username = username.trim();
        if(username.length() < 1 || username.isEmpty()){
            throw new BadUserNameException("Username value is too short", username);
        }
        if(!username.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("Username must be all characters", username);
        }
        this.id = id;
        this.username = username;
        this.tourId = tourId;
        this.duration = duration;
        this.startDate = new BookingDay(startYear, startMonth, startDay);
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
        return TOURS[tourId];
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

    public Double getTotalCost() {
        return totalCost;
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
        strBld.append("\nStart Date: ").append(startDate);
        strBld.append("\nDuration: ").append(duration).append(" days");
        strBld.append("\nTotal Cost: $").append(String.format("%.2f", totalCost));
        return  strBld.toString();
    }
}
