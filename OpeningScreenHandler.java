package application;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


/**
 * 
 * Filename:   OpeningScreenHandler.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith, Eddie Morelli
 * 
 */
class OpeningScreenHandler implements EventHandler<ActionEvent> {
	Button b;
	
	OpeningScreenHandler(Button b) {
		this.b = b;
	}
		
	@Override
	public void handle(ActionEvent event) {
		if (b.getText().equals("Start\nQuiz")) {
			// parse number of questions and topics
			int numQuestions;
			try {
				numQuestions = Integer.parseInt(OpeningScreen.number.getText());
			} catch (NumberFormatException e) {
				OpeningScreen.instructionLabel.setText("Enter an (integer) number of questions.");
				return;
			}
			ObservableList<String> selected = OpeningScreen.topics.getSelectionModel().getSelectedItems();
			if (selected.isEmpty()) {
				OpeningScreen.instructionLabel.setText("Choose topic(s).");
				return;
			}
			try {
				for (int i = 0; i < selected.size(); i++) {
					// assures correct number of questions with equal distribution of topics
					Main.qd.addQuestions(selected.get(i), (numQuestions / (selected.size() - i)));
					System.out.println(numQuestions / (selected.size() - i));
					numQuestions -= (numQuestions / (selected.size() - i));
				}
			} catch (IndexOutOfBoundsException e) { 
				OpeningScreen.instructionLabel.setText("Not enough questions for one or more topics.");
		 	} catch (Exception e) {
				// this should never be reached, only here to avoid compiler error
				System.out.println("unexpected exception");
			}
			
			// change scene
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Main.qd.startQuiz(primaryStage);
		}
//		else if (b.getText().equals("Load another topic")) {
//			Group parent = new Group();
//			LoadAdditionalTopicScreen lats = new LoadAdditionalTopicScreen(parent);
//			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//			primaryStage.setScene(lats.getScene());
//			primaryStage.setTitle(lats.getTitle());
//		}
		else if (b.getText().equals("Insert another\nquestion")) {
			Group parent = new Group();
			InsertQuestionScreen iqs = new InsertQuestionScreen(parent);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(iqs.getScene());
			primaryStage.setTitle(iqs.getTitle());
		}
		else if (b.getText().equals("Load questions from file")) {
          Group parent = new Group();
          LoadAdditionalFileScreen lafs = new LoadAdditionalFileScreen(parent);
          Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
          primaryStage.setScene(lafs.getScene());
          primaryStage.setTitle(lafs.getTitle());
      }
		else if(b.getText().equals("Close Window")) {
			Platform.exit();
		}
	}

	}
