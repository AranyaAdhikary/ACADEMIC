package JAVA;
import java.util.Scanner;

public class CRC_Sender {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the data bits: ");
        String data = scanner.nextLine();

        System.out.print("Enter the polynomial: ");
        String polynomial = scanner.nextLine();

        String encodedData = encodeData(data, polynomial);

        System.out.println("Encoded data to be transmitted: " + encodedData);
    }

    private static String encodeData(String data, String polynomial) {
        int dataBitsLength = data.length();
        int polyBitsLength = polynomial.length();

        // Append zeros to the data
        String augmentedData = data + "0".repeat(polyBitsLength - 1);

        String remainder = divide(augmentedData, polynomial);

        return data + remainder;
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

