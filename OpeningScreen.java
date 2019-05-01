package application;

import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * Filename:   OpeningScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith, Eddie Morelli
 * 
 */
public class OpeningScreen extends Scene{
  //Fields
  private Scene openingScreen;
  private String title;
  static Button startQuiz;
  static Button exitQuiz;
  static Button loadTopic;
  static Button insertQuestion;
  static ListView<String> topics;
  static TextField number;
  static Label instructionLabel;
  
	public OpeningScreen(Parent parent) {
		super(parent);
	  
	  	//Set Title
	  	title = "CS 400 Quiz Generator";
	  	
	  	//Create a GridPane
	  	GridPane root = new GridPane();
		
		//Create buttons and labels
		ObservableList<String> options = FXCollections.observableArrayList(Main.questionTable.getAllTopics());
		topics = new ListView<String>(options);
		topics.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		topics.setMaxHeight(150);
		Label topicsLabel= new Label("\tTopics of Quiz");
		
		startQuiz = new Button("Start\nQuiz");
		startQuiz.setStyle("-fx-font-size: 60;");
		startQuiz.setOnAction(new OpeningScreenHandler(startQuiz));
		
		exitQuiz = new Button("Close Window");
		exitQuiz.setOnAction(new OpeningScreenHandler(exitQuiz));
		
		loadTopic = new Button("Load Questions\n      From File");
		loadTopic.setOnAction(new OpeningScreenHandler(loadTopic));
		
		insertQuestion = new Button("Insert Another\n     Question");
		insertQuestion.setOnAction(new OpeningScreenHandler(insertQuestion));
		
		Label numQuestions = new Label("Enter the \n# of Questions");
		number = new TextField();
		HBox qNumber = new HBox();
		
		qNumber.setAlignment(Pos.CENTER);
		qNumber.setSpacing(10);
		qNumber.getChildren().addAll(numQuestions,number);
		
		
		//Informational message
		if (Main.questionTable.getNumQs() == 0) {
			instructionLabel = new Label("Questions must be added\nbefore starting the quiz.");
			instructionLabel.setStyle("-fx-font-size: 12;");
		}
		else {
			instructionLabel = new Label("ctrl+click or shift+click to choose multiple topics!");
			instructionLabel.setWrapText(true);
		}
		
		//Set padding and gaps
		root.setPadding(new Insets(20, 20, 20, 20));
		root.setVgap(5);
		root.setHgap(5);
		
		//Topics and dropdown
		root.add(topicsLabel, 0, 0);
		root.add(topics, 0, 1);
		
		//Start Quiz Button
		root.add(startQuiz, 1, 2);
		
		//Exit quiz button
		root.add(exitQuiz, 1, 16);
		
		//Number of Questions
		root.add(qNumber, 0, 3);
		
		//Load Additional Topic
		root.add(loadTopic, 2, 1);
		
		//Insert a question
		root.add(insertQuestion, 2, 3);
		
		//Instruction Label
		root.add(instructionLabel, 2, 0);
		
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
