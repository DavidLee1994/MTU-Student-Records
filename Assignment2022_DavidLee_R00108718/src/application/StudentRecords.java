	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StudentRecords extends Tab {
	
	private Label studentLbl;
	private ChoiceBox studentDrop;
	private TextArea studentArea;
	private TableView recordsView;
	private TableColumn moduleCol, gradeCol, pass_failCol;
	private Button reloadBtn, loadBtn, exitBtn;
	private HBox hbox1, hbox2, hbox3, hbox4, hbox5;
	private VBox vbox;
	
	private static Controller studCont = new Controller();
	
	public StudentRecords() {
		
		setText("Student Records");
		
		//Label
		studentLbl = new Label("Student:");
		
		//ObservableList
		ObservableList<String> studList = FXCollections.observableArrayList(studCont.getListStudent());
		
		//ChoiceBox
		studentDrop = new ChoiceBox();
		studentDrop.setPrefWidth(250);
		studentDrop.setItems(studList);
		
		//TextArea
		studentArea = new TextArea();
		studentArea.setEditable(false);
		studentArea.setPrefHeight(20);
		
		//Table
		recordsView = new TableView();
		recordsView.setEditable(false);
		moduleCol = new TableColumn("Module");
		gradeCol = new TableColumn("Grade");
		pass_failCol = new TableColumn("Pass/Fail");
		moduleCol.setPrefWidth(310);
		gradeCol.setPrefWidth(50);
		pass_failCol.setPrefWidth(80);
		recordsView.getColumns().addAll(moduleCol, gradeCol, pass_failCol);
		recordsView.setPrefWidth(440);
				
		//LoadButton
		loadBtn = new Button("Load");
		
		//ExitButton
		exitBtn = new Button("Exit");
		exitBtn.setText("Exit"); 
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Alert alert = new Alert(AlertType.CONFIRMATION);
            	alert.setTitle("Exit");
            	alert.setContentText("Do you want to save before exit?");
            	alert.showAndWait();
            	if(alert.getResult() == ButtonType.OK) {
            		try {
    					studCont.saveStudentCSV();
                		Platform.exit();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
            		Platform.exit();
            	}
            	else if(alert.getResult() == ButtonType.CANCEL) {
            		Platform.exit();
            	}
            }
        });
		
		//ReloadButton
		reloadBtn = new Button("Reload List");
		reloadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	studentDrop.getItems().clear();
            	studentDrop.setItems(studList);
            }});
		
		//ExitButton
		exitBtn = new Button();
		exitBtn.setText("Exit"); 
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Alert alert = new Alert(AlertType.CONFIRMATION);
            	alert.setTitle("Exit");
            	alert.setContentText("Do you want to save before exit?");
            	alert.showAndWait();
            	if(alert.getResult() == ButtonType.OK) {
            		try {
    					studCont.saveStudentCSV();
                		Platform.exit();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
            		Platform.exit();
            	}
            	else if(alert.getResult() == ButtonType.CANCEL) {
            		Platform.exit();
            	}
            }
        });
		
		//HBox
		hbox1 = new HBox();
		hbox2 = new HBox();
		hbox3 = new HBox();
		hbox4 = new HBox();
		hbox5 = new HBox();
		hbox1.getChildren().addAll(studentLbl, studentDrop, reloadBtn);
		hbox1.setSpacing(20);
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox2.getChildren().add(loadBtn);
		hbox2.setSpacing(50);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.getChildren().add(studentArea);
		hbox3.setSpacing(50);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(recordsView);
		hbox4.setSpacing(50);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.getChildren().add(exitBtn);
		hbox5.setSpacing(50);
		hbox5.setAlignment(Pos.CENTER_RIGHT);
		
		//VBox
		vbox = new VBox(10);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5);
		vbox.setPadding(new Insets (30, 30, 30, 30));
		
		setContent(vbox);
		
	}
	
}
