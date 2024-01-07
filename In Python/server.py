import socket
import time 
import threading

print("Starting a new server!!")

def connect_a_client(conn,add):
    print("New client connection established")
    data = conn.recv(2048)
    print("Data from client", data)
    time.sleep(10)
    conn.sendall(b"I have received data from you")
    conn.close()
    
host = "localhost"
port = 8082

# create a socket object
server_socket = socket.socket()

# bind to a port. It takes a tuple
server_socket.bind((host,port))

# listening incoming requests
server_socket.listen()

print("server is listening!!")

while True:
    # accepting new connections
    conn, addr = server_socket.accept() 
    # need to call this method on new thread
    t = threading.Thread(target=connect_a_client, args=(conn,addr))
    t.start()
