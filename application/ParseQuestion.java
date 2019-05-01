 package application;

import java.util.ArrayList;

public class ParseQuestion {
	private String topic;
	private String question;
	private String answerUnparsed;
	private ArrayList<Answer> ParsedAnswers;
	
	public ParseQuestion(String topic, String question, String answerUnparsed) {
		this.topic = topic;
		this.question = question;
		this.answerUnparsed = answerUnparsed;
		this.ParsedAnswers = new ArrayList<Answer>();
		String[] answers = answerUnparsed.split("\n");
		for (String ans : answers) {
			String[] answerParsed = ans.split(",");
			if (answerParsed[0].toUpperCase().equals("T"))
				ParsedAnswers.add(new Answer(true,answerParsed[1]));
			else 
				ParsedAnswers.add(new Answer(false, answerParsed[1]));
		}
//		try {
//			Main.qd.addQuestions(topic, ParsedAnswers.size());
//		} catch (IllegalNullKeyException | KeyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public String getQuestion() {
		return "Topic: " + topic + " Question: " + question + " Answers: " + ParsedAnswers.toString();
	}
}
