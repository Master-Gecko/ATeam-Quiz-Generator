package application;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * 
 * Filename:   QuestionScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Eddie Morelli
 * 
 */
public class QuestionScreen extends Scene {
	
	private Scene questionScreen;
	private String title;
	
	public QuestionScreen(Parent parent) {
		super(parent);
		
		// Set Title
		title = "CS400 Quiz";
		
		// Create a GridPane
		GridPane root = new GridPane();
		
		// Create Elements
		Label questionLabel = new Label("What is this?");
		Button nextButton = new Button("Next Question");
	    VBox choices = new VBox();
        ToggleGroup group = new ToggleGroup(); // group of radio buttons
		

		if (true) { // question has image
			Image qImage = new Image("doggy.JPG");
			ImageView qImageView = new ImageView(qImage);
			
		    //setting the fit height and width of the image view 
		    qImageView.setFitHeight(300); 
		    qImageView.setFitWidth(300); 
		    
		    //Setting the preserve ratio of the image view 
		    qImageView.setPreserveRatio(true);  
		    
		    // set up radio buttons
	        for (int i = 0; i < 4; i++) {
	        	RadioButton rb = new RadioButton("Good Boy");
	        	rb.setToggleGroup(group);
	        	rb.setMaxWidth(400);
	        	rb.setWrapText(true);
	        	rb.setStyle("-fx-font-size: 15;");;
	        	choices.getChildren().add(rb);
	        }
	        
	        RadioButton longChoice = new RadioButton("This is a really long answer. This answer is really long. Is this answer really long?");
	    	longChoice.setToggleGroup(group);
	    	longChoice.setMaxWidth(400);
	    	longChoice.setWrapText(true);
	    	longChoice.setStyle("-fx-font-size: 15;");
	    	choices.getChildren().add(longChoice);

			root.add(qImageView, 2, 0);
			root.add(questionLabel, 0, 0);
			root.add(choices, 0, 1);
			root.add(nextButton, 2, 2);
			
		}
		else { // question does not have image
			
			questionLabel.setStyle("-fx-font-size: 25;");
			//set up radio buttons
	        for (int i = 0; i < 4; i++) {
	        	RadioButton rb = new RadioButton("Good Boy");
	        	rb.setToggleGroup(group);
	        	rb.setMaxWidth(400);
	        	rb.setWrapText(true);
	        	rb.setStyle("-fx-font-size: 20;");;
	        	choices.getChildren().add(rb);
	        }
	        
	        RadioButton longChoice = new RadioButton("This is a really long answer. This answer is really long. Is this answer really long?");
	    	longChoice.setToggleGroup(group);
	    	longChoice.setMaxWidth(400);
	    	longChoice.setWrapText(true);
	    	longChoice.setStyle("-fx-font-size: 20;");
	    	choices.getChildren().add(longChoice);
			
			root.add(questionLabel, 2, 0);
			root.add(choices, 2, 1);
			root.add(nextButton, 2, 3);
		}
		
		//Set padding and gaps
		root.setPadding(new Insets(20, 20, 20, 20));
		//root.setGridLinesVisible(true);
		root.setVgap(5);
		root.setHgap(5);
		
		questionScreen = new Scene(root, 800, 600);
		questionScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
//		// for reference, doesn't work - throws Exception
//		OpeningScreen os2 = new OpeningScreen(parent);
//		questionScreen = os2.getScene();
	}
	
	public Scene getScene() {
		return this.questionScreen;
	}
	
	public String getTitle() {
		return title;
	}
	
}
