package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

	private int numQuestions;
	private int numCorrect;
	private double quizScore;
	private ArrayList<Question> quiz;
	private int currentQuestionIndex;
	private Stage primaryStage;
	private QuestionScreen qs;
	
	/**
	 * Constructor for QuizDriver object, which initializes fields.
	 */
	QuizDriver() {
		numQuestions = 0;
		numCorrect = 0;
		quiz = new ArrayList<Question>();
		currentQuestionIndex = 0;
		
		// to test QuestionScreen
//		ArrayList<Answer> answers = new ArrayList<Answer>();
//		answers.add(new Answer(true, "right"));
//		answers.add(new Answer(false, "wrong"));
//		quiz.add(new Question("test", "This is a test question?", "doggy.JPG", answers));
//		quiz.add(new Question("test", "This is also test question?", "doggy.JPG", answers));
//		ArrayList<Answer> answers2 = new ArrayList<Answer>(answers);
//		answers2.add(new Answer(false, "third option"));
//		quiz.add(new Question("test", "This is a test question 3?", "none", answers2));
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
	void addQuestions(String topic, int numberOfQuestions) throws IllegalNullKeyException, KeyNotFoundException {
		if (Main.questionTable.getQuestionsForTopic(topic).size() < numberOfQuestions) { // not enough questions for this topic
			throw new IndexOutOfBoundsException();
		}
		ArrayList<Question> topicQuestions = new ArrayList<Question>(Main.questionTable.getQuestionsForTopic(topic));
		Random r = new Random(); // random object to randomly select questions from question HashTable
		Question addToQuiz;
		for (int i = 0; i < numberOfQuestions; i++) {
			addToQuiz = topicQuestions.get(r.nextInt(topicQuestions.size()));
			topicQuestions.remove(addToQuiz);
			quiz.add(addToQuiz);
		}
	}
	
	/**
	 * this method will serve as the driver for the Quiz.
	 */
	public void startQuiz(Stage primaryStage) {
		numQuestions = quiz.size();
		this.primaryStage = primaryStage;
		Group parent = new Group();
		qs = new QuestionScreen(parent);
		primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
		primaryStage.setTitle("Question " + 1 + "/" + numQuestions);
		if (quiz.size() == 1) {
			QuestionScreen.nextButton.setText("Submit Quiz");
		}
	}
	
	/**
	 * changes the question when the user chooses to move on.
	 */
	void updateScreen() {
		// make sure an answer is selected
		if (qs.group.getSelectedToggle() == null) {
			QuestionScreen.warningLabel.setText("Choose an answer!");
			return;
		}
		QuestionScreen.warningLabel.setText("");
		
		// check if right answer
		for (int i = 0; i < qs.getNumberOfChoices(); i++) {
			if (quiz.get(currentQuestionIndex).getAnswer().equals(qs.getSelectedAnswer())) {
				numCorrect++;
				i = qs.getNumberOfChoices();
			}
		}
		
		// move to next question
		QuestionScreen.group.getSelectedToggle().setSelected(false);
		currentQuestionIndex++;
		if (currentQuestionIndex != numQuestions) {
			QuestionScreen.root.getChildren().remove(QuestionScreen.questionLabel);
			QuestionScreen.root.getChildren().remove(QuestionScreen.choices);
			QuestionScreen.root.getChildren().remove(QuestionScreen.nextButton);
			QuestionScreen.root.getChildren().remove(QuestionScreen.warningLabel);
			if (QuestionScreen.root.getChildren().contains(QuestionScreen.qImageView)) {
				QuestionScreen.root.getChildren().remove(QuestionScreen.qImageView);
			}
			primaryStage.setScene(qs.getScene(quiz.get(currentQuestionIndex)));
			primaryStage.setTitle("Question " + (currentQuestionIndex + 1) + "/" + numQuestions);
			if (currentQuestionIndex == numQuestions - 1)
				qs.nextButton.setText("Submit Quiz");
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
	
}
