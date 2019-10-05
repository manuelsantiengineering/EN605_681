package com.msanti16.net.services;

public class CreateQuoteMessage {
//    hike_id:begin_year:begin_month:begin_day:duration (e.g: 1:2008:7:1:3)
    public static String createMessage(int hikeTourId, int startYear, int startMonth, int startDay, int duration){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hikeTourId)
                .append(":").append(startYear)
                .append(":").append(startMonth)
                .append(":").append(startDay)
                .append(":").append(duration);
        return stringBuilder.toString();
    }
}
