package com.msanti16.net.services;

import com.msanti16.net.domain.BookingDay;
import com.msanti16.net.domain.Reservation;
import com.msanti16.net.exceptions.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//TODO Erase CreateQuoteMessage class
//TODO Verify used constant values
//TODO Close socket connection
//TODO Remove unecessary imports


public class ReservationService {
    private final static List<Reservation> reservationsList = new ArrayList<Reservation>();

    private ClientSocket    clientSocket;

    public ReservationService(String serverHost, int port) {
        try {
            this.clientSocket = new ClientSocket(serverHost, port);
            this.clientSocket.createSocket();
        }catch(IOException exception){
            System.out.println("Unable to create socket connection");
        }
    }

    public void closeSocket() throws IOException {
        clientSocket.closeConnections();
    }

    public static String createQuoteMessage(
            int hikeTourId, int startYear, int startMonth,
            int startDay, int duration
    ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hikeTourId)
                .append(":").append(startYear)
                .append(":").append(startMonth)
                .append(":").append(startDay)
                .append(":").append(duration);
        return stringBuilder.toString();
    }

    public void createReservation(
            String reservationMonth, String reservationDay,
            String reservationYear, String tourDuration,
            String username, int tourId
    ){
        System.out.println("Creating Reservation");
        try{
            if(reservationMonth.isEmpty()){
                throw new BadIntegerParsingException("Reservation month can't be empty", reservationMonth);
            }
            if(reservationDay.isEmpty()){
                throw new BadIntegerParsingException("Reservation day can't be empty", reservationDay);
            }
            if(reservationYear.isEmpty()){
                throw new BadIntegerParsingException("Reservation year can't be empty", reservationYear);
            }

            int month = Integer.parseInt(reservationMonth);
            int day = Integer.parseInt(reservationDay);
            int year = Integer.parseInt(reservationYear);
            BookingDay startDate = new BookingDay(year, month, day);
            int duration = Integer.parseInt(tourDuration);

            String responseStr = clientSocket.sendMessage(
                    CreateQuoteMessage.createMessage(tourId, year, month, day, duration)
            );
            ResponseMessage response = new ResponseMessage(responseStr);
            response.parseQuote();
            System.out.println("response: " + response.getMessage());
            System.out.println("response: " + response.getResponse());

            Reservation reservation = new Reservation();
            reservation.setUsername(username);
            reservation.setTourName(tourId);
            reservation.setStartDate(startDate);
            reservation.setDuration(duration);
            reservation.setId(reservationsList.size());
            reservation.setCreatedAt(new Date());
            reservation.setTotalCost(response.getQuote());

            reservationsList.add(reservation);

            JOptionPane.showMessageDialog(null, "Reservation Completed!\n" + reservation);
        }catch (BadUserNameException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (BadBookingDateException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (BadIntegerParsingException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (OutOfSeasonException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException exception){
            System.out.println("Unable to create send message using socket connection");
            JOptionPane.showMessageDialog(null, "Unable to create send message using socket connection", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (NullPointerException exception){
            System.out.println("Unable to parse response");
            JOptionPane.showMessageDialog(null, "Unable to parse response", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (UnableToGetQuoteException exception){
            System.out.println("Error: " + exception);
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }
}
