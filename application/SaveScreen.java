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
 * Filename:   SaveScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 * Creates a scene for saving the user's questions,
 * returning the scene
 */
public class SaveScreen extends Scene {
	
	  private Scene saveScreen;
	  private String title;
	  int score = 0;
	  
	  public SaveScreen(Parent parent) {
		  //NEED TO GET SCORE FROM SOMEWHERE
		  super(parent);
		   title = "Save Quiz Questions Before Leaving?";
		    // Create a GridPane
			GridPane root = new GridPane();
			
			//Save File Message
			Text message = new Text("Yes! Enter JSON file name\n\tto save to below");
			TextField fileName = new TextField();
			fileName.setPromptText("Review-Session-1.json"); //to set the hint text
			fileName.setMinWidth(250);

			//Confirm Exit
			Button exitConfirm = new Button("No thanks!");
	
			for (int i = 0; i < 5; i++) {
		         ColumnConstraints column = new ColumnConstraints(160);
		         root.getColumnConstraints().add(column);
		     }
			for (int i = 0; i < 200; i++) {
		         RowConstraints row = new RowConstraints(3);
		         root.getRowConstraints().add(row);
		     }
			//Set padding and gaps
			root.setPadding(new Insets(20, 20, 20, 20));
			root.setVgap(5);
			
			//Format the boxes
			root.add(message, 0, 5);
			root.add(fileName, 0, 12);
			root.add(exitConfirm, 3, 12);
			
			saveScreen = new Scene(root, 800,600);
			saveScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	}
	
	public Scene getScene() {
		return this.saveScreen;
	}
	
	public String getTitle() {
		return title;
	}
	
}
