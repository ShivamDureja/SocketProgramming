import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run(int c) throws IOException {
        String text = "Dummy text from Client Number " + c;
        int count = 0;
        do {
            count++;
            System.out.println("Recieved message from Client Number " + c + " : " + text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread Connection Interrupted " + ex.getMessage());
            }
            System.out.println("Thanks " + c);
        } while (count < 5);

        this.socket.close();
    }
}
