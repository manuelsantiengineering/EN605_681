package com.msanti16.net;

import com.msanti16.net.services.ClientSocket;
import com.msanti16.net.services.CreateQuoteMessage;

import java.io.IOException;

//TODO throw error for out of the season exception.
//TODO throw alerts

public class Main {
    private static final String SERVER_HOST = "web7.jhuep.com";
    private static final int    PORT = 20025;

    public static void main(String[] args) throws IOException {
        System.out.println("EN.605.681.81.FA19 Principles of Enterprise Web Development");
        System.out.println("Module 6 Homework");
        System.out.println("Manuel E. Santiago Laboy");

        ClientSocket clientSocket = new ClientSocket(SERVER_HOST, PORT);
        clientSocket.createSocket();
        clientSocket.sendMessage(CreateQuoteMessage.createMessage(1, 2019, 9, 4, 3));
        clientSocket.closeConnections();
    }
}
