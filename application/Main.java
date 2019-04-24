 package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author titus, member of A-Team 60
 * This class launches the application window and is the main driver of the program
 */
public class Main extends Application {
	
	//Fields for the primary stage and the classes for each "scene"
	Stage window; //root
	Group parent;
	Scene openingScreen, manualNewQuestionScreen, loadAdditionalTopicFileScreen;
	Scene questionScreen, scoreScreen, goodbyeScreen;
	OpeningScreenHandler oHandler;;

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
//			Create an instance of the opening screen
//			openingScreen = new OpeningScreen(primaryStage);
//			openingScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			window.setTitle("CS 400 Quiz");
//			BorderPane root = new BorderPane();
//			VBox left = new VBox(20);
//			left.setPadding(new Insets(100,5,50,5));
//			VBox right = new VBox(175);
//			right.setPadding(new Insets(100,5,50,5));
//			ObservableList<String> options = FXCollections.observableArrayList("Science", "Math", "English");
//			ComboBox topics = new ComboBox(options);
////			topics.setPrefSize(200, 50);
//			Label topicsLabel= new Label("Topics of Quiz");
//			Button startQuiz = new Button("Start Quiz");
//			startQuiz.setStyle("-fx-font-size: 50;");
//			startQuiz.setPrefSize(300, 300);
//			Button loadTopic = new Button("Load another topic");
////			loadTopic.setMaxSize(200, 50);
//			Button insertQuestion = new Button("Insert another\nquestion");
////			insertQuestion.setMaxSize(200, 50);
//			Label numQuestions = new Label("Number of\nQuestions");
//			TextField number = new TextField();
//			left.getChildren().add(topicsLabel);
//			left.getChildren().add(topics);
//			root.setLeft(left);
//			root.setCenter(startQuiz);
//			right.getChildren().add(loadTopic);
//			right.getChildren().add(insertQuestion);
//			left.getChildren().addAll(numQuestions,number);
//			root.setRight(right);
//			openingScreen = new Scene(root, 800,600);
//			openingScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//			
			parent = new Group();
			OpeningScreen os = new OpeningScreen(parent);
	        System.out.println((primaryStage == null));
	        System.out.println(os == null);
	        System.out.println(parent == null);
	        primaryStage.setScene(os.getScene());
			primaryStage.show();
			
			//Create an instance of each handler?
			oHandler = new OpeningScreenHandler();
			
			//Other scenes
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Stage getWindow() {
		return window;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
