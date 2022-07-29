
package serverPkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahroug
 */
public class ChatHandler extends Thread
{
    DataInputStream dis;
    PrintStream ps;
    
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    
    public ChatHandler (Socket cs)
    {
        try
        {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream (cs.getOutputStream());
            clientsVector.add(this);
            start();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void sendMessageToAll(String msg)
    {

        for (ChatHandler ch : clientsVector)
        {
            ch.ps.println("Client "+ (clientsVector.indexOf(ch)+1) + ": "+msg + " ");
        }
    }
    
    @Override
    public void run ()
    {
        while (true)
        {
            try
            {
                String str = dis.readLine();
                System.out.println(str);
                sendMessageToAll(str);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
