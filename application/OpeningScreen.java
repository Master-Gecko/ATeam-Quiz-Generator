package application;

import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OpeningScreen extends Scene{
  //Fields
  private Scene openingScreen;
  private String title;
  static Button startQuiz;
  
	public OpeningScreen(Parent parent) {
		super(parent);
	  
	  	//Set Title
	  	title = "CS 400 Quiz";
	  	
	  	//Create a GridPane
	  	GridPane root = new GridPane();
		
		//Create buttons and labels
		ObservableList<String> options = FXCollections.observableArrayList("Science", "Math", "English");
        ComboBox<String> topics = new ComboBox<String>(options);
		Label topicsLabel= new Label("Topics of Quiz");
		startQuiz = new Button("Start\nQuiz");
		startQuiz.setStyle("-fx-font-size: 60;");
		startQuiz.setPrefSize(300, 300);
		Button loadTopic = new Button("Load another topic");
		Button insertQuestion = new Button("Insert another\nquestion");
		Label numQuestions = new Label("Number of\nQuestions");
		TextField number = new TextField();
		
		//Set padding and gaps
		root.setPadding(new Insets(20, 20, 20, 20));
		//root.setGridLinesVisible(true);
		root.setVgap(5);
		root.setHgap(5);
		
		//Topics and dropdown
		root.add(topicsLabel, 0, 0);
		root.add(topics, 0, 1);
		
		//Start Quiz Button
		root.add(startQuiz, 2, 2);
		
		//Number of Questions
		root.add(numQuestions, 0, 3);
		root.add(number, 0, 4);
		
		//Load Additional Topic
		root.add(loadTopic, 3, 1);
		
		//Insert a question
		root.add(insertQuestion, 3, 4);
		
		//Create the scene with the style sheet
		openingScreen = new Scene(root, 800, 600);
		openingScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	}
	
	/**
	 * Getter method for scene
	 * @return
	 */
	public Scene getScene() {
	  return this.openingScreen;
	}
	
	/**
	 * Getter method for title
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}
}
