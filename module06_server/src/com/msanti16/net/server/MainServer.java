package com.msanti16.net.server;

import java.net.*;
import java.io.*;

public class MainServer {
    private final static int PORT = 5432;

    public static void main(String[] args) throws IOException{
        ServerSocket mainServer = null;
        Socket clientSocket;
        InetAddress inetAddress = null;

        try{
            mainServer = new ServerSocket(PORT);
            inetAddress = InetAddress.getLocalHost();
            System.out.println("Started server on Host: " + inetAddress.getHostAddress() + "\nListening to port: " + PORT);
            while(true){
                clientSocket = mainServer.accept();
            }

        }catch (IOException ex){
            System.out.println("Could not listen on port: " + PORT);
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
