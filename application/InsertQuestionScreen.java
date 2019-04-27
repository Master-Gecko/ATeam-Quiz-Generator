package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *  * 
 * Filename:   HashTableADT.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400
 * Authors:    Titus Smith
 *
 */
public class InsertQuestionScreen extends Scene{
	//private Stage window;
	  private Scene insertNewQuestionScreen;
	  private String title;
	  
	  public InsertQuestionScreen(Parent parent) {
		  super(parent);
		   title = "Add a New Question!";
		    // Create a GridPane
			GridPane root = new GridPane();
			
			//Topic textfield
			TextField topic = new TextField();
			topic.setPromptText("Topic:"); //to set the hint text
			topic.setMinWidth(250);
			
			//Question textfield
			TextField question = new TextField();
			question.setPromptText("Question:"); //to set the hint text
			question.setMinWidth(500);
			//Example text
			Text message = new Text("\t\tList each answer in the form of:\n"
					+ "'T/F, <Answer>', "
					+ "separating the two with a comma,\n\t\t\tending with a "
					+ "return.");

			//Answer textarea
			TextArea answers = new TextArea();
			answers.setPromptText("T, The Sun came up this morning"
					+ "\rF, Construction never happens in Madison");
			answers.setPrefColumnCount(200);
			answers.setPrefRowCount(100);
			answers.setMinWidth(500);
			//Set padding and gaps
			root.setPadding(new Insets(20, 20, 20, 20));
			//root.setGridLinesVisible(true);
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