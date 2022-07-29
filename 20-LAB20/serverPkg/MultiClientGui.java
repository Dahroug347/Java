/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPkg;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Dahroug
 */
public class MultiClientGui extends Application{
    
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    TextArea ta;
    TextField tf;
    Button bt , save, open;
    Label lb;
        
    
    @Override
    public  void init() throws IOException
    { 
 
        ta = new TextArea();
        ta.setEditable(false);
        tf = new TextField();
        bt = new Button("Send");
        save = new Button ("Save");
        open = new Button ("Open");
        bt.setDefaultButton(true);
        ta.appendText("Chat Messages :");
        tf.setPromptText("Enter your message");
        lb = new Label("Enter your Message");
        try{
        mySocket = new Socket("127.0.0.1", 2000);
        dis = new DataInputStream(mySocket.getInputStream());
        ps = new PrintStream(mySocket.getOutputStream());
                          }catch (IOException ex) {             
            Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex); 
                    } 
        
        



    }

    @Override
    public void start(Stage primaryStage) {
        bt.setOnAction ( ae -> {
            ps.println(tf.getText());
            tf.setText("");
        });
        
         save.setOnAction ( ae -> {
            FileChooser fc = new FileChooser();

            FileChooser.ExtensionFilter exf = new FileChooser.ExtensionFilter("ALL files (*.*)", "*.*");
            fc.getExtensionFilters().add(exf);
            File f = fc.showSaveDialog(primaryStage);
            
            
            FileWriter writer = null;
            if ( f != null)
            {
                try {
                     writer = new FileWriter (f);
                } catch (IOException ex) {
                    Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter buffer = new BufferedWriter(writer);
                try {
                    buffer.write(ta.getText());
                } catch (IOException ex) {
                    Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    buffer.close();
                } catch (IOException ex) {
                    Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                 System.out.println(" No file found ");
        });
         
          open.setOnAction ( ae -> {
            ps.println(tf.getText());
            tf.setText("");
        });
        
        
        HBox tbox = new HBox(save, open);
        HBox hbox = new HBox( lb, tf, bt);
        
        BorderPane bp = new BorderPane();
        bp.setTop(tbox);
        bp.setCenter(ta);
        bp.setBottom(hbox);
        
        Scene sc = new Scene(bp,372,300);
        
        
        new Thread (() -> {
            while(true){
                String replyMsg;
                try{
                    replyMsg = dis.readLine();
                    ta.appendText("\n"+replyMsg);
                }catch (IOException ex) {
                    Logger.getLogger(MultiClientGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        
        
        primaryStage.setScene(sc);
        primaryStage.setTitle("Chat Client");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        //launch(args);
        
    }
    
}