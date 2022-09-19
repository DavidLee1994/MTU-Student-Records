	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

public class StudentDetails extends Tab {
	
	private Label labelFName,labelLName,labelDOB,labelStudNo;
	private TextField textFFName,textFLName,textFStudNo;
	private TextArea textADisplay;
	private Button btnAdd,btnRemove,btnList,btnLoad,btnSave,btnExit;
	private ChoiceBox studentDrop;
	
	private static Controller studCont = new Controller();
	
	public StudentDetails()
	   {
	     	//TabTitle
		    setText("Student Details");
		    
		    //Label
	        labelFName = new Label("Forename: ");
	        labelLName = new Label("Surname: ");
	        labelDOB = new Label("Date Of Birth: ");
	        labelStudNo = new Label("Student Number: ");
	        
	        //TextField
	    	textFFName = new TextField();
	    	textFLName = new TextField();
	    	textFStudNo = new TextField();
	    	
	    	//TextArea
	    	textADisplay = new TextArea();
	    	textADisplay.setEditable(false);
	    	
	    	//DatePicker
	    	DatePicker dateDOB = new DatePicker();
	        
	    	//ButtonAdd
	    	LocalDate now = LocalDate.now();
	        btnAdd = new Button();
	        btnAdd.setText("Add");
	        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                textADisplay.clear();
	                if(textFFName.getLength()<2){
	                	textFFName.clear();
		        		textADisplay.setText("Please enter a valid Forename");
	                }
	                else if(textFLName.getLength()<2) {
	                	textFLName.clear();
	    	        	textADisplay.setText("Please enter a valid Surname");
	                }
	                else if(dateDOB.getValue().isAfter(now.minusYears(17))) {
		        		dateDOB.setValue(null);
	    	        	textADisplay.setText("Please enter a valid Date of Birth");
	                }
	                else if(!(textFStudNo.getLength()==9)) {
		        		textFStudNo.clear();
		   	        	textADisplay.setText("Please enter a valid Student No.\nMust be 9 characters long");
	                } 
	   /*  Will not work for me for some reason         
	    * 			  else if(!textFStudNo.getText().startsWith("R") || !textFStudNo.getText().startsWith("r")) {
		        		textFStudNo.clear();
		   	        	textADisplay.setText("Please enter a valid Student No.\nMust start with an R or r");
	                }  */
	                else {
		            	studCont.addStudentList(textFFName.getText(), textFLName.getText(), dateDOB.getValue(), textFStudNo.getText());
		        		textADisplay.setText(textFFName.getText()+" "+textFLName.getText()+" has been added");
		        		textFFName.clear();
		        		textFLName.clear();
		        		textFStudNo.clear();
		        		dateDOB.setValue(null);
	                }
	            }
	        }); 
	        
	      //ButtonRemove
	        btnRemove = new Button();
	        btnRemove.setText("Remove");
	        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                textADisplay.clear();
	                if(textFFName.getLength()<2){
	                	textFFName.clear();
		        		textADisplay.setText("Please enter a valid Forename");
	                }
	                else if(textFLName.getLength()<2) {
	                	textFLName.clear();
	    	        	textADisplay.setText("Please enter a valid Surname");
	                }
	                else if(dateDOB.getValue().isAfter(now.minusYears(17))) {
		        		dateDOB.setValue(null);
	    	        	textADisplay.setText("Please enter a valid Date of Birth");
	                }
	                else if(!(textFStudNo.getLength()==9)) {
		        		textFStudNo.clear();
		   	        	textADisplay.setText("Please enter a valid Student No.\nMust be 9 characters long");
	                } 
	   /*  Will not work for me for some reason         
	    * 			  else if(!textFStudNo.getText().startsWith("R") || !textFStudNo.getText().startsWith("r")) {
		        		textFStudNo.clear();
		   	        	textADisplay.setText("Please enter a valid Student No.\nMust start with an R or r");
	                }  */
	                else {
		            	studCont.removeStudentList(textFFName.getText(), textFLName.getText(), dateDOB.getValue(), textFStudNo.getText());
		        		textADisplay.setText(textFFName.getText()+" "+textFLName.getText()+" has been removed");
		        		textFFName.clear();
		        		textFLName.clear();
		        		textFStudNo.clear();
		        		dateDOB.setValue(null);
	                }
	            }
	        });
	        
	      //ButtonList
	        btnList = new Button();
	        btnList.setText("List");
	        btnList.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	textADisplay.setText(studCont.getListStudent());
	            }
	        }); 
	                
	        //ButtonLoad
	        btnLoad = new Button();
	        btnLoad.setText("Load");
	        btnLoad.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	try {
						textADisplay.setText(studCont.loadStudentCSV());
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        });
	        
	        //ButtonSave
	        btnSave = new Button();
	        btnSave.setText("Save");
	        btnSave.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	try {
	                    textADisplay.clear();
						studCont.saveStudentCSV();
						textADisplay.setText("Saved to File");
					} catch (IOException e) {
		                textADisplay.clear();
						e.printStackTrace();
						textADisplay.setText("Couldn't Save to File");
					}
	            }
	        });
	        
	        //ButtonExit
	        btnExit = new Button();
	        btnExit.setText("Exit"); 
	        btnExit.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	Alert alert = new Alert(AlertType.CONFIRMATION);
	            	alert.setTitle("Exit");
	            	alert.setContentText("Do you want to save before exit?");
	            	alert.showAndWait();
	            	if(alert.getResult() == ButtonType.OK) {
	            		try {
	                        textADisplay.clear();
	    					studCont.saveStudentCSV();
	                		Platform.exit();
	    				} catch (IOException e) {
	    	                textADisplay.clear();
	    					e.printStackTrace();
	    					textADisplay.setText("Couldn't Save to File");		
	    				}
	            		Platform.exit();
	            	}
	            	else if(alert.getResult() == ButtonType.CANCEL) {
	            		Platform.exit();
	            	}
	            }
	        });
	           
	        //HBox
	        HBox hbox1 = new HBox();
	        HBox hbox2 = new HBox();
	        HBox hbox3 = new HBox();
	        HBox hbox4 = new HBox();
	        HBox hbox5 = new HBox();
	        HBox hbox6 = new HBox();
	        HBox hbox7 = new HBox();
	        hbox1.getChildren().addAll(labelFName,textFFName);
	        hbox1.setSpacing(55);
	        hbox1.setAlignment(Pos.CENTER_LEFT);
	        hbox2.getChildren().addAll(labelLName,textFLName);
	        hbox2.setSpacing(61);
	        hbox2.setAlignment(Pos.CENTER_LEFT);
	        hbox3.getChildren().addAll(labelDOB,dateDOB);
	        hbox3.setSpacing(38);
	        hbox3.setAlignment(Pos.CENTER_LEFT);
	        hbox4.getChildren().addAll(labelStudNo,textFStudNo);
	        hbox4.setSpacing(19);
	        hbox4.setAlignment(Pos.CENTER_LEFT);
	        hbox5.getChildren().addAll(btnAdd,btnRemove,btnList);
	        hbox5.setSpacing(15);
	        hbox5.setAlignment(Pos.CENTER_LEFT);
	        hbox6.getChildren().addAll(textADisplay);
	        hbox6.setAlignment(Pos.CENTER);
	        hbox7.getChildren().addAll(btnLoad,btnSave,btnExit);
	        hbox7.setSpacing(15);
	        hbox7.setAlignment(Pos.CENTER_RIGHT);
	        
	        //VBox
	        VBox vbox = new VBox(10);
	        vbox.setAlignment(Pos.CENTER);
	        vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7);
		    vbox.setPadding(new Insets(20, 20, 20, 20));
		    
		    setContent(vbox);
	   }
}
