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
	//Scene openingScreen, manualNewQuestionScreen, loadAdditionalTopicFileScreen;
	OpeningScreen os;
	InsertQuestionScreen iqs;
	//Scene questionScreen, scoreScreen, goodbyeScreen;
	OpeningScreenHandler oHandler;;

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			window.setTitle("CS 400 Quiz");
//			Create an instance of the opening screen
//			openingScreen = new OpeningScreen(primaryStage);
//			openingScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			
			

			parent = new Group();
			OpeningScreen os = new OpeningScreen(parent);
			window.setTitle(os.getTitle());
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
