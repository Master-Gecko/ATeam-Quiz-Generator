package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * Filename:   QuestionScreenHandler.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Eddie Morelli
 * 
 */
public class QuestionScreenHandler implements EventHandler<ActionEvent> {
	Button b; // the button that this handler will be used for
	
	/**
	 * Constructor that takes a button and sets it to the field b
	 * @param b is the button that this handler will be used for.
	 */
	QuestionScreenHandler(Button b) {
		this.b = b;
	}
	
	/**
	 * This method is called whenever a button in the QuestionScreen has been clicked.
	 */
	@Override
	public void handle(ActionEvent event) {
		if (b.getText().equals("Next Question")) {
			Main.qd.updateScreen();
		}
		else if (b.getText().equals("Submit Quiz")) {
			Main.qd.updateScreen();
			// if the user has not chosen an answer
			if (QuestionScreen.warningLabel.getText().equals("Choose an answer!")) {
				return;
			}
			
			// change to score screen after last question
			Group parent = new Group();
			ScoreScreen ss = new ScoreScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(ss.getScene());
			primaryStage.setTitle(ss.getTitle());
		}
	}
}
