import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostName, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Server, I am your client !!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Server response: " + response);  

        } catch (UnknownHostException ex) {
            System.out.println("Server UnknownHostException " + ex.getMessage());
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("Server IOException " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}
