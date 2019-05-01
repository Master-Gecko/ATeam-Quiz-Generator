package application;

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
 * Filename:   SaveScreenHandler.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 */
class InsertQuestionScreenHandler implements EventHandler<ActionEvent> {
	Button b;
	
	
	InsertQuestionScreenHandler(Button b) {
		this.b = b;
	}
		
	/**
	 * This handler method checks to make sure none of the text fields are empty
	 */
	@Override
	public void handle(ActionEvent event) {
		if (b.getText().equals("Submit!")) {
			
			//Check to make sure that none of the entries are null
			if(InsertQuestionScreen.answers.getText().isEmpty() ||
					InsertQuestionScreen.topic.getText().isEmpty() ||
					InsertQuestionScreen.question.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Question Submitted without valid input data");
				alert.setHeaderText(null);
				alert.setContentText("Please check to make sure you have a valid topic, "
						+ "question and answers entry");
				alert.showAndWait();
			}
			else {//If none of the entries are null, add a parse entry
				ParseEntry pe = new ParseEntry(InsertQuestionScreen.topic.getText(), InsertQuestionScreen.topic.getText(),
						InsertQuestionScreen.question.getText());

				//Check for a parse exception?
				
			}
		}
		else if(b.getText().equals("Return to Main Menu")) {
			Group parent = new Group();
			OpeningScreen os = new OpeningScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(os.getScene());
			primaryStage.setTitle(os.getTitle());
		}
	}
}