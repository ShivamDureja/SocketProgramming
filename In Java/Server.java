import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket()) {
            System.out.println("Server is listening to port " + port);

            while (true) {
                Socket clienSocket = serverSocket.accept();
                System.out.println("New Client Connected!!");

                new ClientHandler(clienSocket).run();
            }
        } catch (IOException ex) {
            System.out.println("Server Exception " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}