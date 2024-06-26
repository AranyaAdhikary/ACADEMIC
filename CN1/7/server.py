import socket

server_ip = '127.0.0.1'
server_port = 12345

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((server_ip, server_port))

server_socket.listen()

print("Echo Server is listening on", server_ip, "port", server_port)

while True:
    client_socket, client_address = server_socket.accept()
    print("Client connected from", client_address)

    message = client_socket.recv(1024).decode()
    print(message)
    client_socket.sendall(message.encode())
    client_socket.close()


