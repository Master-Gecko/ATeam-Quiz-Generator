package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * File in class that takes a string for the input file and hash table and
 * parses through all the json data to import each question
 * 
 * @author odmas
 *
 */
public class FileIn {
	private ArrayList<Question> questions = new ArrayList<Question>();

	public FileIn(String filePath, HashTable<Question> hash) throws FileNotFoundException, IOException, ParseException {
		JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader(filePath));
		JSONArray packages = (JSONArray) jo.get("questionArray"); // finds the start of packages data
		for (int i = 0; i < packages.size(); i++) { // iterates through each package in packages data
			JSONObject jsonPackage = (JSONObject) packages.get(i); // gets individual package data
			String metadata = (String) jsonPackage.get("meta-data");
			String questionText = (String) jsonPackage.get("questionText");
			String topic = (String) jsonPackage.get("topic");
			String image = (String) jsonPackage.get("image");
			JSONArray choiceArray = (JSONArray) jsonPackage.get("choiceArray");
//			System.out.println("metadata: " + metadata + " questionText: " + questionText + " topic: " + topic + " image: " + image + " choiceArrayLength: " + choiceArray.size());
			// TODO: must convert coiceArray to arraylist of answers
			ArrayList<Answer> answers = new ArrayList<Answer>();
			for (int j = 0; j < choiceArray.size(); j++) {
				JSONObject answer = (JSONObject) choiceArray.get(j);
				Boolean correct = false;
				if (answer.get("isCorrect").equals("T"))
					correct = true;
				String answerText = (String) answer.get("choice");
				answers.add(new Answer(correct, answerText));
			}
			questions.add(new Question(topic, metadata, questionText, image, answers));
		}
		for (Question q : questions) {
			try {
				//insert each question into the hash table
				hash.insertQuestion(q);
			} catch (IllegalNullKeyException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
