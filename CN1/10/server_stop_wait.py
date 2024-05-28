import socket

sender_ip = '127.0.0.1'
sender_port = 12345

sender_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sender_socket.bind((sender_ip, sender_port))

sender_socket.listen()
i=1
message = "Data"
while True:
    receiver_socket, receiver_address = sender_socket.accept()
    print("Receiver connected from", receiver_address)
    data=message+str(i)
    print("Sending : ",data)
    receiver_socket.sendall(data.encode())
    response = receiver_socket.recv(1024).decode()
    print('Received : ',response)
    receiver_socket.close()
    i=i+1


