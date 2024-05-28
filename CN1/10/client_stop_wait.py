import socket

sender_ip = '127.0.0.1'
sender_port = 12345

receiver_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
receiver_socket.connect((sender_ip, sender_port))

message = "Acknowledgment"

response = receiver_socket.recv(1024).decode()
print("Received : ",response)
if response.startswith('Data') == True:
    ack = message+response[len(response)-1]
    receiver_socket.sendall(ack.encode())

receiver_socket.close()
