package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class InsertQuestionScreen extends Scene{
	//private Stage window;
	  private Scene insertNewQuestionScreen;
	  
	  public InsertQuestionScreen(Parent parent) {
		  super(parent);

			BorderPane root = new BorderPane();
			
			//Topic textfield
			
			//Question textfield
			
			//Answer textarea
			
			//Submit button
			insertNewQuestionScreen = new Scene(root, 800,600);
			insertNewQuestionScreen.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		}
		
		public Scene getScene() {
		  return this.insertNewQuestionScreen;
		}
}
