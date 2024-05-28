def crc_generator(data, divisor):
    data = list(map(int, data))  # Convert data string to list of integers
    divisor = list(map(int, divisor))  # Convert divisor string to list of integers

    # Append zeros to the data to match the length of the divisor
    data += [0] * (len(divisor) - 1)
    remainder = list(data)

    # Perform CRC division
    for i in range(len(data) - len(divisor) + 1):
        if remainder[i] == 1:
            # XOR the divisor with the current remainder
            for j in range(len(divisor)):
                remainder[i + j] ^= divisor[j]

    # Return the CRC checksum
    return ''.join(map(str, remainder[-len(divisor) + 1:]))


def crc_verification(data, divisor, crc_checksum):
    data = list(map(int, data))  # Convert data string to list of integers
    divisor = list(map(int, divisor))  # Convert divisor string to list of integers

    # Append zeros to the data to match the length of the divisor
    data += [0] * (len(divisor) - 1)
    remainder = list(data)

    # Perform CRC division
    for i in range(len(data) - len(divisor) + 1):
        if remainder[i] == 1:
            # XOR the divisor with the current remainder
            for j in range(len(divisor)):
                remainder[i + j] ^= divisor[j]

    # Check if remainder matches the CRC checksum
    if remainder[-len(divisor) + 1:] == list(map(int, crc_checksum)):
        return True  # No error detected
    else:
        return False  # Error detected


def main():
    # Sender Side
    data = input("Enter the data bits to send: ")
    divisor = input("Enter the divisor bits: ")
    crc_checksum = crc_generator(data, divisor)
    print("CRC checksum generated:", crc_checksum)

    # Receiver Side
    received_data = input("Enter the received data bits: ")
    received_crc_checksum = input("Enter the received CRC checksum: ")
    if crc_verification(received_data, divisor, received_crc_checksum):
        print("No error detected.")
    else:
        print("Error detected.")


if __name__ == "__main__":
    main()
