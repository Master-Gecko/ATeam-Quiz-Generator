package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


/**
 * 
 * Filename:   InsertQuestionScreenHandler.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 */
class SaveScreenHandler implements EventHandler<ActionEvent> {
	//Button Fields
	Button b;
	TextField tf;
	FileOut fo;
	
	/**
	 * Constructor
	 * @param b
	 */
	SaveScreenHandler(Button b) {
		this.b = b;
	}
	
	SaveScreenHandler(Button b, TextField tf) {
		this.b = b;
		this.tf = tf;
	}
		
	/**
	 * This handler method either saves the file file, 
	 * or simply just closes the application
	 */
	@Override
	public void handle(ActionEvent event) {
		
		//Close the application if button clicked
		if (b.getText().equals("No thanks!")) {
			Platform.exit();
			}
		
		//Else, try to save file
		else if(b.getText().equals("Submit!")){
			//Display all alerts
			try {
				FileOut fo = new FileOut(tf.getText(), Main.questionTable);
			} catch (FileNotFoundException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("File Not Found");
				alert.setHeaderText(null);
				alert.setContentText("Please double check that this is a valid file name");
				alert.showAndWait();
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("IOException");
				alert.setHeaderText(null);
				alert.setContentText("Please double check that this is a valid file name");
				alert.showAndWait();
			} catch (ParseException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ParseException");
				alert.setHeaderText(null);
				alert.setContentText("Unable to correctly parse data");
				alert.showAndWait();
			}
		}
	}
}
