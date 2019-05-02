package application;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;

/**
 * 
 * Filename: ParseEntry.java Project: ATeam Quiz Generator Course: cs400 Spring
 * 2019 Authors: Titus Smith, Owen Massey
 * 
 * Called by InsertScreenHandler, creates question and answers object and then
 * adds them to the question hash table
 */
public class ParseEntry {

	private String topic;
	private String question;
	private String answerUnparsed;
	private ArrayList<Answer> ParsedAnswers;

	/**
	 * Constructor
	 * @param topic
	 * @param question
	 * @param answerUnparsed
	 */
	public ParseEntry(String topic, String question, String answerUnparsed) {
		this.topic = topic;
		this.question = question;
		this.answerUnparsed = answerUnparsed;
		this.ParsedAnswers = new ArrayList<Answer>();
		// doesn't have metadata or image path
	}
	/**
	 * Formats question, returns false if an exception is thrown
	 * Adds answers if not
	 * @return
	 */
	boolean formatQuestion() {
		String[] answers = answerUnparsed.split("\n");
		try {
			for (String ans : answers) {
				String[] answerParsed = ans.split(",");
				if (answerParsed[0].toUpperCase().equals("T"))
					ParsedAnswers.add(new Answer(true, answerParsed[1]));
				else
					ParsedAnswers.add(new Answer(false, answerParsed[1]));
			}
			return true;
		}catch(Exception e) {//If exception is thrown, then program "crashed"			
			return false;//Inform handler that question crashed
		}
	}

	/**
	 * Getter method for the test class
	 * @return
	 */
	public String getQuestion() {
		return "Topic: " + topic + " Question: " + question + " Answers: " + ParsedAnswers.toString();
	}
	
	public Question getQuestionObject() {
		return new Question(topic,"unused",question,"null",ParsedAnswers);
	}
}
