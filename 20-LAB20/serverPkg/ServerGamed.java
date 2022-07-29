/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dahroug
 */
public class ServerGamed //implements Runnable
{
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;

              
     //myServerSocket.close();
   
    public ServerGamed () throws IOException 
  {    
      
          
          myServerSocket = new ServerSocket(2000);
          
          
          while (true)
          {
              try {
                  s = myServerSocket.accept();
                  
              } catch (IOException ex) {
                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
              }
                new ChatHandler(s);
//              try {
//                  dis.close();
//              } catch (IOException ex) {
//                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
//              }
//              try {
//                  s.close();
//              } catch (IOException ex) {
//                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
//              }
              
          } 
         
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        ServerGamed myServer = new ServerGamed();    
    }
    
}
