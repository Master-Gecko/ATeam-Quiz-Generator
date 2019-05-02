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
 * Filename: OpeningScreenHandler.java Project: ATeam Quiz Generator Course: cs400 Spring 2019
 * Authors: Titus Smith, Eddie Morelli, Sammy Zopf
 * 
 */
class OpeningScreenHandler implements EventHandler<ActionEvent> {
  Button b;

  OpeningScreenHandler(Button b) {
    this.b = b;
  }

  @Override
  public void handle(ActionEvent event) {
	  
	//Start Quiz button
    if (b.getText().equals("Start\nQuiz")) {
      Main.qd = new QuizDriver();
      
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
      if (numQuestions <= 0) {
    	  OpeningScreen.instructionLabel.setText("Must have at least one question.");
          return;
      }
      try {
        Main.qd.addQuestions(selected, numQuestions);
      } catch (IndexOutOfBoundsException e) {
        OpeningScreen.instructionLabel.setText("Not enough questions uploaded.");
        return;
      } catch (Exception e) {/*This shouldn't be reached*/ }

      // change scene
      Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Main.qd.startQuiz(primaryStage);
      
    } 
    //Insert/Import Button
    else if (b.getText().equals("Insert Another\n     Question")) {
      Group parent = new Group();
      InsertQuestionScreen iqs = new InsertQuestionScreen(parent);
      Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      primaryStage.setScene(iqs.getScene());
      primaryStage.setTitle(iqs.getTitle());
    } 
    //Load Questions Button
    else if (b.getText().equals("Load Questions\n      From File")) {
      Group parent = new Group();
      LoadAdditionalFileScreen lafs = new LoadAdditionalFileScreen(parent);
      Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      primaryStage.setScene(lafs.getScene());
      primaryStage.setTitle(lafs.getTitle());
    } 
    //Close Window Button
    else if (b.getText().equals("Close Window")) {
    	//Return to main menu after 
		Group parent = new Group();
		SaveScreen ss = new SaveScreen(parent);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(ss.getScene());
		primaryStage.setTitle(ss.getTitle());
    }
  }

}
