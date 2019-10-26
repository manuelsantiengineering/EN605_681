package echoclient;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class Main {

    public static void main(String[] args) throws IOException {
//    	String server = "web7.jhuep.com";
		String server = "localhost";
    	int port = 20005;
    	if (args.length == 2) {
    		server = args[0];
    		port = Integer.parseInt(args[1]);
    	}
    	Socket echoSocket = null;
    	PrintWriter out = null;
    	BufferedReader in = null;

    	try {
    		System.out.println("Making the Socket at " + server + " port " + port);
    		echoSocket = new Socket(server, port);
//  		System.out.println("Making the PrintWriter...");
    		out = new PrintWriter(echoSocket.getOutputStream(), true);
//  		System.out.println("Making the BufferedReader...");
    		in = new BufferedReader(new InputStreamReader(
    				echoSocket.getInputStream()));
    	} catch (UnknownHostException e) {
    		System.err.println("Don't know about host: " + server);
    		System.exit(1);
    	} catch (IOException e) {
    		System.err.println("Couldn't get I/O for " + "the connection to: " + server + " at port " + port);
    		System.exit(1);
    	}
  	System.out.println("Reading stdIn....");
    	BufferedReader stdIn = new BufferedReader(
    			new InputStreamReader(System.in));
    	String userInput;

    	String echo;
    	while ((userInput=stdIn.readLine()) != null) {
    		out.println(userInput);
    		echo = in.readLine();
    		if (echo == null) {
    			System.out.println("Disconnected!");
    			break;
    		} else {
    			System.out.println("echo: " + echo);
    		}
    	}

//		int data;
//		System.out.print("Value: ");
//		while((data = stdIn.read()) != -1){
//			System.out.print((char) data);
//		}


    	out.close();
    	in.close();
    	stdIn.close();
    	echoSocket.close();
    }
}
