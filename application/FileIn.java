package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileIn {
	public FileIn(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader(filePath));
		JSONArray packages = (JSONArray) jo.get("questionArray"); // finds the start of packages data
		for (int i = 0; i < packages.size(); i++) { // iterates through each package in packages data
			JSONObject jsonPackage = (JSONObject) packages.get(i); // gets individual package data
			String metadata = (String) jsonPackage.get("meta-data");
			String questionText = (String) jsonPackage.get("questionText");
			String topic = (String) jsonPackage.get("topic");
			String image = (String) jsonPackage.get("image");
			JSONArray choiceArray = (JSONArray) jsonPackage.get("choiceArray");
			System.out.println("metadata: " + metadata + " questionText: " + questionText + " topic: " + topic + " image: " + image + " choiceArrayLength: " + choiceArray.size());
		}
	}
}
