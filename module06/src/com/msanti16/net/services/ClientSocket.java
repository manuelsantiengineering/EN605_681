package com.msanti16.net.services;

import java.io.*;
import java.net.*;

public class ClientSocket extends Socket {
    private Socket socket = null;
    private String serverHost;
    private int serverPort;
    PrintWriter out = null;
    BufferedReader in = null;

    public ClientSocket(String serverHost, int serverPort) {
        super();
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void createSocket() throws IOException {
        try {
            System.out.println("Creating Socket at " + this.serverHost + " PORT " + this.serverPort);
            socket = new Socket(this.serverHost, this.serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + this.serverHost);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + this.serverHost + " at PORT " + this.serverPort);
            System.exit(1);
        }
    }

    public ResponseMessage sendMessage(String message) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            this.out.println(message);
            String responseStr = this.in.readLine();
            if (responseStr == null) {
                System.out.println("Disconnected!");
            } else {
                responseMessage.parseQuote(responseStr);
                System.out.println(responseStr);
                System.out.println("testQuote: " + responseMessage.getQuote());
                System.out.println("testMessage: " + responseMessage.getMessage());
            }
            return responseMessage;
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + this.serverHost + " at PORT " + this.serverPort);
            System.exit(1);
        }
        return responseMessage;
    }

    public void closeConnections() throws IOException {
        try{
            this.socket.close();
            out.close();
            in.close();
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + this.serverHost + " at PORT " + this.serverPort);
            System.exit(1);
        }

    }

}
