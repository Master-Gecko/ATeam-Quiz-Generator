package application;

/**
 * 
 * Filename:   Answer.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Sammy Zopf 
 * 
 */
public class Answer {
	private boolean isCorrect;
	private String answer;
	
	public Answer(boolean isCorrect, String answer) {
		this.isCorrect = isCorrect;
		this.answer = answer;
	}
	
	/**
	 * @return true if answer is correct; otherwise false
	 */
	public boolean isCorrect() {
		return isCorrect;
	}
	
	/**
	 * @return the answer as a String
	 */
	@Override
	public String toString() {
		return answer;
	}
}
