package JAVA;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SubnetCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the IP address and subnet mask from the user
        System.out.print("Enter the IPv4 address: ");
        String ipAddress = scanner.nextLine();
        System.out.print("Enter the required subnet: ");
        int subnet = scanner.nextInt();

        try {
            // Calculate the subnet mask and network address
            String subnetMask = calculateSubnetMask(subnet);
            String networkAddress = calculateNetworkAddress(ipAddress, subnet);

            // Print the results
            System.out.println("Subnet Mask: " + subnetMask);
            System.out.println("Subnetwork Address: " + networkAddress);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static String calculateSubnetMask(int subnet) {
        int mask = 0xffffffff << (32 - subnet);
        return String.format("%d.%d.%d.%d",
                (mask >>> 24) & 0xff,
                (mask >>> 16) & 0xff,
                (mask >>> 8) & 0xff,
                mask & 0xff);
    }

    private static String calculateNetworkAddress(String ipAddress, int subnet) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName(ipAddress);
        byte[] ipBytes = ip.getAddress();
        int ipInt = ((ipBytes[0] & 0xFF) << 24) | ((ipBytes[1] & 0xFF) << 16) | ((ipBytes[2] & 0xFF) << 8) | (ipBytes[3] & 0xFF);
        int mask = 0xffffffff << (32 - subnet);
        int network = ipInt & mask;

        return String.format("%d.%d.%d.%d",
                (network >>> 24) & 0xff,
                (network >>> 16) & 0xff,
                (network >>> 8) & 0xff,
                network & 0xff);
    }
}
