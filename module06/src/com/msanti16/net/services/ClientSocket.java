package com.msanti16.net.services;

import java.io.*;
import java.net.*;


/*
    To implement a network client:
        Create a Socket object
        Create an output stream to send data to the socket
        Create an input stream to read server response from the socket
        Do I/O with the server using I/O streams
        Close socket
 */

public class ClientSocket extends Socket {


    public ClientSocket() {
        super();
    }

    public void mainSocket(String SERVER_HOST, int PORT) throws IOException {
        System.out.println("EN.605.681.81.FA19 Principles of Enterprise Web Development");
        System.out.println("Module 6 Homework");
        System.out.println("Manuel E. Santiago Laboy");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.out.println("Making the Socket at " + SERVER_HOST + " PORT " + PORT);
            echoSocket = new Socket(SERVER_HOST, PORT);
//  		System.out.println("Making the PrintWriter...");
            out = new PrintWriter(echoSocket.getOutputStream(), true);
//  		System.out.println("Making the BufferedReader...");
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + SERVER_HOST);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + SERVER_HOST + " at PORT " + PORT);
            System.exit(1);
        }
        System.out.println("Reading stdIn....");
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String response;
        String testRequestMessage = CreateQuoteMessage.createMessage(1, 2019, 9, 4, 3);
        ResponseMessage testResponse = new ResponseMessage();
        while (stdIn.readLine() != null) {
            out.println(testRequestMessage);
            response = in.readLine();
            if (response == null) {
                System.out.println("Disconnected!");
                break;
            } else {
                testResponse.parseQuote(response);
                System.out.println(response);
                System.out.println("testQuote: " + testResponse.getQuote());
                System.out.println("testMessage: " + testResponse.getMessage());
            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }















////    private Socket serverSocket = null;
////    private PrintWriter out = null;
////    private BufferedReader in = null;
//
//
//
//    public void sendMessage(InputStreamReader inputStreamReader) throws IOException {
//        BufferedReader stdIn = new BufferedReader(inputStreamReader);
//        String userInput;
//        PrintWriter out = null;
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
//        }catch (IOException e) {
//            System.err.println("Couldn't get I/O for " + "the connection to: " + this.host + ":" + port);
//            System.exit(1);
//        }
//        String response;
//        while ((userInput=stdIn.readLine()) != null) {
//            out.println(userInput);
//            response = in.readLine();
//            if (response == null) {
//                System.out.println("Disconnected!");
//                break;
//            } else {
//                System.out.println("Response: " + response);
//            }
//        }
//        out.close();
//        in.close();
//    }
//
//
//
//
//
//
//    public void createSocket(String serverHost, int port) throws IOException {
//        try {
//            System.out.println("Making the Socket at " + serverHost + " port " + port);
//            serverSocket = new Socket(serverHost, port);
//            System.out.println("from: " + serverSocket.getLocalAddress() + ":" + serverSocket.getLocalPort());
//            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
//
//        } catch (UnknownHostException e) {
//            System.err.println("Unknown host: " + serverHost);
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHost + ":" + port);
//            System.exit(1);
//        }
//
//        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//        String userInput;
//
//        String response;
//        while ((userInput=stdIn.readLine()) != null) {
//            out.println(userInput);
//            response = in.readLine();
//            if (response == null) {
//                System.out.println("Disconnected!");
//                break;
//            } else {
//                System.out.println("Response: " + response);
//            }
//        }
//
//        out.close();
//        in.close();
//        stdIn.close();
//        serverSocket.close();
//
//    }
}
