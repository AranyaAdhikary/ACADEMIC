def ip_to_binary(ip):
    return ''.join([bin(int(octet)).lstrip('0b').zfill(8) for octet in ip.split('.')])

def binary_to_ip(binary_ip):
    return '.'.join([str(int(binary_ip[i:i+8], 2)) for i in range(0, len(binary_ip), 8)])

def get_class_and_network(ip):
    if '.' in ip:
        first_octet = int(ip.split('.')[0])
    else:
        first_octet = int(ip[:8], 2)

    if first_octet >= 0 and first_octet <= 127:
        ip_class = 'A'
        network_address = ip.split('.')[0] + '.0.0.0'
    elif first_octet >= 128 and first_octet <= 191:
        ip_class = 'B'
        network_address = '.'.join(ip.split('.')[:2]) + '.0.0'
    elif first_octet >= 192 and first_octet <= 223:
        ip_class = 'C'
        network_address = '.'.join(ip.split('.')[:3]) + '.0'
    elif first_octet >= 224 and first_octet <= 239:
        ip_class = 'D'
        network_address = 'Not applicable'
    elif first_octet >= 240 and first_octet <= 255:
        ip_class = 'E'
        network_address = 'Not applicable'
    else:
        ip_class = 'Unknown'
        network_address = 'Unknown'

    return ip_class, network_address

def main():
    ip_input = input("Enter an IP address (in dotted decimal or binary format): ")

    if '.' in ip_input:
        if all(part.isdigit() for part in ip_input.split('.')):
            if all(0 <= int(part) <= 255 for part in ip_input.split('.')):
                ip_decimal = ip_input
                ip_binary = ip_to_binary(ip_input)
            else:
                print("Invalid IP address.")
                return
        else:
            print("Invalid IP address.")
            return
    else:
        try:
            if len(ip_input) == 32 and all(char in '01' for char in ip_input):
                ip_binary = ip_input
                ip_decimal = binary_to_ip(ip_input)
            else:
                print("Invalid IP address.")
                return
        except:
            print("Invalid IP address.")
            return

    ip_class, network_address = get_class_and_network(ip_decimal)

    print(f"IP Address in dotted decimal format: {ip_decimal}")
    print(f"IP Address in binary format: {ip_binary}")
    print(f"Class: {ip_class}")
    print(f"Network Address: {network_address}")

if __name__ == "__main__":
    main()
