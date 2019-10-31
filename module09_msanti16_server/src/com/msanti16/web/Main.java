package com.msanti16.web;
import com.msanti16.services.RequestManager;

import java.io.*;
import java.net.*;

public class Main {
    private final static int PORT   = 20005;

    public static void main(String[] args) throws IOException {
        System.out.println("EN.605.681.81.FA19 Principles of Enterprise Web Development");
        System.out.println("Module 9 Homework");
        System.out.println("Manuel E. Santiago Laboy");

        ServerSocket serverSocket = null;
        String requestLine = null;
        PrintWriter out = null;
        BufferedReader in = null;

        RequestManager RequestManager = new RequestManager();

        while (true) {
            try {
                serverSocket = new ServerSocket(PORT);
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + PORT);
                System.exit(1);
            }

            Socket clientSocket = null;
            try {
                while (true) {
                	System.out.println("Waiting for socket accept...");
                    clientSocket = serverSocket.accept();

                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    while (!clientSocket.isClosed()) {
                        requestLine = in.readLine();
                        if (requestLine == null) {
                            break;
                        }
                        String response = RequestManager.getQuote(requestLine);
                        out.println(response);
                        System.out.println("Request: " + requestLine);
                        System.out.println("Response: " + response);
                    }
                    out.close();
                    in.close();
                    clientSocket.close();

                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
            } finally {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            }
        }
    }
}
