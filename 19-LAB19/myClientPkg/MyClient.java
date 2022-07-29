
package myClientPkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahroug
 */
public class MyClient 
{
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    
    public MyClient()
    {
        try
        {
            mySocket = new Socket ("127.0.0.1", 8080);
            dis = new DataInputStream (mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println ("Hello From Client");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
            ps.close();
            dis.close();
            mySocket.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main (String[] args)
    {
        new MyClient();
    }
}
