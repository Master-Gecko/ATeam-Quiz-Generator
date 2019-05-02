package application;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * 
 * Filename:   ScoreScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 * Creates a scene for displaying the user's score and a 
 * few user prompts, returning the scene. 
 */
public class ScoreScreen extends Scene {
	
	  //Node fields
	  private Scene scoreScreen;
	  private String title;
	  static Button exitQuiz;
	  
	  public ScoreScreen(Parent parent) {
		  super(parent);
		   title = "Your Score";
		    // Create a GridPane
			GridPane root = new GridPane();
			
			//Result message
			Text result = new Text("You got "+Main.qd.getNumCorrect()+"/"+Main.qd.getNumQuestions());
			
			//Exit quiz button
			exitQuiz = new Button("Return to Menu");
			exitQuiz.setOnAction(new ScoreScreenHandler(exitQuiz));
			
			//Set row and column constraints
			for (int i = 0; i < 5; i++) {
		         ColumnConstraints column = new ColumnConstraints(160);
		         root.getColumnConstraints().add(column);
		     }
			for (int i = 0; i < 6; i++) {
		         RowConstraints row = new RowConstraints(100);
		         root.getRowConstraints().add(row);
		     }
			//Set padding and gaps
			root.setPadding(new Insets(20, 20, 20, 20));
			root.setVgap(5);
			
			//Format the boxes
			root.add(result, 2, 0);
			root.add(exitQuiz, 0, 3);
			
			scoreScreen = new Scene(root, 800,600);
			scoreScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	}
	
	
	/**
	 * Getter method for scene
	 * @return
	 */
	public Scene getScene() {
		return this.scoreScreen;
	}
	
	/**
	 * Getter method for title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
}
