import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Port Number for server to listen on
        int port = 8080;
        // creates a new server to listen incoming requests
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening to port " + port);
            // To keep server running we used infinite while loop
            while (true) {
                // accept a new client connection and create a socket object
                Socket socket = serverSocket.accept();
                // To confirm if client is connected
                System.out.println("New Client Connected!!");
                // socket.getInputStream() : recieves the bytes coming from the client
                // new InputStreamReader(socket.getInputStream()) : to convert bytes stream to
                // characters stream
                // Buffered Reader for high level abstraction to get text from character based
                // stream
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    // get the text message from client
                    String clientMessage = in.readLine();
                    System.out.println("Message recieved from client :  " + clientMessage);
                    // sends a message back to the client
                    out.println("Echo from server: " + clientMessage);

                }
            }
        } catch (IOException ex) {
            System.out.println("Server Exception " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}