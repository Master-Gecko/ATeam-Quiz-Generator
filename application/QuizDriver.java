package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * 
 * Filename:   QuizDriver.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Eddie Morelli
 * 
 */
public class QuizDriver {

	private int numQuestions;
	private int numCorrect;
	private double quizScore;
	private ArrayList<Question> quiz;
	private int currentQuestionIndex;
	private Stage primaryStage;
	private QuestionScreen qs;
	
	QuizDriver() {
		numQuestions = 0;
		numCorrect = 0;
		currentQuestionIndex = 0;
	}
	
	/**
	 * when the user chooses topic and number of questions on the Opening Screen, this method will
	 * be used to randomly choose questions of the given topic from the HashTable.
	 * 
	 * @param topic is the user-chosen question topic
	 * @param numberOfQuestions is the number of questions to be added to the quiz
	 */
	void addQuestions(String topic, int numberOfQuestions) {
		
	}
	
	/**
	 * this method will serve as the driver for the Quiz.
	 */
	public void startQuiz(Stage primaryStage) {
		this.primaryStage = primaryStage;
		Group parent = new Group();
		qs = new QuestionScreen(parent);
		primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
		primaryStage.setTitle(qs.getTitle());
	}
	
	/**
	 * changes the question when the user chooses to move on.
	 */
	void updateScreen() {
		// check if right answer
		for (int i = 0; i < qs.getNumberOfChoices(); i++) {
			if (quiz.get(currentQuestionIndex).getAnswer().equals(qs.getSelectedAnswer()))
				numCorrect++;
		}
		
		// move to next question
		currentQuestionIndex++;
		primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
		if (currentQuestionIndex == numQuestions - 1)
			qs.nextButton.setText("Submit");
	}
	
	public double getQuizScore() {
		return quizScore;
	}
	
}
