import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahroug
 */
public class ClientApp {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    
    
    public ClientApp(){
        
        try {
            mySocket = new Socket("127.0.0.1", 2000);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("Hello From Client");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
            ps.close();
            dis.close();
            mySocket.close();
                 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new ClientApp();
    }

}