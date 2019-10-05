package com.msanti16.net.domain;

import com.msanti16.net.exceptions.BadUserNameException;
import java.util.Date;

public class Reservation {
    private final String[]  TOURS = {"Gardiner Lake", "Hellroaring Plateau", "The Beaten Path"};

    private long            id;
    private String          username;
    private BookingDay      startDate;
    private int             tourId;
    private int             duration;
    private Date            createdAt;
    private Double          totalCost = 0.0;

    public Reservation() {
        super();
    }

    public Reservation(long id, String username, int tourId, int duration, BookingDay startDate)
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

    public BookingDay getStartDate() {
        return startDate;
    }

    public void setStartDate(BookingDay startDate) {
        this.startDate = startDate;
    }

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
