package JAVA;

import java.io.*;
import java.net.*;

public class DateTimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server's IP address or hostname
        int serverPort = 12345; // Server's port number

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            // Get the input stream from the server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Read the response from the server
            String response = reader.readLine();
            System.out.println("Response from server: " + response);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

