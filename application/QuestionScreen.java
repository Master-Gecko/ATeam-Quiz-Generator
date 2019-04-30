package application;

import java.util.List;

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
	static GridPane root;
	static Label questionLabel;
	static Button nextButton;
	static VBox choices;
	static ToggleGroup group;
	static Image qImage;
	static ImageView qImageView;
	static Label warningLabel;
	private int numChoices;
	
	public QuestionScreen(Parent parent) {
		super(parent);
		
		// Set Title
		title = "CS400 Quiz";
		
		// Create a GridPane
		root = new GridPane();
		
		//Set padding and gaps
		root.setPadding(new Insets(20, 20, 20, 20));
		//root.setGridLinesVisible(true);
		root.setVgap(5);
		root.setHgap(5);
		
		// Create Elements
		questionLabel = new Label("What is this?");
		nextButton = new Button("Next Question");
		nextButton.setOnAction(new QuestionScreenHandler(nextButton));
		warningLabel = new Label();
		
		questionScreen = new Scene(root, 800, 600);
		questionScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
	}
	
	public Scene getScene(Question q) {
		
		if (q.getImagePath().equals("none")) { // question does not have image  
			
		    // set up radio buttons
		    choices = new VBox();
	        group = new ToggleGroup();
	        numChoices = 0;
		    List<Answer> answerList = q.getAnswerList();
	        for (int i = 0; i < answerList.size(); i++) {
	        	RadioButton rb = new RadioButton(answerList.get(i).toString());
	        	rb.setToggleGroup(group);
	        	rb.setMaxWidth(400);
	        	rb.setWrapText(true);
	        	rb.setStyle("-fx-font-size: 20;");;
	        	choices.getChildren().add(rb);
	        	numChoices++;
	        }
	        
	        // set up questionLabel
	        questionLabel.setText(q.getQuestion());
	        questionLabel.setMaxWidth(400);
	        questionLabel.setMinWidth(400);
        	questionLabel.setWrapText(true);

        	
			root.add(questionLabel, 2, 0);
			root.add(choices, 2, 1);
			root.add(nextButton, 2, 2);
			root.add(warningLabel, 2, 3);
        	
		}
		else { // question has image
			
			qImage = new Image(q.getImagePath());
			qImageView = new ImageView(qImage);
			
		    //setting the fit height and width of the image view 
		    qImageView.setFitHeight(300); 
		    qImageView.setFitWidth(300); 
		    
		    //Setting the preserve ratio of the image view 
		    qImageView.setPreserveRatio(true);  
		    
		    // set up radio buttons
		    choices = new VBox();
	        group = new ToggleGroup();
	        numChoices = 0;
		    List<Answer> answerList = q.getAnswerList();
	        for (int i = 0; i < answerList.size(); i++) {
	        	RadioButton rb = new RadioButton(answerList.get(i).toString());
	        	rb.setToggleGroup(group);
	        	rb.setMaxWidth(400);
	        	rb.setWrapText(true);
	        	rb.setStyle("-fx-font-size: 20;");;
	        	choices.getChildren().add(rb);
	        	numChoices++;
	        }
	        
	        // set up questionLabel
	        questionLabel.setText(q.getQuestion());
	        questionLabel.setMaxWidth(400);
	        questionLabel.setMinWidth(400);
        	questionLabel.setWrapText(true);
        	
        	root.add(qImageView, 2, 0);
			root.add(questionLabel, 0, 0);
			root.add(choices, 0, 1);
			root.add(nextButton, 2, 2);
			root.add(warningLabel, 0, 2);

        	
		}
		return this.questionScreen;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getQuizScore() {
		return Main.qd.getQuizScore();
	}
	
	public int getNumberOfChoices() {
		return numChoices;
	}
	
	public String getSelectedAnswer() {
		RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
		return selectedRadioButton.getText();
	}
	
}
