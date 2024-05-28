package JAVA;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StopAndWaitClient {
    private static final int TIMEOUT = 5000; // Timeout period in milliseconds

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12346;

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(hostname, port), TIMEOUT);
            System.out.println("Connected to the server");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner scanner = new Scanner(System.in);
            String message;

            System.out.print("Enter message to send: ");
            message = scanner.nextLine();

            boolean ackReceived = false;
            while (!ackReceived) {
                writer.println(message); // Send the message

                try {
                    socket.setSoTimeout(TIMEOUT); // Set the timeout period
                    String response = reader.readLine(); // Wait for acknowledgment
                    if ("ACK".equals(response)) {
                        ackReceived = true;
                        System.out.println("ACK received from server");
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout reached. Resending message...");
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

