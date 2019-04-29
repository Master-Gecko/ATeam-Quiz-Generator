package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		quiz = new ArrayList<Question>();
		currentQuestionIndex = 0;
		
		// to test QuestionScreen
//		ArrayList answers = new ArrayList<Answer>();
//		answers.add(new Answer(true, "right"));
//		answers.add(new Answer(false, "wrong"));
//		quiz.add(new Question("test", "This is a test question?", "doggy.JPG", answers));
//		quiz.add(new Question("test", "This is also test question?", "doggy.JPG", answers));
//		numQuestions = 2;
	}
	
	/**
	 * when the user chooses topic and number of questions on the Opening Screen, this method will
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
		ArrayList<Question> topicQuestions = new ArrayList<Question>(Main.questionTable.getQuestionsForTopic(topic));
		Random r = new Random(); 
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
			qs.nextButton.setText("Submit Quiz");
	}
	
	public double getQuizScore() {
		return quizScore;
	}
	
	public int getNumCorrect() {
		return numCorrect;
	}
	
	public int getNumQuestions() {
		return numQuestions;
	}
	
}
