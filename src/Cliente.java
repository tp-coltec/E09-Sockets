import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        try {
            Socket client = new Socket("localhost", 5000);
            ObjectOutputStream outData = new ObjectOutputStream(client.getOutputStream());
            outData.flush();
            outData.writeUTF(stdin.nextLine());
            outData.close();
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
