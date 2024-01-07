import socket

host = "localhost"
port = 8082

client_socket = socket.socket()

client_socket.connect((host,port))

# sending data to server and need to pass bytes data
client_socket.sendall(b"Hii server, this is your client!!")

datafromserver = client_socket.recv(2048)

print("Server response: ", datafromserver)