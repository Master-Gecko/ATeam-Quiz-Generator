package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Output to a designate file. Output file handler handles all the user input.
 * This class only formats the data into a json file. Potential problem: json
 * output print it all in one line but is still fully functional
 * 
 * @author odmas
 *
 */
public class FileOut {
	private List<Question> questions;
	private ArrayList<JSONObject> questionArray;

	public FileOut(String filePath, HashTable<Question> hashTable)
			throws FileNotFoundException, IOException, ParseException {
//		System.out.println(hashTable.getAllTopics());
		JSONObject JSONQuestionArray = new JSONObject();
		questionArray = new ArrayList<JSONObject>();
		for (String topic : hashTable.getAllTopics()) { // find all topics then find all questions for each topi
			try {
				questions = hashTable.getQuestionsForTopic(topic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Question q : questions) { // get info for each question
				JSONObject question = new JSONObject();
				question.put("meta-data", "unused");
				question.put("questionText", q.getQuestion());
				question.put("topic", q.getTopic());
				question.put("image", q.getImagePath());
				JSONArray answers = new JSONArray();
				for (Answer a : q.getAnswerList()) { // formats each answer
					JSONObject curr = new JSONObject();
					if (a.isCorrect())
						curr.put("isCorrect", "T");
					else
						curr.put("isCorrect", "F");
					curr.put("choice", a.toString());
					answers.add(curr);
				}
				question.put("choiceArray", answers);
				questionArray.add(question);
			}
		}
		JSONQuestionArray.put("questionArray", questionArray);
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)); // export to file
		writer.write(JSONQuestionArray.toString());
		writer.close();
	}
}
