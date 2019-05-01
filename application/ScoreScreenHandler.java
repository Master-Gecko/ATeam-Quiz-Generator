package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * 
 * Filename:   QuestionScreenHandler.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 */
public class ScoreScreenHandler implements EventHandler<ActionEvent> {
	
	Button b;
	
	ScoreScreenHandler(Button b) {
		this.b = b;
	}

	/**
	 * Handler method for buttons pressed
	 */
	@Override
	public void handle(ActionEvent event) {

		//Switch to OpeningScreen
		if (b.getText().equals("Return to Menu")) {
			Group parent = new Group();
			OpeningScreen os = new OpeningScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(os.getScene());
			primaryStage.setTitle(os.getTitle());
		}
	}
}
