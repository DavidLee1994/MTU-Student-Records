	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 08/Apr/22
	 */

package application;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Side;


public class Main extends Application {
	

	private TabPane tp;
		
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//Title
        primaryStage.setTitle("MTU Student Record System");
        
        //TabPane
        tp = new TabPane();
        tp.setSide(Side.TOP);
        tp.getTabs().add(new StudentDetails());
        tp.getTabs().add(new StudentModules());
        tp.getTabs().add(new StudentRecords());
        tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
       

	    
        StackPane root = new StackPane();
        root.getChildren().addAll(tp);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show(); 
    }
}