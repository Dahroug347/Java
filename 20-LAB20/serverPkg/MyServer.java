/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
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
public class MyServer extends Application implements Runnable
{
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    
    @Override
    public void init() throws IOException
    {   
          dis = new DataInputStream(s.getInputStream());
          ps = new PrintStream(s.getOutputStream());
          myServerSocket = new ServerSocket(50000);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
       
        
//        primaryStage.setOnCloseRequest(event -> {
//            
//            try 
//            {
//                myServerSocket.close();
//            } 
//            catch (IOException ex) 
//            {
//                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                });
    }
    
    
    public MyServer () 
  {    
          while (true)
          {
              try {
                  s = myServerSocket.accept();
              } catch (IOException ex) {
                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
              }
              new ChatHandler(s);
              
              ps.close();
              try {
                  dis.close();
              } catch (IOException ex) {
                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
              }
              try {
                  s.close();
              } catch (IOException ex) {
                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          } 
          
    }
   
    
    @Override
    public void run()
      {
          while (true)
          {
              try
              {
              String msg = dis.readLine();
              System.out.println(msg);
              } 
              catch (IOException ex) 
              {
                  Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MyServer myServer = new MyServer();
        launch(args);
        
    }
    
}
