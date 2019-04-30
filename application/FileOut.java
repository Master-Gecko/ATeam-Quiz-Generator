package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * adding to master branch
 * 
 * @author odmas
 *
 */
public class FileOut {
	private ArrayList<Question> questions;

	public FileOut(String filePath, HashTable<ArrayList<List<Question>>> hashTable)
			throws FileNotFoundException, IOException, ParseException {
		for (String topic : hashTable.getAllTopics()) {
			try {
				questions = hashTable.getQuestionsForTopic(topic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Object q : questions) {
				JSONObject question = new JSONObject();
				question.put("questionText", 
			}
		}
	}
}
