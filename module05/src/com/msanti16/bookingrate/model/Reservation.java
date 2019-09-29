package com.msanti16.bookingrate.model;

import java.util.Date;

import com.msanti16.bookingrate.model.BookingDay;

public class Reservation {
    private long            id;
    private String          username;
    private BookingDay      startDate;
    private BookingDay      endDate;
    private Date            createdAt;

}
