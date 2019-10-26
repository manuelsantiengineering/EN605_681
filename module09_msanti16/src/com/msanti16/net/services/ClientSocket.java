package com.msanti16.net.services;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

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
            this.socket = new Socket(this.serverHost, this.serverPort);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + this.serverHost);
            System.exit(1);
        }
    }

    public String sendMessage(String message) throws IOException {
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String responseStr = "";
        System.out.println("message = " + message);
        try {
            this.out.println(message);
            responseStr = this.in.readLine();
            System.out.println("response = " + responseStr);
            if (responseStr == null) {
                System.err.println("Disconnected!");
            }
            return responseStr;
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + this.serverHost + " at PORT " + this.serverPort);
            System.exit(1);
        }
        return responseStr;
    }

    public void closeConnections() throws IOException {
        try{
            System.out.println("Closing Socket at " + this.serverHost + " PORT " + this.serverPort);
            this.socket.close();
            this.out.close();
            this.in.close();
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + this.serverHost + " at PORT " + this.serverPort);
            System.exit(1);
        }

    }

}
