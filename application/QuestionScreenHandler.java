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
	Button b;
	
	QuestionScreenHandler(Button b) {
		this.b = b;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// next button
		if (b.getText().equals("Next Question")) {
			Main.qd.updateScreen();
		}
		else if (b.getText().equals("Submit Quiz")) {
			Main.qd.updateScreen();
			
			if (QuestionScreen.warningLabel.getText().equals("Choose an answer!")) {
				return;
			}
			
			// change scene
			Group parent = new Group();
			ScoreScreen ss = new ScoreScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(ss.getScene());
			primaryStage.setTitle(ss.getTitle());
		}
	}
}
