package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * @author titus
 * This class implements Java EventHandler interface to create
 * an event handler class for the opening screen
 */
class OpeningScreenHandler implements EventHandler<ActionEvent> {
	ComboBox<String> quizDropDown; //dropdown menu for list of quiz topics for user to choose
	TextField numQuestionsTextEntry; //single line text input for the number of questions desired
	Button startQuizButton; //button to start the quiz
	Button insertQuestionButton; //button user clicks to switch scenes to ManualNewQuestionScreen 
	Button loadAdditionalTopics; //button user clicks to switch scenes to LoadAdditionalTopicFileScreen
	
	void handle(ComboBox<String> cb ) {
		//handles ComboBox user interactions
	}
	void handle(TextField tf) {
		//handles TextField user interactions
	}
	void handle(Button b) {
		//handles Button user interactions -
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	}
