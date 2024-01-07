import socket

print("Starting a new server!!")


host = "localhost"
port = 8082

# create a socket object
server_socket = socket.socket()

# bind to a port. It takes a tuple
server_socket.bind((host,port))

# listening incoming requests
server_socket.listen()

print("server is listening!!")

# accepting new connections
conn, addr = server_socket.accept() 

print("Connection Established!!")

# receive data from client
datareceived = conn.recv(2048)

print("Data from Client: ", datareceived)

conn.sendall(b"I have received data from you")
conn.close()
server_socket.close()