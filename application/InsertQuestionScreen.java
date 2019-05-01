package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *  * 
 * Filename:   InsertQuestionScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400
 * Authors:    Titus Smith
 * 
 * Creates a scene for adding a new question, and returns the scene. 
 *
 */
public class InsertQuestionScreen extends Scene{
	//private Stage window;
	  private Scene insertNewQuestionScreen;
	  private String title;
	  static TextField topic;
	  static TextField question;
	  static TextArea answers;
	  static Button submitButton;
	  static Button returnButton;
	  
	  public InsertQuestionScreen(Parent parent) {
		  super(parent);
		   title = "Add a New Question!";
		    // Create a GridPane
			GridPane root = new GridPane();
			
			//Topic textfield
			topic = new TextField();
			topic.setPromptText("Topic:"); //to set the hint text
			topic.setMinWidth(250);
			
			//Question textfield
			question = new TextField();
			question.setPromptText("Question:"); //to set the hint text
			question.setMinWidth(250);
			//Example text
			Text message = new Text("\t\tList each answer in the form of:\n"
					+ "'T/F, <Answer>', "
					+ "separating the two with a comma,\n\t\t\tending with a "
					+ "return.");

			//Answer textarea
			answers = new TextArea();
			answers.setPromptText("T, The Sun came up this morning"
					+ "\rF, Construction never happens in Madison");
			answers.setPrefRowCount(50);
			answers.setMinWidth(500);
			
			//Submit button
			submitButton = new Button("Submit!");
			submitButton.setOnAction(new InsertQuestionScreenHandler(submitButton));
			
			//Return button
			returnButton = new Button("Return to Main Menu");
			returnButton.setOnAction(new InsertQuestionScreenHandler(returnButton));
			returnButton.setMinHeight(200);
			
			
			//Set padding and gaps
			root.setPadding(new Insets(20, 20, 20, 20));
			root.setVgap(5);
			
			for (int i = 0; i < 5; i++) {
		         ColumnConstraints column = new ColumnConstraints(160);
		         root.getColumnConstraints().add(column);
		     }
			
			//Format the boxes
			root.add(topic, 1, 0);
			root.add(question, 1, 5);
			root.add(message, 1, 9);
			root.add(answers, 1, 10);
			root.add(submitButton, 3, 0);
			root.add(returnButton, 3, 5);
			
			insertNewQuestionScreen = new Scene(root, 800,600);
			insertNewQuestionScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		}

	  /**
	   * Getter method for scene
	   * @return
	   */
	  public Scene getScene() {
		  return this.insertNewQuestionScreen;
	  }
	  /**
	   * Getter method for title
	   * @return
	   */
	  public String getTitle() {
		  return this.title;
	  }	
	}