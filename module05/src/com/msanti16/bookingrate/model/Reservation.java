package com.msanti16.bookingrate.model;

import com.msanti16.bookingrate.exceptions.BadUserNameException;

import java.util.Date;

public class Reservation {
    private long            id;
    private String          username;
    private String          tourName;
    private BookingDay      startDate;
    private Integer         duration;
    private Date            createdAt;
    private Double          totalCost = 0.0;

    public Reservation() {
        super();
    }

    public Reservation(long id, String username, String tourName, Integer duration, BookingDay startDate)
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
        this.tourName = tourName;
        this.duration = duration;
        this.startDate = startDate;
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

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BookingDay getStartDate() {
        return startDate;
    }

    public void setStartDate(BookingDay startDate) {
        this.startDate = startDate;
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
        strBld.append("\nTour: ").append(tourName);
        strBld.append("\nStart Date: ").append(startDate);
        strBld.append("\nDuration: ").append(duration).append(" days");
        strBld.append("\nTotal Cost: $").append(String.format("%.2f", totalCost));
        return  strBld.toString();
    }
}
