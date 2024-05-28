package JAVA;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and waiting for client requests...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                    // Get the current date and time
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date currentDate = new Date();
                    String dateTimeString = formatter.format(currentDate);

                    // Send the response to the client
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println(dateTimeString);

                    System.out.println("Response sent to client: " + dateTimeString);
                } catch (IOException ex) {
                    System.out.println("Error handling client request: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }
}
