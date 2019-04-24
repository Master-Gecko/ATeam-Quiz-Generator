import java.util.List;

/**
 * 
 * Filename:   Question.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Sammy Zopf 
 * 
 */
public class Question {
	private String topic;
	private String question;
	private String imagePath;
	private List<Answer> answerList;
	private String answer;
	
	public Question(String topic, String question, String imagePath, List<Answer> answerList) {
		this.topic = topic;
		this.question = question;
		this.imagePath = imagePath;
		this.answerList = answerList;
	}

	public String getTopic() {
		return topic;
	}

	public String getQuestion() {
		return question;
	}

	public String getImagePath() {
		return imagePath;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}
	
	public String getAnswer() {
		for (Answer answer : answerList) {
			if (answer.isCorrect()) {
				this.answer = answer.toString();
			}
		}
		return this.answer;
	}
	
}
