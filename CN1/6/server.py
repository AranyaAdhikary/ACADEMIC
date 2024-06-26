import socket
import datetime

server_ip = '127.0.0.1'
server_port = 12345

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((server_ip, server_port))
server_socket.listen()
print("Server is listening on", server_ip, "port", server_port)

while True:
    client_socket, client_address = server_socket.accept()
    print("Client connected from", client_address)

    request = client_socket.recv(1024).decode()
    if request == "GET date-time":
        current_datetime = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        response = current_datetime.encode()
        client_socket.sendall(response)

    client_socket.close()

