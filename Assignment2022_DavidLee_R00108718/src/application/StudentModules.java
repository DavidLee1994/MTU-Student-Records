	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application;

import java.io.IOException;

import javafx.animation.PauseTransition;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class StudentModules extends Tab {
	
	private Label studentLbl, moduleLbl, gradeLbl;
	private ChoiceBox studentDrop;
	private TextField moduleField, gradeField;
	private Alert added, removed;
	private Button reloadBtn, saveBtn, removeBtn, exitBtn;
	private BorderPane bpane;
	private HBox hbox1, hbox2, hbox3, hbox4;
	private VBox vbox;
	private PauseTransition pause;
	
	private static Controller studCont = new Controller();
	
	public StudentModules() {
		
		setText("Add/Remove Modules");
		
		//Label
		studentLbl = new Label("Pick a Student:");
		moduleLbl = new Label("Enter Module:");
		gradeLbl = new Label("Enter Grade:");
		
		//ObservableList
		ObservableList<String> studList = FXCollections.observableArrayList(studCont.getListStudent());
		
		//ChoiceBox
		studentDrop = new ChoiceBox();
		studentDrop.setPrefWidth(200);
		studentDrop.setItems(studList);
//		studentDrop.getItems().add(studCont.studentComboList());
		
		//TextField
		moduleField = new TextField();
		moduleField.setPrefWidth(300);
		gradeField = new TextField();
		gradeField.setPrefWidth(100);
		
		//AlertBox
		added = new Alert(AlertType.INFORMATION);
		added.setTitle("Module and Grade added");
		added.setContentText("Module and Grade has been added");
		removed = new Alert(AlertType.INFORMATION);
		removed.setTitle("Module and Grade removed");
		removed.setContentText("Module and Grade has been removed");
		
		//PauseTransition
		pause = new PauseTransition(Duration.seconds(5));
		
		//AddButton
		saveBtn = new Button("Add");
		 saveBtn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	studCont.addModule(studentDrop.getSelectionModel().getSelectedIndex(), moduleField.getText(), Double.parseDouble(moduleField.getText()));
	            	moduleField.clear();
	            	gradeField.clear();
	            	added.show();
	            	pause.play();
	            }
		 });
		//RemoveButton
		removeBtn = new Button("Remove");
		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	studCont.removeModule(studentDrop.getSelectionModel().getSelectedIndex(), moduleField.getText(), Double.parseDouble(moduleField.getText()));
            	moduleField.clear();
            	gradeField.clear();
            	removed.show();
            	pause.play();
            }
	 });
		
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
		
		//HBox
		hbox1 = new HBox();
		hbox2 = new HBox();
		hbox3 = new HBox();
		hbox4 = new HBox();
		hbox1.getChildren().addAll(studentLbl, studentDrop, reloadBtn);
		hbox1.setSpacing(20);
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox2.getChildren().addAll(moduleLbl, moduleField);
		hbox2.setSpacing(23);
		hbox2.setAlignment(Pos.CENTER_LEFT);
		hbox3.getChildren().addAll(gradeLbl, gradeField);
		hbox3.setSpacing(33);
		hbox3.setAlignment(Pos.CENTER_LEFT);
		hbox4.getChildren().addAll(saveBtn, removeBtn, exitBtn);
		hbox4.setSpacing(15);
		hbox4.setAlignment(Pos.CENTER);
		
		//VBox
		vbox = new VBox(20);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
		vbox.setPadding(new Insets (30, 30, 30, 30));
		
		//BoarderPane
		bpane = new BorderPane();
		bpane.setCenter(vbox);
		
		setContent(bpane);
	}
}
