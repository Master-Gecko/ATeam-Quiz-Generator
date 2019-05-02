package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
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

	private int numQuestions; // total number of questions in the quiz
	private int numCorrect; // number of questions that the user answers correctly
	private double quizScore; // a double for percentage of correct answers
	private ArrayList<Question> quiz; // ArrayList of quiz questions
	private int currentQuestionIndex; // the index of the current question in the quiz ArrayList
	private Stage primaryStage; // the primary stage of the program
	private QuestionScreen qs; // the question screen which will be updated dynamically
	
	/**
	 * Constructor for QuizDriver object, which initializes fields.
	 */
	QuizDriver() {
		numQuestions = 0;
		numCorrect = 0;
		quiz = new ArrayList<Question>();
		currentQuestionIndex = 0;
	}
	
	/**
	 * When the user chooses topic and number of questions on the Opening Screen, this method will
	 * be used to randomly choose questions of the given topic from the HashTable.
	 * 
	 * Exceptions will likely never happen, as the "topic" parameter is passed as a choice from a
	 * drop-down list containing topics in the table.
	 * 
	 * @param topic is the user-chosen question topic
	 * @param numberOfQuestions is the number of questions to be added to the quiz
	 * @throws KeyNotFoundException when there are no topics in the question HashTable with the given topic (should not happen)
	 * @throws IllegalNullKeyException when the given topic is null (should not happen)
	 */
	void addQuestions(ObservableList<String> topics, int numberOfQuestions) throws IllegalNullKeyException, KeyNotFoundException {
		// create an ArrayList for all possible quiz questions from chosen topics
		ArrayList<Question> allQuestionsForChosenTopics = new ArrayList<Question>();
		for (int i = 0; i < topics.size(); i++) {
			allQuestionsForChosenTopics.addAll(Main.questionTable.getQuestionsForTopic(topics.get(i)));
		}
		if (allQuestionsForChosenTopics.size() < numberOfQuestions) { // not enough questions for this topic
			numberOfQuestions = allQuestionsForChosenTopics.size();
		}
		Random r = new Random(); // random object to randomly select questions from question HashTable
		Question addToQuiz;
		for (int i = 0; i < numberOfQuestions; i++) {
			// choose questions randomly using Random.nextInt() method
			addToQuiz = allQuestionsForChosenTopics.get(r.nextInt(allQuestionsForChosenTopics.size()));
			allQuestionsForChosenTopics.remove(addToQuiz);
			quiz.add(addToQuiz);
		}
	}
	
	/**
	 * This method sets up the quiz by updating the screen and initializing some more variables.
	 */
	public void startQuiz(Stage primaryStage) {
		numQuestions = quiz.size();
		this.primaryStage = primaryStage;
		Group parent = new Group();
		qs = new QuestionScreen(parent);
		primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
		primaryStage.setTitle("Question " + 1 + "/" + numQuestions);
	}
	
	/**
	 * changes the question when the user chooses to move on.
	 */
	void updateScreen() {
		// move to next question
		QuestionScreen.group.getSelectedToggle().setSelected(false); // untoggle chosen answer
		currentQuestionIndex++;
		// reset question screen
		if (currentQuestionIndex != numQuestions) { // current index = number of q's only on last q
			QuestionScreen.root.getChildren().remove(QuestionScreen.questionLabel);
			QuestionScreen.root.getChildren().remove(QuestionScreen.choices);
			QuestionScreen.root.getChildren().remove(QuestionScreen.nextButton);
			QuestionScreen.root.getChildren().remove(QuestionScreen.resultLabel);
			if (QuestionScreen.root.getChildren().contains(QuestionScreen.qImageView)) {
				QuestionScreen.root.getChildren().remove(QuestionScreen.qImageView);
			}
			// update scene
			primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
			primaryStage.setTitle("Question " + (currentQuestionIndex + 1) + "/" + numQuestions);
		}
	}
	
	/**
	 * Getter method for the user's quiz score.
	 * @return the user's score.
	 */
	public double getQuizScore() {
		return (double)numCorrect/numQuestions;
	}
	
	/**
	 * Getter method for the number of questions that the user answered correctly.
	 * @return the number of questions that the user answered correctly
	 */
	public int getNumCorrect() {
		return numCorrect;
	}
	
	/**
	 * Getter method for the total number of questions in the quiz.
	 * @return the total number of questions in the quiz.
	 */
	public int getNumQuestions() {
		return numQuestions;
	}
	
	/**
	 * This method tells the user if they answered the question right, as well as doing the
	 * back-end functions including incrementing the user's score and preparing for the next
	 * question.
	 */
	public void checkAnswer() {
		// make sure an answer is selected
		if (QuestionScreen.group.getSelectedToggle() == null) {
			QuestionScreen.resultLabel.setText("Choose an answer!");
			return;
		}
		
		// check for correct answer
		boolean correct = false;
		if (quiz.get(currentQuestionIndex).getAnswer().equals(qs.getSelectedAnswer())) {
			numCorrect++;
			correct = true;
		}
		if (correct)
			QuestionScreen.resultLabel.setText("Correct!");
		else 
			QuestionScreen.resultLabel.setText("Incorrect.");
		// update screen to prepare for next question or submitting quiz
		if (currentQuestionIndex == numQuestions - 1)
			QuestionScreen.nextButton.setText("Submit Quiz");
		else
			QuestionScreen.nextButton.setText("Next Question");
	}
	
}
