package JAVA;
import java.util.Scanner;

public class CRC_Receiver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the received data bits: ");
        String receivedData = scanner.nextLine();

        System.out.print("Enter the polynomial: ");
        String polynomial = scanner.nextLine();

        boolean isErrorFree = checkForErrors(receivedData, polynomial);

        if (isErrorFree) {
            System.out.println("No error detected in the received data.");
        } else {
            System.out.println("Error detected in the received data.");
        }
    }

    private static boolean checkForErrors(String receivedData, String polynomial) {
        String remainder = divide(receivedData, polynomial);

        return remainder.chars().allMatch(c -> c == '0');
    }

    private static String divide(String data, String polynomial) {
        int dataBitsLength = data.length();
        int polyBitsLength = polynomial.length();

        char[] dataBits = data.toCharArray();
        char[] polyBits = polynomial.toCharArray();

        for (int i = 0; i <= dataBitsLength - polyBitsLength; i++) {
            if (dataBits[i] == '1') {
                for (int j = 0; j < polyBitsLength; j++) {
                    dataBits[i + j] = (char) ((dataBits[i + j] - '0') ^ (polyBits[j] - '0') + '0');
                }
            }
        }

        String remainder = new String(dataBits, dataBitsLength - polyBitsLength + 1, polyBitsLength - 1);
        return remainder;
    }
}

