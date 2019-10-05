package com.msanti16.net.services;

public class ResponseMessage {
    private Double quote = -0.01;
    private String message = "";

    public ResponseMessage() {
        super();
    }

    public ResponseMessage(String response) {
        super();
        this.parseQuote(response);
    }

    public void parseQuote(String response){
        try{
            String[] parsedMessage = response.split(":");
            this.quote = Double.parseDouble(parsedMessage[0]);
            this.message = parsedMessage[1];
        }catch (NumberFormatException exception){
            System.out.println("Error: " + exception);
        }catch (NullPointerException exception){
            System.out.println("Error: " + exception);
        }
    }

    public Double getQuote() {
        return quote;
    }

    public void setQuote(Double quote) {
        this.quote = quote;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
