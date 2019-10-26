package com.msanti16.server;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class Main {
    private final static int PORT=20005;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        String outputLine = null;
        PrintWriter out = null;
        BufferedReader in = null;

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
                	System.out.println("Waiting for accept...");
                    clientSocket = serverSocket.accept();

                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    while (!clientSocket.isClosed()) {
                        outputLine = in.readLine();
                        if (outputLine == null) {
                            break;
                        }
                        out.println(outputLine);
                        System.out.println("Processed echo of [" + outputLine + "]");
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
