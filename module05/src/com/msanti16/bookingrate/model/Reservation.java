package com.msanti16.bookingrate.model;

import com.msanti16.bookingrate.exceptions.BadUserNameException;

import java.util.Date;

public class Reservation {
    private long            id;
    private String          username;
    private String          tourName;
    private Integer         duration;
    private BookingDay      startDate;
    private BookingDay      endDate;
    private Date            createdAt;

    public Reservation() {
        super();
    }

    public Reservation(long id, String username, String tourName, Integer duration, BookingDay startDate, BookingDay endDate) {
        super();
        this.id = id;
        this.username = username;
        this.tourName = tourName;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public BookingDay getEndDate() {
        return endDate;
    }

    public void setEndDate(BookingDay endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tourName='" + tourName + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
