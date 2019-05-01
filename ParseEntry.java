package application;
/**
 * 
 * Filename:   ParseEntry.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Titus Smith
 * 
 * Called by InsertScreenHandler, creates question and answers 
 * object and then adds them to the question hash table
 */
public class ParseEntry {
	
	private String topic;
	private String question;
	private String answerUnparsed;
	
	/**
	 * Constructor
	 * @param topic
	 * @param question
	 * @param answerUnparsed
	 */
	public ParseEntry(String topic, String question,
			String answerUnparsed){
		this.topic = topic;
		this.question = question;
		this.answerUnparsed = answerUnparsed;
	}
	
	//Needs to call //Main.qd.addQuestions(topic, numberOfQuestions);
		//doesn't have metadata or image path
	//Check for a parse exception?
}
