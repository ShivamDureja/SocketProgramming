import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening to port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected!!");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());

                    String clientMessage = in.readLine();
                    System.out.println("Message recieved from client :  " + clientMessage);
                    out.println("Echo from server: " + clientMessage);

                }
            }
        }
        // try (ServerSocket serverSocket = new ServerSocket(port)) {
        // System.out.println("Server is listening to port " + port);
        // int count = 0;
        // while (true) {
        // Socket clienSocket = serverSocket.accept();
        // System.out.println("New Client Connected!!, count " + count);

        // new ClientHandler(clienSocket).run(count);
        // }
        catch (IOException ex) {
            System.out.println("Server Exception " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}