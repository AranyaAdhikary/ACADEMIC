# 2) Possible Question

"""Write a program to simulate the Sliding Window Protocol in a network transmission. Implement the following features:
1. Prompt the user to enter the window size.
2. Prompt the user to enter the number of frames to transmit.
3. Allow the user to enter the frames.
4. Simulate the sending of frames in windows, where the sender sends a window of frames and waits for an acknowledgment before sending the next window of frames.
5. Print the frames being sent and when the acknowledgment for those frames is received.
"""

def main():
    w = int(input("Enter window size: "))
    
    f = int(input("Enter number of frames to transmit: "))
    
    frames = []
    print(f"Enter {f} frames: ")
    for i in range(f):
        frames.append(int(input()))
    
    print("\nWith sliding window protocol, the frames will be sent in the following way (assuming no corruption of frames):")
    
    i = 0
    while i < f:
        print(f"\nSending frames: {frames[i:i+w]}")
        if (i + w) <= f:
            print("Acknowledgement of above frames sent is received by sender\n")
        else:
            print("Acknowledgement of above frames sent is received by sender\n")
        
        i += w

if __name__ == "__main__":
    main()