//1) WAP in java to find out the ip address of a local machine or any other machine
package JAVA;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPlocal_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Get local machine's IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + localHost.getHostAddress());
            
            // Ask user for the remote host name
            System.out.print("Enter the remote host name: ");
            String remoteHostName = scanner.nextLine();
            
            // Get remote machine's IP address
            InetAddress remoteHost = InetAddress.getByName(remoteHostName);
            System.out.println("Remote IP Address (" + remoteHostName + "): " + remoteHost.getHostAddress());
            
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host name.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
