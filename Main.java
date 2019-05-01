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
 * @author titus
 * This class launches the application window and is the main driver of the program
 */
public class Main extends Application {
	
	static QuizDriver qd;
	//Fields for the primary stage and the classes for each "scene"
	Stage window; //root
	static Group parent;
	//Scene openingScreen, manualNewQuestionScreen, loadAdditionalTopicFileScreen;
	OpeningScreen os;
	InsertQuestionScreen iqs;
	LoadAdditionalFileScreen lafs;
	//Scene questionScreen, scoreScreen, goodbyeScreen;
	OpeningScreenHandler oHandler;
	static public HashTable<Question> questionTable;

	@Override
	public void start(Stage primaryStage) {
		try {
			questionTable = new HashTable<Question>();
			qd = new QuizDriver();
			window = primaryStage;
			//window.setTitle("CS 400 Quiz");
			/*Create an instance of the opening screen*/
			window.setMinHeight(600);
			window.setMinWidth(800);
			window.setMaxHeight(800);
			window.setMaxWidth(800);
			
			parent = new Group();
			OpeningScreen os = new OpeningScreen(parent);
			window.setTitle(os.getTitle());
	        primaryStage.setScene(os.getScene());
			primaryStage.show();
			
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
