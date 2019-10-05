package com.msanti16.net.services;

public class ParseQuoteMessage {
    public static Double parseQuote(String message){
        try{
            String[] parsedMessage = message.split(":");
            return Double.parseDouble(parsedMessage[0]);
        }catch (NumberFormatException exception){
            System.out.println("Error: " + exception);
            return -0.01;
        }catch (NullPointerException exception){
            System.out.println("Error: " + exception);
            return -0.01;
        }
    }
}
