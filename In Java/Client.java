import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        // need to provide hostname with port in client side
        String hostName = "localhost";
        int port = 8080;
        // creates new client socket object
        try (Socket socket = new Socket(hostName, port)) {
            // socket.getOutputStream() : recieves output stream from server to client
            // PrintWriter ensures byte stream gets converted to character stream
            // lushing ensures that the data is immediately sent over the network, making it
            // useful for real-time communication.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Server, I am your client !!");
            // socket.getInputStream() : recieves the bytes coming from the client
            // new InputStreamReader(socket.getInputStream()) : to convert bytes stream to
            // characters stream
            // Buffered Reader for high level abstraction to get text from character based
            // stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Server says: " + response);

        } catch (UnknownHostException ex) {
            System.out.println("Server UnknownHostException " + ex.getMessage());
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("Server IOException " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}
