def ip_to_binary(ip):
    return '.'.join(f'{int(octet):08b}' for octet in ip.split('.'))

def binary_to_ip(binary_ip):
    return '.'.join(str(int(octet, 2)) for octet in binary_ip.split('.'))

def get_class_and_network(ip):
    first_octet = int(ip.split('.')[0])
    
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

def validate_dotted_decimal(ip):
    parts = ip.split('.')
    if len(parts) == 4 and all(part.isdigit() and 0 <= int(part) <= 255 for part in parts):
        return True
    return False

def validate_binary_format(ip):
    parts = ip.split('.')
    if len(parts) == 4 and all(len(part) == 8 and all(char in '01' for char in part) for part in parts):
        return True
    return False

def main():
    ip_input = input("Enter an IP address (in dotted decimal or binary format): ")

    if validate_dotted_decimal(ip_input):
        ip_decimal = ip_input
        ip_binary = ip_to_binary(ip_input)
    elif validate_binary_format(ip_input):
        ip_binary = ip_input
        ip_decimal = binary_to_ip(ip_input)
    else:
        print("Invalid IP address.")
        return

    ip_class, network_address = get_class_and_network(ip_decimal)

    print(f"IP Address in dotted decimal format: {ip_decimal}")
    print(f"IP Address in binary format: {ip_binary}")
    print(f"Class: {ip_class}")
    print(f"Network Address: {network_address}")

if __name__ == "__main__":
    main()
