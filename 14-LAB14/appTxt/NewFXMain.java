/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTxt;


import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author dahroug
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text txt = new Text("Hello World");
        txt.setId("t1");
        Reflection r = new Reflection();
        r.setFraction(0.7);
        txt.setEffect(r);
        Rectangle r1 = new Rectangle(0,0,300,250);
        r1.setId("r1");
        StackPane root = new StackPane();
        
        root.getChildren().add(r1);
        root.getChildren().add(txt);
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/cssFile/textStyle.css").toExternalForm());
        
        primaryStage.setTitle("Hello World!");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
