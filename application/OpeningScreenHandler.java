package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


/**
 * @author titus
 * This class implements Java EventHandler interface to create
 * an event handler class for the opening screen
 */
class OpeningScreenHandler implements EventHandler<ActionEvent> {
	Button b;
	
	OpeningScreenHandler(Button b) {
		this.b = b;
	}
	
	/**
	 * This method handles ComboBox user interactions
	 * @param cb
	 */
	void handle(ComboBox<String> cb ) {
		//if equals topic x, load topic x
		if(cb.equals("ENTER IN TOPIC NAMES FROM JSON FILE"));
		
		//if equals topic y, load topic y
	}
	/**
	 * This method handles TextField user interactions
	 * @param tf
	 */
	void handle(TextField tf) {
		//If number is larger than the number of questions that match the chosen topic, 
		//include the max number of questions that match the chosen topic. 
		
		//if tf>numQuestions, then load maxQuestions
		
		//else, load #tf of questions
	}
	void handle(Button b) {
		//CHECK WHICH BUTTON IS BEING PRESSED
		if(b.equals("Start Quiz")) {
			
		}
			//startQuizButton
				//If there isn't at topic, or a number of questions entered, then display
				//pop up asking for the two fields to be entered
		else if(b.equals("Load Additional Topic")) {
			
		}
			//insertQuestionButton
				//Switch to LoadAdditionalTopic Screen
		else if(b.equals("Insert a Question!")) {
			
		}
		
	}
	@Override
	public void handle(ActionEvent event) {
		if (b.getText().equals("Start\nQuiz")) {
			Group parent = new Group();
			QuestionScreen qs = new QuestionScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Main.qd.startQuiz(primaryStage);
		}
		
	}

	}
