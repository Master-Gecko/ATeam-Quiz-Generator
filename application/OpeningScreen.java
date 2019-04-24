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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OpeningScreen extends Scene{
  //private Stage window;
  private Scene openingScreen;
  
	public OpeningScreen(Parent parent) {
	  super(parent);

		BorderPane root = new BorderPane();
		VBox left = new VBox(20);
		left.setPadding(new Insets(100,5,50,5));
		VBox right = new VBox(175);
		right.setPadding(new Insets(100,5,50,5));
		ObservableList<String> options = FXCollections.observableArrayList("Science", "Math", "English");
        ComboBox<String> topics = new ComboBox<String>(options);
//		topics.setPrefSize(200, 50);
		Label topicsLabel= new Label("Topics of Quiz");
		Button startQuiz = new Button("Start Quiz");
		startQuiz.setStyle("-fx-font-size: 50;");
		startQuiz.setPrefSize(300, 300);
		Button loadTopic = new Button("Load another topic");
//		loadTopic.setMaxSize(200, 50);
		Button insertQuestion = new Button("Insert another\nquestion");
//		insertQuestion.setMaxSize(200, 50);
		Label numQuestions = new Label("Number of\nQuestions");
		TextField number = new TextField();
		left.getChildren().add(topicsLabel);
		left.getChildren().add(topics);
		root.setLeft(left);
		root.setCenter(startQuiz);
		right.getChildren().add(loadTopic);
		right.getChildren().add(insertQuestion);
		left.getChildren().addAll(numQuestions,number);
		root.setRight(right);
		openingScreen = new Scene(root, 800,600);
		openingScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	}
	
	public Scene getScene() {
	  return this.openingScreen;
	}
}
