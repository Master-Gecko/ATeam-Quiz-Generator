package application;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileInOut {
	F
	String filepath = jsonFilepath;
	Object obj = new JSONParser().parse(new FileReader(filepath));
	JSONObject jo = (JSONObject) obj; // makes new JSONObject
	JSONArray packages = (JSONArray) jo.get("packages"); // finds the start of packages data
	for (int i = 0; i < packages.size(); i++) { // iterates through each package in packages data
		JSONObject jsonPackage = (JSONObject) packages.get(i); // gets individual package data
		String name = (String) jsonPackage.get("name"); // gets name of individual package
		graph.addVertex(name); // adds vertex to graph
		JSONArray dependencies = (JSONArray) jsonPackage.get("dependencies"); // gets JSONArray of dependencies for
																				// individual packages
		String[] arr = new String[dependencies.size()];
		for (int j = 0; j < arr.length; j++) {
			graph.addEdge(name, dependencies.get(j).toString()); // adds dependencies to graph
			// System.out.println("name:" + name + "dependencies: " +
			// dependencies.get(j).toString());
		}
	}
}
