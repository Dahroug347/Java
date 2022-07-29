
package serverPkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dahroug
 */
public class ServerSha8al 
{
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream ps;

    public ServerSha8al() {
        try {
            myServerSocket = new ServerSocket(50000);
            while (true) {
                Socket s = myServerSocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException ex) {
            System.out.println("IOException Detected");
        }

    }
    public static void main(String args[]){
        new ServerSha8al();
    }
}
