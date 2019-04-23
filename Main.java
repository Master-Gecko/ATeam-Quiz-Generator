 package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * @author titus, member of A-Team 60
 * This class launches the application window and is the main driver of the program
 */
public class Main extends Application {
	
	//Fields for the primary stage and the classes for each "scene"
	Stage window; //root
	Scene openingScreen, manualNewQuestionScreen, loadAdditionalTopicFileScreen;
	Scene questionScreen, scoreScreen, goodbyeScreen;
	OpeningScreenHandler openingScreenHandler;

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			//Create an instance of the opening screen
			openingScreen = new OpeningScreen();
			openingScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(openingScreen);
			primaryStage.show();
			
			//Create an instance of each handler?
			openingScreenHandler = new OpeningScreenHandler();

			
			
			
			
			
			
			
			
			
			//Other scenes
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
