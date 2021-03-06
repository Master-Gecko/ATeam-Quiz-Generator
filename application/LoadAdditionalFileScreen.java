package application;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * 
 * Filename:   LoadAdditionalFileScreen.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Sammy Zopf
 * 
 */
public class LoadAdditionalFileScreen extends Scene {
  private Scene lafScene;
  private String title;
  
  static Button fileButton;
  static Button importButton;
  static Button returnButton;
  
  public LoadAdditionalFileScreen(Parent parent) {
    super(parent);

    this.title = "Load Additional File Screen";
    GridPane root = new GridPane();
    Label insertFile = new Label("Name/Path of File: ");
    TextField filePath = new TextField();
    filePath.setMinWidth(300);
    filePath.setMaxWidth(400);
    HBox top = new HBox();
    top.setAlignment(Pos.CENTER_LEFT);
    top.setPrefWidth(500);
    
    top.getChildren().addAll(insertFile, filePath);
    root.setPadding(new Insets(25));
    root.setVgap(10);
    root.add(top, 0, 1);
    
    //Pick a File Button
    fileButton = new Button();
    fileButton.setText("Pick a File From System");
    fileButton.setOnAction(new lafHandler(fileButton, filePath));
    root.add(fileButton, 0, 2);
    
    //Import File Button
    importButton = new Button();
    importButton.setText("Import File");
    importButton.setOnAction(new lafHandler(importButton, filePath));
    root.add(importButton, 0, 3);
    
    //Return button
	returnButton = new Button("Return to Main Menu");
	returnButton.setOnAction(new InsertQuestionScreenHandler(returnButton));
	root.add(returnButton, 0, 4);
	
    Label hint = new Label("NOTE: When searching for a file, provide the relative\rpath from the program's directory.");
    hint.setStyle("-fx-font-style: italic;");
    root.add(hint, 0, 0);
    
    //root.setGridLinesVisible(true);    
    lafScene = new Scene(root, 800, 600);
    lafScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
  }

  /**
   * @return the constructed LAF scene
   */
  public Scene getScene() {
    return this.lafScene;
  }

  /**
   * @return the title of the scene
   */
  public String getTitle() {
    return this.title;
  }
}
