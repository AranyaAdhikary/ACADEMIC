package JAVA;
import java.util.Scanner;

public class SlidingWindow_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for window size
        System.out.print("Enter the window size: ");
        int windowSize = scanner.nextInt();

        // Prompt user for number of frames to transmit
        System.out.print("Enter the number of frames to transmit: ");
        int numberOfFrames = scanner.nextInt();

        // Create an array to store the frames
        int[] frames = new int[numberOfFrames];
        
        // Allow user to enter the frames
        System.out.println("Enter the frames:");
        for (int i = 0; i < numberOfFrames; i++) {
            System.out.print("Frame " + (i + 1) + ": ");
            frames[i] = scanner.nextInt();
        }

        // Simulate sending frames in windows
        int ack = 0;
        while (ack < numberOfFrames) {
            // Send frames in the current window
            System.out.println("Sending frames:");
            for (int i = ack; i < ack + windowSize && i < numberOfFrames; i++) {
                System.out.println("Sent frame: " + frames[i]);
            }

            // Simulate waiting for acknowledgment
            System.out.println("Waiting for acknowledgment...");

            // In a real scenario, here we'd check for actual acknowledgments.
            // For simulation, assume all frames in the window are acknowledged.
            int acksReceived = Math.min(windowSize, numberOfFrames - ack);
            for (int i = 0; i < acksReceived; i++) {
                System.out.println("Acknowledgment received for frame: " + frames[ack + i]);
            }

            // Move the acknowledgment pointer
            ack += acksReceived;
        }

        System.out.println("All frames have been sent and acknowledged.");
        scanner.close();
    }
}
