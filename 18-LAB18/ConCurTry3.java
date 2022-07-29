/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxConCurrency3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dahroug
 */
public class ConCurTry3 extends Application 
{
    TextArea textArea = new TextArea();
    Label statusLabel = new Label("Not Started...");
    
    Button startButton = new Button("Start");
    Button exitButton = new Button("Exit");
    
    @Override
    public void start(final Stage stage) 
    {
       startButton.setOnAction((ActionEvent event) -> 
       {
           startTask();
       });
       
       exitButton.setOnAction((ActionEvent event) -> 
       {
           stage.close();
       });
       
       HBox buttonBox = new HBox(5, startButton, exitButton);
        VBox vbox = new VBox(10, statusLabel, buttonBox, textArea);
        Scene scene = new Scene(vbox, 300, 300);
        stage.setTitle("Concurrency task 3");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }

    public void runTask() 
    {
       for (int i = 1; i<= 10; i++)
       {
           try
           {
               final String status  = "Processing " + i + " of " + 10;
               
               Platform.runLater (() -> 
               {
                  statusLabel.setText(status);
                  textArea.appendText(status + "\n");
               });

               System.out.println(status);
               Thread.sleep(1000);
           }
           catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
       }
    }
    
    public void startTask ()
    {
        Runnable task;
        task = () -> {
            runTask();
         };
        
        Thread backgroundThread;    
        backgroundThread = new Thread(task);
        
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
    
}
