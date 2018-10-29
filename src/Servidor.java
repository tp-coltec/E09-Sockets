import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Listening...");
            while(true) {
                Socket client = server.accept();
                System.out.println("Connected at: " + client.getInetAddress().getHostAddress());

                ObjectInputStream inData = new ObjectInputStream(client.getInputStream());
                String data = inData.readUTF();
                System.out.println("Received: " + data);
                inData.close();

                if(data.equals("shutdown")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
