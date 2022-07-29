
package clientServerApp;

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
public class MyServer 
{
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;


  public MyServer ()
  {
      try
      {
          myServerSocket = new ServerSocket (50000);
          s = myServerSocket.accept();
          dis = new DataInputStream(s.getInputStream());
          ps = new PrintStream(s.getOutputStream());
          String msg = dis.readLine();
          System.out.println(msg);
          ps.println("Hi From Server");
          ps.close();
          dis.close();
          s.close();
          myServerSocket.close();
      } 
      catch (IOException ex) 
      {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    public static void main (String[] args)
    {
        new MyServer();
    }
}
