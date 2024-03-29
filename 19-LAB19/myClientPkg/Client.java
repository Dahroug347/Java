/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myClientPkg;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


/**
 *
 * @author Mo Sharshar
 */

public class Client extends Application {
    
    MenuBar bar;
    Menu menu;
    MenuItem openFile,saveFile;
    TextArea textArea;
    Text text;
    TextField textField;
    Button btn;
    FlowPane flowPane;
    BorderPane pane;
    Scene scene;
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    
    @Override
    public void init() {
        
        bar = new MenuBar();
        menu = new Menu("File");

        openFile = new MenuItem("Open Chat");
        saveFile = new MenuItem("Save Chat");

        menu.getItems().setAll(openFile,saveFile);
        bar.getMenus().setAll(menu);

        textArea = new TextArea();
        textArea.setText("Chat Messages:\n");
        textArea.setEditable(false);

        text = new Text("Enter your Message");

        textField = new TextField();
        textField.setPromptText("Enter Text Here");

        btn = new Button("Send");
        btn.setDefaultButton(true);

        flowPane = new FlowPane(text,textField,btn);

        pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(textArea);
        pane.setBottom(flowPane);

        
        try {
            mySocket = new Socket("197.60.181.212", 2000);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                ps.println("Dahroug: " + textField.getText());
                textField.setText("");
            }
        });
        
        new Thread(new Runnable() {
           public void run() {
                while(true) {
                    String msgrply;
                    try {
                        msgrply=dis.readLine();
                        textArea.appendText("\n"+ msgrply);
                        
                    } catch (IOException ex) {
                        ex.getStackTrace();
                    }
                }
            }
        }).start();
    }
    
    @Override
    public void start(Stage stage) {
        scene = new Scene(pane,300,400);
        stage.setTitle("Chat Client");
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        openFile.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open file");
                    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
                    textArea.clear();
                    String s=fileChooser.showOpenDialog(stage).getAbsolutePath();
                    try {
                        File f = new File(s);
                        FileReader fr = new FileReader(f);
                        char[] c = new char[(int)f.length()];
                        fr.read(c);
                        String str=new String(c);
                        textArea.setText(str);
                        stage.setTitle(f.getName());
                        fr.close();
                    } catch (Exception ex) {
                        ex.getStackTrace();
                    } 
                    }
                }
            );


      //Creating Save file chooser
      saveFile.setOnAction(ActionEvent->{
         FileChooser fc = new FileChooser();
         FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("txt files", "*.txt");
         File fileSaved = fc.showSaveDialog(null);
         try{
             FileWriter fw = new FileWriter(fileSaved);
             fw.write(textArea.getText());
             fw.close();
             stage.setTitle(fileSaved.getName());
         } catch(Exception ex){
             System.out.println(ex.getMessage());
         }
      });

        
    }
               

//    @Override
//    public void stop() throws Exception {
//        Platform.exit();
//        super.stop(); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
