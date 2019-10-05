package com.msanti16.net;

import com.msanti16.net.services.ClientSocket;

import java.io.IOException;

public class Main {
    private static final String SERVER_HOST = "web7.jhuep.com";
    private static final int    PORT = 20025;

    public static void main(String[] args) throws IOException {
        ClientSocket socket = new ClientSocket();
        socket.mainSocket(SERVER_HOST, PORT);
    }

//    public static void main(String[] args) throws IOException {
//        System.out.println("EN.605.681.81.FA19 Principles of Enterprise Web Development");
//        System.out.println("Module 6 Homework");
//        System.out.println("Manuel E. Santiago Laboy");
//
//        Socket echoSocket = null;
//        PrintWriter out = null;
//        BufferedReader in = null;
//
//        try {
//            System.out.println("Making the Socket at " + SERVER_HOST + " PORT " + PORT);
//            echoSocket = new Socket(SERVER_HOST, PORT);
////  		System.out.println("Making the PrintWriter...");
//            out = new PrintWriter(echoSocket.getOutputStream(), true);
////  		System.out.println("Making the BufferedReader...");
//            in = new BufferedReader(new InputStreamReader(
//                    echoSocket.getInputStream()));
//        } catch (UnknownHostException e) {
//            System.err.println("Don't know about host: " + SERVER_HOST);
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Couldn't get I/O for " + "the connection to: " + SERVER_HOST + " at PORT " + PORT);
//            System.exit(1);
//        }
//        System.out.println("Reading stdIn....");
//        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//
//        String response;
//        String testRequestMessage = CreateQuoteMessage.createMessage(1, 2019, 10, 4, 3);
//        Double testQuoteResponse;
//        while (stdIn.readLine() != null) {
//            out.println(testRequestMessage);
//            response = in.readLine();
//            if (response == null) {
//                System.out.println("Disconnected!");
//                break;
//            } else {
//                testQuoteResponse = ParseQuoteMessage.parseQuote(response);
//                System.out.println(response);
//                System.out.println("testQuoteResponse: " + testQuoteResponse);
//            }
//        }
//
//        out.close();
//        in.close();
//        stdIn.close();
//        echoSocket.close();
//    }
}
