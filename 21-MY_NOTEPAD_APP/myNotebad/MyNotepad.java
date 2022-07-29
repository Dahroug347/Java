/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myNotebad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author dahroug
 */
public class MyNotepad extends Application 
{
    MenuBar bar;
    
    Menu file;
    Menu edit;
    Menu help;
         
    MenuItem New;
    MenuItem Open;
    MenuItem Save;
    SeparatorMenuItem itemSF;
    MenuItem Exit;
    
    MenuItem Undo;
    SeparatorMenuItem item1SE;
    MenuItem Cut;
    MenuItem Copy;
    MenuItem Paste;
    MenuItem Delete;
    SeparatorMenuItem item2SE;
    MenuItem selectAll;
    
    MenuItem about;
    MenuItem compile;
    
    TextArea textArea;
    
    
    
    BorderPane pane;
    
    Scene scene;
    
    @Override
    public void init()
    {
        bar = new MenuBar();
        
        file = new Menu("File");
        edit = new Menu("Edit");
        help = new Menu("Help");
        
        New = new MenuItem("New");
        New.setAccelerator(KeyCombination.keyCombination("Ctrl+q"));
        
        Open = new MenuItem("Open...");
        Save = new MenuItem("Save");
        itemSF = new SeparatorMenuItem();
        
        Exit = new MenuItem("Exit");
        //item5F.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
        
        Undo = new MenuItem("Undo");
        Undo.setAccelerator(KeyCombination.keyCombination("Ctrl+z"));
        
        item1SE = new SeparatorMenuItem();
        
        Cut = new MenuItem("Cut");
        Cut.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        
        Copy = new MenuItem("Copy");
        Copy.setAccelerator(KeyCombination.keyCombination("Ctrl+c"));
        
        Paste = new MenuItem("Paste");
        Paste.setAccelerator(KeyCombination.keyCombination("Ctrl+v"));
        
        Delete = new MenuItem("Delete");
        
        item2SE = new SeparatorMenuItem();
        
        selectAll = new MenuItem("Select All");
        selectAll.setAccelerator(KeyCombination.keyCombination("Ctrl+a"));
        
        about = new MenuItem("About Notepad");
        compile = new MenuItem("Compile");
        
        file.getItems().addAll(New, Open, Save, itemSF, Exit);
        edit.getItems().addAll(Undo, item1SE, Cut, Copy, Paste, Delete, item2SE, selectAll);
        help.getItems().addAll(about, compile);
                
        
        bar.getMenus().addAll(file, edit, help);
        
        textArea = new TextArea();
        
        textArea.setPrefSize(400,400);
        
        
        
        pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(textArea);
        scene = new Scene (pane, 300, 400);
        
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        New.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText(" The current file will be overwritten with a new one, press OK to continue...");

           
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                    textArea.clear();
            } 
            else {
                 } 
        });
        
        Save.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
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
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter buffer = new BufferedWriter(writer);
                try {
                    buffer.write(textArea.getText());
                } catch (IOException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    buffer.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                 System.out.println(" No file found ");
        });
        
        
        
        Open.addEventHandler(ActionEvent.ACTION, (ActionEvent event) ->
          {
            FileChooser fc = new FileChooser();

            FileChooser.ExtensionFilter exf = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fc.getExtensionFilters().add(exf);
                
            File f = fc.showOpenDialog(primaryStage);
            
            FileReader reader = null;
            if (f != null)
            {
                try {
                    reader = new FileReader(f);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedReader bufR = new BufferedReader(reader);
                String line = null;
                do 
                {
                    try {
                        line = bufR.readLine();
                        if (line != null)
                        {
                            textArea.appendText(line+"\n");
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (line != null);

                try {
                    bufR.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
                else
                 System.out.println(" No file found to Open ");
        });
        
        Exit.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText(" Are you sure you want to EXIT");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                    Platform.exit();
            } 
            else {
                 } 
            
        });
        
        Undo.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.undo();
        });
        
        Cut.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.cut();
        });
        
        Copy.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.copy();
        });
        
        Paste.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.paste();
        });
        
        Delete.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.deleteText(textArea.getSelection());
        });
        
        selectAll.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            textArea.selectAll();
        });
        
        about.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> 
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("This notepad was created by javaFX");
            alert.setHeaderText(null);
            alert.setContentText("Creator: Mahmoud Dahroug");

            alert.showAndWait();
        });
        
        primaryStage.setOnCloseRequest(event -> {
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText(" Are you sure you want to EXIT");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                    System.out.println("Stage is closing");
                    Platform.exit();
            } 
            else {
                    event.consume();
                 } 
    // Save file
                });
        
        
        primaryStage.setTitle("MY FX NOTEPAD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
  
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
