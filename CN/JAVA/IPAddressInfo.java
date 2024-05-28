package JAVA;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPAddressInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the IP address (dotted decimal or binary): ");
        String input = scanner.nextLine();

        try {
            String ipAddress;
            if (input.contains(".")) {
                // Input is in dotted decimal format
                ipAddress = input;
            } else {
                // Input is in binary format
                ipAddress = convertBinaryToDottedDecimal(input);
            }

            String ipClass = getIPClass(ipAddress);
            String networkAddress = getNetworkAddress(ipAddress, ipClass);

            System.out.println("IP Address: " + ipAddress);
            System.out.println("Class: " + ipClass);
            System.out.println("Network Address: " + networkAddress);
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static String convertBinaryToDottedDecimal(String binaryInput) {
        if (binaryInput.length() != 32) {
            throw new IllegalArgumentException("Invalid binary IP address length.");
        }

        StringBuilder dottedDecimal = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String binaryOctet = binaryInput.substring(i * 8, (i + 1) * 8);
            int decimalOctet = Integer.parseInt(binaryOctet, 2);
            dottedDecimal.append(decimalOctet);
            if (i < 3) {
                dottedDecimal.append(".");
            }
        }
        return dottedDecimal.toString();
    }

    private static String getIPClass(String ipAddress) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        byte[] bytes = inetAddress.getAddress();
        int firstOctet = bytes[0] & 0xFF;

        if (firstOctet >= 0 && firstOctet <= 127) {
            return "A";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return "B";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return "C";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return "D";
        } else {
            return "E";
        }
    }

    private static String getNetworkAddress(String ipAddress, String ipClass) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        byte[] bytes = inetAddress.getAddress();

        if (ipClass.equals("A")) {
            return (bytes[0] & 0xFF) + ".0.0.0";
        } else if (ipClass.equals("B")) {
            return (bytes[0] & 0xFF) + "." + (bytes[1] & 0xFF) + ".0.0";
        } else if (ipClass.equals("C")) {
            return (bytes[0] & 0xFF) + "." + (bytes[1] & 0xFF) + "." + (bytes[2] & 0xFF) + ".0";
        } else {
            return "Not applicable for Class " + ipClass;
        }
    }
}

